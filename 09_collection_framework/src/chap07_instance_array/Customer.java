package chap07_instance_array;

import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

public class Customer {

  // 필드
  private int money;
  private Cart cart;
  
  // 생성자
  public Customer(int money) {
    this.money = money;
  }

  // 메소드
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
  
  public void addToCart(Map<String, Object> product) {
    if (cart == null) {
      JOptionPane.showMessageDialog(null, "cart를 먼저 준비하세요.");
      return;
    }
    cart.addProduct(product);
  }
  
  public void removeFromCart(int idx) {
    Map<String, Object> removed = cart.removeProduct(idx);
    if (removed != null) {
      JOptionPane.showMessageDialog(null, removed.get("name") + " 제품이 Cart에서 제거되었습니다.");
    }
  }
  
  public String purchase() {
    if (cart == null) {
      JOptionPane.showMessageDialog(null, "cart가 없어서 구매할 수 없습니다.");
      return null;
    }
    List<Map<String, Object>> products = cart.getProducts();
    int count = products.size();
    if (count == 0) {
      JOptionPane.showMessageDialog(null, "cart에 담긴 Product이 없어서 구매할 수 없습니다.");
      return null;
    }
    String receipt = "구디마트 영수증\n";  //----- 영수증의 첫 문구
    int total = 0;  //---------------------------- 구매총액
    for (int i = 0; i < count; i++) {  //--------- 구매한 Product 개수만큼 반복
      Map<String, Object> product = products.get(i);  //---------- 구매한 개별 Product
      int price = (int) product.get("price");  //--------- 개별 Product의 가격
      total += price;  //------------------------- 개별 Product 가격을 구매총액에 누적
      receipt += (String) product.get("name");  //----------- 구매내역을 영수증에 기록
      receipt += "......";
      receipt += price + "\n";  //---------------- 구매내역을 영수증에 기록
    }
    if (total > money) {  //---------------------- 돈이 부족한 상황
      JOptionPane.showMessageDialog(null, "돈이 부족해서 구매할 수 없습니다.");
      return null;
    }
    money -= total;  //--------------------------- 고객이 구매총액을 내고 구매완료
    receipt += "구매총액......" + total + "\n";  // 영수증 마지막 문구
    return receipt;
  }
  
}
