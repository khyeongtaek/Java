package chap04_InputStream;

/*
 * java.io.InputStream
 *
 * 1. 바이트 기반 입력 스트림의 최상위 추상 클래스입니다.
 * 2. 파일, 네트워크 등으로부터 바이트 단위로 데이터를 읽어올 수 있습니다.
 * 3. 주요 하위클래스
 *    1) FileInputStream
 *    2) BufferedInputStream
 *    3) DataInputStream
 * 4. 주요 메소드
 *    1) int read() : 1바이트를 읽어 int 값으로 반환 (읽을 데이터가 없으면 -1(EOF)을 반환)
 *                   (1바이트를 int로 변환하면 0~255 값으로 반환되는데 이렇게 처리하면 -1(EOF)과 반환하는 값의 차이를 만들 수 있습니다.)
 *                   (1바이트를 byte로 그대로 반환하면 -128~127 값으로 반환하는데 이러면 -1(EOF)와 반환하는 값의 구분이 어렵습니다.)
 *    2) int read(byte[] b) : 전달한 바이트 배열만큼 읽어서 배열에 저장 (읽은 데이터는 byte[] b에 저장됩니다.)
 *                            실제로 읽은 바이트 수를 반환합니다.
 *                            (읽을 데이터가 없으면 -1(EOF)을 반환)
 *    3) int read(byte[] b, int off, int len) : 전달한 바이트 배열의 일부만 사용해서 저장(인덱스 off부터 len개만큼)
 *                                              실제로 읽은 바이트 수를 반환합니다.
 *                                              (읽을 데이터가 없으면 -1(EOF)을 반환)
 *    4) close() : 입력 스트림을 닫고 자원을 해제
 */

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException{
//        bufferedInputStream();
//        bufferedInputStream2();
//        systemIn();
        dataInputStream();

    }

    private static void dataInputStream() throws IOException{
        File file = new File("/Users/kht/Desktop/test/test.bin");

        DataInputStream din = new DataInputStream(new BufferedInputStream(new FileInputStream(file)));

        int x = din.readInt();
        double y = din.readDouble();
        String s = din.readUTF();

        System.out.println(x + ", " + y + ", " + s);
        din.close();
    }

    private static void systemIn() throws IOException {
        InputStream in = System.in;

        int c;

        // EOF 입력 방법:
        // - Windows: Ctrl + Z
        // - Unix/Linux/Mac: Ctrl + D
        while ((c = in.read()) != -1) {
            System.out.print( (char)c);
        }
    }

    private static void bufferedInputStream2() {
        File file = new File("/Users/kht/Desktop/클래스문제.txt");


        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file))) {

            byte[] b = new byte[20];

            // 파일에서 읽은 데이터를 저장해 둘 byte[] 배열
            byte[] bytes = new byte[(int)file.length()];
            int i = 0;

            int readByte = 0;

            while ((readByte = bis.read(b)) != -1) {
                // b배열의 0번 인덱스부터 readByte만큼의 데이터를 bytes배열의 i번 인덱스부터 복사
                System.arraycopy(b, 0, bytes, i, readByte);
                i += readByte;
            }

            System.out.println(new String(bytes));



        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void bufferedInputStream() {
        File file = new File("/Users/kht/Desktop/클래스문제.txt");

        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file))) {

            // int를 이용해 1바이트 단위로 파일 읽기
            int c;

            // 파일에서 읽은 데이터를 저장해 둘 byte[] 배열
            byte[] b = new byte[(int)file.length()];
            int i = 0;

            while ((c = bis.read()) != -1) {
                b[i++] = (byte)c;

            }

            System.out.println(new String(b) );


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
