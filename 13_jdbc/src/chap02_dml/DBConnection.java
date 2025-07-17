package chap01_connect;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {
    public static Connection connection() throws ClassNotFoundException, SQLException, IOException {
        // jdbc.properties 파일 읽기
        File file = new File("jdbc.properties");
        FileInputStream in = new FileInputStream(file);

        // Properties 객체 생성 및 jdbc.properties 파일 등록
        Properties properties = new Properties();
        properties.load(in);

        // 드라이버 클래스 로드
        Class.forName(properties.getProperty("driver"));

        // DB 접속
        return DriverManager.getConnection(
                properties.getProperty("url")
                , properties.getProperty("user")
                , properties.getProperty("password"));

    }


}
