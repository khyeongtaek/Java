package chap04_openAPI.a_naver_search;

import com.google.gson.Gson;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class NaverOpenAPI {
    public static final String CLIENT_ID = "qFntfNCzavr5euZNhehv";
    public static final String CLIENT_SECRET = "8cjvh6Tug6";

    public static void naverBookSearch() throws IOException {

        Scanner sc = new Scanner(System.in);
        System.out.print("책 검색 API입니다. 검색할 내용을 입력하세요 >>> ");
        String query = sc.nextLine();

        // 요청
        String apiURL = "https://openapi.naver.com/v1/search/book.json?query=" + URLEncoder.encode(query, StandardCharsets.UTF_8);
        URL url = new URL(apiURL);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();

        con.setRequestMethod("GET");
        con.setRequestProperty("X-Naver-Client-Id", CLIENT_ID);
        con.setRequestProperty("X-Naver-Client-Secret", CLIENT_SECRET);
        con.connect();
        
        int responseCode = con.getResponseCode();

        BufferedReader in;

        if(responseCode == HttpURLConnection.HTTP_OK) {
            in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        }else {
            in = new BufferedReader(new InputStreamReader(con.getErrorStream()));
        }

        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = in.readLine()) != null) {
            sb.append(line);
        }

        Gson gson = new Gson();
        ApiResponse response = gson.fromJson(sb.toString(), ApiResponse.class);
        List<Item> itemList = response.getItems();

        for (Item item : itemList) {
            System.out.println("제목: "+ item.getTitle());
            System.out.println("저자: "+ item.getAuthor());
            System.out.println("출판사: " + item.getPublisher());
            System.out.println("할인가: "+ item.getDiscount()+"\n");
        }

        
        
        


        in.close();
        con.disconnect();
        sc.close();


    }
}
