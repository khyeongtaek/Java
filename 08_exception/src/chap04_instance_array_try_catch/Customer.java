package chap04_instance_array_try_catch;

import javax.swing.*;

public class Customer {
    private int money;
    private Cart cart;

    public Customer(int money, Cart cart) {
        this.money = money;
        this.cart = cart;
    }

    public Customer(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        try {
            if (money < 0) {
                throw new RuntimeException(money + "원은 잘못된 돈입니다.");
            }
            this.money = money;

        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    void show(String msg) {
        JOptionPane.showMessageDialog(null, msg);
    }

    public void addToCart(Product product) {

        try {
            if (cart == null) {
                throw new RuntimeException("카트가 없음");
            }

            if (money >= product.getPrice()) {
                cart.addProduct(product);
                money -= product.getPrice();
            } else {
                show("잔액이 부족합니다.");
            }

        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    public void removeFromCart(int idx) {
        Product product = cart.removeProduct(idx);
        if (product != null) {
            show(product.getName() + " 제품이 Cart에서 제거되었습니다.");
            money += product.getPrice();
        }
    }

    public String purchase() {

        String receipt = null;
        try {
            int count = cart.getCount();

            if (cart == null) {
                throw new RuntimeException("cart가 없어서 구매 할 수 없습니다.");
            } else if (count == 0) {
                throw new RuntimeException("cart에 담긴 product이 없어서 구매할 수 없습니다.");
            }

            receipt = "===구디마트 영수증===\n";
            Product[] products = cart.getProducts();

            int total = 0;
            for (int i = 0; i < count; i++) {
                receipt += products[i].getName() + " : " + products[i].getPrice() + "원\n";
                total += products[i].getPrice();
            }

            if (money < total) {
                throw new RuntimeException("잔액이 부족하여 구매 불가능");
            } else {
                money -= total;
                receipt += "====================\n";
                receipt += "총액 : " + total + "원";
            }


        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        return receipt;
    }


}
