package chap05_instance_array_throws;

public class Product {
    private String name;
    private int price;

    public Product() {
    }

    public Product(String name, int price) {
        super();
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
            if (price < 0) {
                throw new RuntimeException("가격은 음수가 될 수 없습니다.");
            }
            this.price = price;

    }

}
