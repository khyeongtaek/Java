import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
//        inMySelf();




    }















    private static void inMySelf() {
        Properties dbProps = new Properties();
        try (FileReader reader = new FileReader("jdbc.properties")) {
            dbProps.load(reader);
        } catch (IOException e) {
            System.out.println("jdbc.properties 파일 로드 오류: " + e.getMessage());
            return; // 프로그램 종료
        }

        String url = dbProps.getProperty("url");
        String user = dbProps.getProperty("user");
        String password = dbProps.getProperty("password");

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            // tbl_user 테이블에서 닉네임 가져오기
            Statement stmtUser = conn.createStatement();
            ResultSet rsUser = stmtUser.executeQuery("SELECT nickname FROM tbl_user");

            System.out.println("tbl_user 테이블 데이터:");
            while (rsUser.next()) {
                String nickname = rsUser.getString("nickname");
                System.out.println(nickname);
            }

            // tbl_board 테이블에서 데이터 가져오기
            Statement stmtBoard = conn.createStatement();
            ResultSet rsBoard = stmtBoard.executeQuery("SELECT uid, title, content FROM tbl_board");

            System.out.println("\ntbl_board 테이블 데이터:");
            while (rsBoard.next()) {
                int uid = rsBoard.getInt("uid");
                String title = rsBoard.getString("title");
                String content = rsBoard.getString("content");
                System.out.println("UID: " + uid + ", Title: " + title + ", Content: " + content);
            }

        } catch (SQLException e) {
            System.out.println("데이터베이스 오류: " + e.getMessage());
        }
    }
}
