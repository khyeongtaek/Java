package chap09_instance_array;

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
        this.money = money;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
    
    void show(String msg){
        JOptionPane.showMessageDialog(null, msg);
    }

    public void addToCart(Product product) {
        if (product == null) {
            return;
        }
        if (money >= product.getPrice()) {
            cart.addProduct(product);
            money -= product.getPrice();
        } else {
            show("잔액이 부족합니다.");
        }
    }

    public void removeFromCart(int idx){
        Product product = cart.removeProduct(idx);
        if(product != null){
            show(product.getName() + " 제품이 Cart에서 제거되었습니다.");
            money += product.getPrice();
        }
    }

    public String purchase() {
        int count = cart.getCount();

        if (cart == null) {
            show("cart가 없어서 구매 할 수 없습니다.");
            return null;
        } else if (count == 0) {
            show("cart에 담긴 product이 없어서 구매할 수 없습니다.");
            return null;
        }

        String receipt = "===구디마트 영수증===\n";
        Product[] products = cart.getProducts();

        int total = 0;
        for (int i = 0; i< count; i++){
            receipt += products[i].getName() + " : " + products[i].getPrice() + "원\n";
            total += products[i].getPrice();
        }

        if (money < total) {
            show("잔액이 부족하여 구매 불가능");
        } else {
            money -= total;
            receipt += "====================\n";
            receipt += "총액 : " + total + "원";
        }

        return receipt;
    }


}
