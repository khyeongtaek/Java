package chap02_URLConnection;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Main {
    public static void main(String[] args) {

        try {
            byteStream();
            charStream();

        } catch (MalformedURLException e) {
            System.out.println("URL 형식이 잘못되었습니다.");
        } catch (IOException e) {
            System.out.println("데이터 입출력이 잘못되었습니다.");
        }
    }

    private static void charStream() throws MalformedURLException, IOException{
        URL url = new URL("https://www.google.com/robots.txt");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();

        con.connect();

        int responseCode = con.getResponseCode();

        BufferedReader in = null;

        if(responseCode == HttpURLConnection.HTTP_OK) {
            in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        }else {
            in = new BufferedReader(new InputStreamReader(con.getErrorStream()));

        }

        String fileName = url.getFile().substring(url.getFile().lastIndexOf("/") + 1);
        File file = new File(fileName);

        BufferedWriter out = null;
//        out = new BufferedWriter(new FileWriter(file));
        out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));


        String line = null;
        while ((line = in.readLine()) != null) {
            out.write(line);
            out.write("\n");
//            out.newLine();
        }

        out.close();
        in.close();
        con.disconnect();

        System.out.println(file.getPath() + "파일이 생성 되었습니다.");


    }

    private static void byteStream() throws MalformedURLException, IOException{
        // 웹 사이트의 이미지 내려받기
        URL url = new URL("https://image7.coupangcdn.com/image/coupang/common/logo_coupang_w350.png");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();

        con.connect();

        int responseCode = con.getResponseCode();

        BufferedInputStream in = null;

        if (responseCode == HttpURLConnection.HTTP_OK) {
            in = new BufferedInputStream(con.getInputStream());
        }else {
            in = new BufferedInputStream(con.getErrorStream());
        }

        String fileName = url.getFile().substring(url.getFile().lastIndexOf("/") + 1);
        File file = new File(fileName);


        BufferedOutputStream out = null;
        out = new BufferedOutputStream(new FileOutputStream(file));

        byte[] b = new byte[1024];
        int readLine = 0;
        while ((readLine = in.read(b)) != -1) {
            out.write(b, 0, readLine);
        }


        out.close();
        in.close();
        con.disconnect();


        System.out.println(file.getPath() + " 파일이 다운로드 되었습니다.");

    }
}
