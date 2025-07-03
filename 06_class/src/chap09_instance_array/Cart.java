package chap09_instance_array;

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
        if (product == null) {
            JOptionPane.showMessageDialog(null, "전달된 Product이 없습니다");
        }
        if (count == LIMIT) {
            JOptionPane.showMessageDialog(null, "더 이상 Cart에 담을 수 없습니다.");
            return;
        }
        products[count++] = product;
    }
    
    public Product removeProduct(int idx){
        if(count == 0){
            JOptionPane.showMessageDialog(null, "Cart가 비어있습니다.");
            return null;
        }
        if (idx < 0 || idx >= count) {
            JOptionPane.showMessageDialog(null, idx + "는 없는 인덱스입니다.");
            return null;
        }
        Product product = products[idx];
        // System.arraycopy를 사용하여 삭제된 인덱스(idx) 이후의 요소들을 한 칸씩 앞으로 이동시킨다
        System.arraycopy(products, idx + 1, products, idx, count - idx - 1);
        // 카트의 마지막 요소를 null로 설정하고 count를 1 감소시킨다 
        products[--count] = null;
        return product;
    }
}
