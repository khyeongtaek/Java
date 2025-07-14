package chap04_openAPI.b_naver_captcha;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;

public class Main {
    public static void main(String[] args) {
        try {
            String captchaKey = NaverOpenAPI.captchaKey();
            if (NaverOpenAPI.captchaImage(captchaKey)) {
                NaverOpenAPI.validateInput(captchaKey);
            }
        } catch (UnsupportedEncodingException e) {
            System.out.println("검색어 인코딩 실패");
        } catch (MalformedURLException e) {
            System.out.println("잘못된 형식의 API URL");
        } catch (IOException e) {
            System.out.println("API 요청 또는 응답 실패");
        } catch (Exception e) {
            System.out.println("알 수 없는 예외 발생");
        }
    }
}
