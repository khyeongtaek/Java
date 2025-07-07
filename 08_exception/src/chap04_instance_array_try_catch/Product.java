package chap04_instance_array_try_catch;

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
        // 가격을 음수로 설정하면 예외가 발생합니다.
        try {
            if (price < 0) {
                throw new RuntimeException("가격은 음수가 될 수 없습니다.");
            }
            this.price = price;

        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

}
