package dbTest;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestConn {
    private String driver = "com.mysql.cj.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/opentutorials?characterEncoding=UTF-8&serverTimezone=UTC";
    private String user = "root";
    private String password = "111111";

    @Test
    public void testCon() throws Exception{
        // DBMS에게 DB 연결 드라이버의 위치를 알려주기 위한 메소드
        Class.forName(driver);
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
