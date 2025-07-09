package chap01_string.b_stringbuilder.instance_array;

import java.util.HashMap;
import java.util.Map;

public class Main {

  public static void main(String[] args) {
    
    // Product 진열하기
    Map<String, Object> product1 = new HashMap<>();
    product1.put("name", "양파1.5kg");
    product1.put("price", 3000);
    Map<String, Object> product2 = new HashMap<>();
    product2.put("name", "고등어1손");
    product2.put("price", 5000);
    Map<String, Object> product3 = new HashMap<>();
    product3.put("name", "한돈앞다리1kg");
    product3.put("price", 15000);
    Map<String, Object> product4 = new HashMap<>();
    product4.put("name", "블랙앵거스살치살500g");
    product4.put("price", 20000);
    Map<String, Object> product5 = new HashMap<>();
    product5.put("name", "꼬마돈까스");
    product5.put("price", 9000);

    // Cart 준비하기
    Cart cart1 = new Cart();
    
    // Customer 입장
    Customer customer = new Customer(500000);
    
    // Customer가 Cart 취득
    customer.setCart(cart1);
    
    // 쇼핑
    customer.addToCart(product1);
    customer.addToCart(product2);
    customer.addToCart(product3);
    customer.addToCart(product4);
    customer.addToCart(product5);
    
    customer.removeFromCart(2);
    
    // 구매
    String receipt = customer.purchase();
    
    // 구매내역 확인
    if (receipt != null) {
      System.out.println(receipt);  // 구매 Product 목록 + 총 구매금액
      System.out.println("남은 돈: " + customer.getMoney());
    }
    
  }

}
