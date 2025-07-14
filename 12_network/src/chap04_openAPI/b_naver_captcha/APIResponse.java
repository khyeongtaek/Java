package chap04_openAPI.b_naver_captcha;

public class APIResponse {
    private boolean result;
    private String responseTime;

    @Override
    public String toString() {
        return "검증결과: "+ result+"\n"
                + "입력시간: " + responseTime+ "\n";
    }
}
