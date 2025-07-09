package chap06_gson;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.reflect.TypeToken;
import com.google.gson.Gson;

/*
 * GSON
 *
 * 1. Google에서 개발한 Java 기반의 오픈소스 라이브러리
 * 2. JSON 데이터를 Java 객체로 변환 하거나 Java 객체를 JSON 형식으로 변환 하는 라이브러리
 * 3. 직렬화(Serializtion)      : Java 객체 → JSON 문자열, toJson() 메소드 활용
 * 4. 역직렬화(Deserialization) : JSON 문자열 → Java 객체, fromJson() 메소드 활용
 */
public class Main {

    public static void objectToJson() {

        // 직렬화 : Java 객체를 JSON 문자열로 변환하기
        // Java 객체
        Movie movie = new Movie();
        movie.setTitle("파묘");
        movie.setDirector("장지환");
        movie.setActors(Arrays.asList("최민식", "김고은", "유해진", "이도현"));
        movie.setStars(9.5);
        // 직렬화
        String json = new Gson().toJson(movie);
        // 확인
        System.out.println(json);
    }

    public static void jsonToObject() {

        String json = "{\"title\":\"파묘\",\"director\":\"장지환\",\"actors\":[\"최민식\",\"김고은\",\"유해진\",\"이도현\"],\"stars\":9.5}";

        Movie movie = new Gson().fromJson(json, Movie.class);

        System.out.println(movie);



    }

    public static void mapToJson() {

        Map<String, Object> map = new HashMap<>();

        map.put("title", "파묘");
        map.put("director", "wkdwlghks");
        map.put("author", Arrays.asList("최민식", "김고은", "유해진", "이도현"));
        map.put("stars", 9.5);

        Gson gson = new Gson();
        String json = gson.toJson(map);

        System.out.println(json);


    }

    public static void jsonToMap() {
        String json = "{\"title\":\"파묘\",\"director\":\"장지환\",\"actors\":[\"최민식\",\"김고은\",\"유해진\",\"이도현\"],\"stars\":9.5}";

        Gson gson = new Gson();
        Type type = new TypeToken<Map<String, Object>>(){}.getType();
        Map<String, Object> map = gson.fromJson(json, type);

        System.out.println(map);





    }

    public static void main(String[] args) {

        objectToJson();
        jsonToObject();
        mapToJson();
        jsonToMap();

    }

}
