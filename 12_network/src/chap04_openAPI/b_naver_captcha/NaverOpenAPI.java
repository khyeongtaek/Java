package chap04_openAPI.b_naver_captcha;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.Scanner;


public class NaverOpenAPI {
    private static final String CLIENT_ID = "qFntfNCzavr5euZNhehv";
    private static final String CLIENT_SECRET = "8cjvh6Tug6";

    private static HttpURLConnection getConnection(String apiURL) throws Exception{
        URL url = new URL(apiURL);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("X-Naver-Client-Id", CLIENT_ID);
        con.setRequestProperty("X-Naver-Client-Secret", CLIENT_SECRET);

        return con;
    }

    public static String captchaKey() throws Exception{

        String apiURL = "https://openapi.naver.com/v1/captcha/nkey?code=0";

        HttpURLConnection con = getConnection(apiURL);

        BufferedReader in = null;
        int responseCode = con.getResponseCode();
        if(responseCode == HttpURLConnection.HTTP_OK) {
            in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        }else {
            error(con.getErrorStream());
        }

        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = in.readLine()) != null) {
            sb.append(line);
        }
        in.close();
        con.disconnect();

        Gson gson = new Gson();
        Type type = new TypeToken<Map<String, Object>>(){}.getType();
        Map<String,Object> map = gson.fromJson(sb.toString(), type);
        return (String) map.get("key");
    }

    public static boolean captchaImage(String key) throws Exception{
        String apiURL = "https://openapi.naver.com/v1/captcha/ncaptcha.bin?key="+ key;

        HttpURLConnection con = getConnection(apiURL);


        int responseCode = con.getResponseCode();
        BufferedInputStream in = null;
        if(responseCode == HttpURLConnection.HTTP_OK) {
            in = new BufferedInputStream(con.getInputStream());
        }else {
            in = new BufferedInputStream(con.getErrorStream());
            error(con.getErrorStream());
            return false;
        }

        String fileName = System.currentTimeMillis() + ".jpg";
        File file = new File(fileName);
        BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(file));

        byte[] b = new byte[1024];
        int readLine = 0;
        while ((readLine = in.read(b)) != -1) {
            out.write(b, 0, readLine);
        }
        out.close();
        in.close();
        con.disconnect();

        System.out.println("이미지 생성 완료 >>> "+ file.getPath() );


        return true;
    }

    private static String error(InputStream in) {
        StringBuilder sb = null;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
            sb = new StringBuilder();
            String line;

            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            throw new RuntimeException("API 요청 및 응답 실패", e);
        }

        return sb.toString();
    }

    public static void validateInput(String key) throws Exception{
        Scanner sc = new Scanner(System.in);
        String value = sc.next();

        String apiURL = "https://openapi.naver.com/v1/captcha/nkey?code=1&key="+ key+"&value="+value;
        System.out.println(apiURL);
        HttpURLConnection con = getConnection(apiURL);

        BufferedReader in = null;
        int responseCode = con.getResponseCode();
        if(responseCode == HttpURLConnection.HTTP_OK) {
            in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        }else {
            error(con.getErrorStream());
        }

        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = in.readLine()) != null) {
            sb.append(line);
        }
        in.close();
        con.disconnect();

        Gson gson = new Gson();
        APIResponse apiResponse = gson.fromJson(sb.toString(), APIResponse.class);
        System.out.println(apiResponse);


    }
}
