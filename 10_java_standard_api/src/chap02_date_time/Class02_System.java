package chap02_date_time;

import org.w3c.dom.ls.LSOutput;

import java.util.Map;

public class Class02_System {
    public static void main(String[] args) {
        long start = System.nanoTime();
        System.out.print("Hello");
        long stop = System.nanoTime();
        long elapsed = stop - start;
        System.out.println("경과 시간: " + (elapsed / 1_000_000.0) + "ms");

        Map<String, Object> map1 = concatWithString();
        Map<String, Object> map2 = concatWithStringBuilder();
        Map<String, Object> map3 = concatWithStringBuffer();

        System.out.print(map1+"\n\r");
        System.out.print(map2+"\n\r");
        System.out.print(map3+"\n\r");
    }

    public static Map<String,Object> concatWithString(){
        String str = "";
        long start = System.nanoTime();
        for (char ch = 'A'; ch <= 'z'; ch++) {
            str += ch;
        }
        long stop = System.nanoTime();

        return Map.of("str",str, "elapsed", (stop-start)/ 1_000_000.0);
    }

    public static Map<String,Object> concatWithStringBuilder(){

        StringBuilder sb = new StringBuilder();

        long start = System.nanoTime();
        for (char ch = 'A'; ch <= 'z'; ch++) {
            sb.append(ch);
        }
        long stop = System.nanoTime();
        return Map.of("sb",sb, "elapsed", (stop-start)/ 1_000_000.0);


    }

    public static Map<String, Object> concatWithStringBuffer() {

        StringBuffer sf = new StringBuffer();

        long start = System.nanoTime();
        for (char ch = 'A'; ch <= 'z'; ch++) {
            sf.append(ch);
        }
        long stop = System.nanoTime();
        return Map.of("sf", sf, "elapsed", (stop - start) / 1_000_000.0);


    }


}

