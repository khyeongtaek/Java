package chap07_access_modifier;

/*
    Access Modifier (접근 지시자)
    
    1. 클래스 내의 멤버(필드, 메소드)에 접근할 수 있는 권한을 의미합니다.
    2. 종류
        1) public       : 누구나 접근할 수 있다.
        2) protected    : 동일 패키지에 있거나, 상속 관계인 경우 접근할 수 있음.
        3) default      : 동일 패키지에 있으면 접근할 수 있음. (default 키워드는 존재하지 않음, package 권한이라고도 함.)
        4) private      : 클래스 내부에서만 접근할 수 있음.
        
    3. 멤버의 권한
        1) 필드    : private (정보 은닉)
        2) 메소드  : public
 */

import chap06_constructor.Brand;

public class Car {

    private String model;
    private int price;
    private Brand brand;

    public Car() {
        this("Sorento", 1000000, new Brand());
    }


    public Car(String model, int price) {
        this.model = model;
        this.price = price;
        this.brand = new Brand("기본 브랜드", "한국");
    }

    public Car(String model, int price, Brand brand) {
        this(model, price);
        this.brand = brand;
    }

    public Car(String model, int price, String brandName, String brandNation) {
        this(model, price, new Brand(brandName, brandNation));
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public void printInfo() {
        System.out.println(model + ", " + price);
        brand.printInfo();
    }


}
