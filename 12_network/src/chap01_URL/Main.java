package chap01_URL;

import java.net.MalformedURLException;
import java.net.URL;

public class Main {
    public static void main(String[] args) {

        try {
            URL url = new URL("https://www.example.com:8123/list?page=1&sort=DESC#memo");

            // 파싱

            System.out.println("Protocol: " + url.getProtocol());
            System.out.println("Host: " + url.getHost());
            System.out.println("Port: " + url.getPort());
            System.out.println("Path: " + url.getPath());
            System.out.println("Query: " + url.getQuery());
            System.out.println("Reference: " + url.getRef());



        }catch (MalformedURLException e) {
            System.out.println("URL 형식이 잘못되었습니다.");

        }
    }
}
