package chap05_map;


import java.util.HashMap;
import java.util.Map;

public class Main {


    public static void mutable(){
        Map<String, Object> map = new HashMap<>();

        map.put("title", "어린왕자");
        map.put("author", "형택쥐베뤼");
        map.put("isBestSeller", true);
        map.put("price", 10000);
        map.put("price", 100000);

        System.out.println(map.get("title"));
        System.out.println(map.get("author"));
        System.out.println(map.get("isBestSeller"));
        System.out.println(map.get("price"));

        if (map.get("isBestSeller") instanceof Boolean && (Boolean) map.get("isBestSeller")) {
            System.out.println("BEST SELLER!");
        }else {
            System.out.println("NORMAL SELLER..");
        }

    }

    public static void immutable(){

        Map<String, Object> map = Map.of(
                "name", "kim",
                "age",30
                );

        map.put("tel", "02-1234-5678");
        map.put("name", "choi");
        map.remove("name");
    }

     public static void traversal(){
        Map<String, Object> map = new HashMap<>();


    }

    public static void main(String[] args) {
        mutable();
        immutable();
        traversal();
    }
}
