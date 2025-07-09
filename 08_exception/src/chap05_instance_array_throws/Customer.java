package chap05_instance_array_throws;

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
  
  public void addToCart(Product product) {  // throws RuntimeException 생략
    // 예외 발생 후 예외 회피
    if (cart == null) {
      throw new RuntimeException("cart를 먼저 준비하세요.");
    }
    cart.addProduct(product);  // Cart의 addProduct()이 던진 예외를 다시 회피
  }
  
  public void removeFromCart(int idx) {  // throws RuntimeException 생략
    Product removed = cart.removeProduct(idx);  // Cart의 removeProduct()이 던진 예외를 다시 회피
    if (removed != null) {
      JOptionPane.showMessageDialog(null, removed.getName() + " 제품이 Cart에서 제거되었습니다.");
    }
  }
  
  public String purchase() {  // throws RuntimeException 생략
    // 예외 발생 후 예외 회피 (예외 회피 시 null 반환)
    if (cart == null) {
      throw new RuntimeException("cart가 없어서 구매할 수 없습니다.");
    }
    int count = cart.getCount();
    if (count == 0) {
      throw new RuntimeException("cart에 담긴 Product이 없어서 구매할 수 없습니다.");
    }
    String receipt = "구디마트 영수증\n";  //----- 영수증의 첫 문구
    int total = 0;  //---------------------------- 구매총액
    Product[] products = cart.getProducts();  //-- Cart에 저장된 Product[] 배열
    for (int i = 0; i < count; i++) {  //--------- 구매한 Product 개수만큼 반복
      Product product = products[i];  //---------- 구매한 개별 Product
      int price = product.getPrice();  //--------- 개별 Product의 가격
      total += price;  //------------------------- 개별 Product 가격을 구매총액에 누적
      receipt += product.getName();  //----------- 구매내역을 영수증에 기록
      receipt += "......";
      receipt += price + "\n";  //---------------- 구매내역을 영수증에 기록
    }
    if (total > money) {  //---------------------- 돈이 부족한 상황
      throw new RuntimeException("돈이 부족해서 구매할 수 없습니다.");
    }
    money -= total;  //--------------------------- 고객이 구매총액을 내고 구매완료
    receipt += "구매총액......" + total + "\n";  // 영수증 마지막 문구
    return receipt;
  }
  
}
