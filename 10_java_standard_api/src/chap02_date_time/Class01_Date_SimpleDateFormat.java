package chap02_date_time;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Class01_Date_SimpleDateFormat {
    public static void main(String[] args) {
        // Date클래스는 자체적으로 포맷을 지정할 수 없고 toString()으로만 출력됨
        Date date = new Date();
//        System.out.println("Date 기본 출력: " + date);

        // SimpleDateFormat을 사용해야 원하는 형식으로 포맷 지정 가능

        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
//        System.out.println("포맷 지정 출력1: " + sdf1.format(new Date()));


        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초");
//        System.out.println("포맷 지정 출력2: " + sdf2.format(date));

        String str = "";
        while (true) {
            String currentTime = sdf1.format(new Date());
            if (!str.equals(currentTime)) {
                System.out.print("\r시간:  " + currentTime);
                str = currentTime;
            }
        }

    }
}
