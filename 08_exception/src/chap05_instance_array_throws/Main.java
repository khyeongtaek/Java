package chap05_instance_array_throws;

public class Main {
    public static void main(String[] args) {

        // 제품 진열하기
        Product product1 = new Product("김치찌개", 8000);
        Product product2 = new Product("비빔밥", 9000);
        Product product3 = new Product("된장찌개", 7000);
        Product product4 = new Product("불고기", 15000);
        Product product5 = new Product("삼겹살", 16000);

        // Cart 진열하기
        Cart cart1 = new Cart();
        Cart cart2 = new Cart();

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

        // 삭제
        customer.removeFromCart(0);

        // 구매
        String receipt = customer.purchase();
        System.out.println(receipt);


    }
}
