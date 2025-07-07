package chap04_instance_array_try_catch;

import javax.swing.*;

public class Cart {

    private Product[] products;
    private int count;
    private final int LIMIT = 100;

    public Cart() {
        products = new Product[LIMIT];

    }

    public Product[] getProducts() {
        return products;
    }

    public void setProducts(Product[] products) {
        this.products = products;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getLIMIT() {
        return LIMIT;
    }

    public void addProduct(Product product) {
        try {
            if (product == null) {
                throw new RuntimeException("전달된 Product이 없습니다");
            }
            if (count == LIMIT) {
                throw new RuntimeException("더 이상 Cart에 담을 수 없습니다.");
            }
            products[count++] = product;

        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

    }

    public Product removeProduct(int idx) {

        Product product = null;
        try {
            if (count == 0) {
                throw new RuntimeException("Cart가 비어있습니다.");
            }
            if (idx < 0 || idx >= count) {
                throw new RuntimeException(idx + "는 없는 인덱스입니다.");
            }
            product = products[idx];
            // System.arraycopy를 사용하여 삭제된 인덱스(idx) 이후의 요소들을 한 칸씩 앞으로 이동시킨다
            System.arraycopy(products, idx + 1, products, idx, count - idx - 1);
            // 카트의 마지막 요소를 null로 설정하고 count를 1 감소시킨다
            products[--count] = null;
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        return product;

    }
}
