package chap05_Reader;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        fileReader();
        bufferedReader();
        inputStreamReader();
        systemIn();

    }


    private static void systemIn() throws IOException {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
            String line = null;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }



    private static void inputStreamReader() {
        File file = new File("/Users/kht/Desktop/test/test.txt");
        try (BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
            String line = null;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void bufferedReader() {
        File file = new File("/Users/kht/Desktop/test/test.txt");
        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
            String line = null;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void fileReader() {

    }
}
