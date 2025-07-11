package chap06_file_copy;

import java.io.*;

public class Main {
    public static void main(String[] args) {

        try {
            fileCopy("/Users/kht/Documents/Study/Coding/Academy/dev/web/assets/images/flower1.jpg", "/Users/kht/Desktop/test/flower1.jpg");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void fileCopy(String originPath, String copyPath) throws IOException {
        File origin = new File(originPath);
        File copy = new File(copyPath);

        long stop = 0;
        long start = 0;
        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(origin));
             BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(copy))) {

            start = System.nanoTime();

            byte[] b = new byte[1024];
            int readByte = 0;
            while ((readByte = in.read(b)) != -1) {
                out.write(b, 0, readByte);
            }

            stop = System.nanoTime();


        } catch (FileNotFoundException e) {
            System.out.println("존재하지 않는 파일입니다.");
        } catch (IOException e) {
            System.out.println("파일이 복사되지 않았습니다.");
        }


        System.out.println("[복사 결과]");
        System.out.println("성공 여부: " + (origin.length() == copy.length()));
        System.out.println("복사 시간: " + (stop - start) / 1_000_000.0 + "ms");
        System.out.println("원본: " + origin.getPath());
        System.out.println("복사본: " + copy.getPath());
    }

}
