package chap03_URLEncoder;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) {
        String str = "Hello 반갑습니다.";

        try {
            String encoded = encodeUTF8(str);
            System.out.println(encoded);
            String decoded = decodeUTF8(encoded);
            System.out.println(decoded);
        } catch (UnsupportedEncodingException e) {
            System.out.println("지원되지 않는 인코딩입니다.");
        }
    }

    private static String encodeUTF8(String str) throws UnsupportedEncodingException {
        return URLEncoder.encode(str, StandardCharsets.UTF_8);
    }

    private static String decodeUTF8(String str) throws UnsupportedEncodingException{
        return URLDecoder.decode(str, StandardCharsets.UTF_8);
    }



}
