import java.io.IOException;
import java.sql.*;
import java.util.Properties;
public class JDBCTest {
    public static void main(String[] args) {
        //1. JDBC드라이버 로드
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        //2. DB연결
        Connection conn = null;
        Properties env = new Properties();
        try {
//            env.load(new FileInputStream("c.properties"));

            env.load(JDBCTest.class.getResourceAsStream("/c.properties"));
            System.out.println(env.getProperty("c"));
        }catch(Exception e) {
            e.printStackTrace();
        }
        try {
            env.load(JDBCTest.class.getResourceAsStream("org/scoula/jdbc_ex/common/b.properties"));
            System.out.println(env.getProperty("b"));
        }catch (Exception e) {
            e.printStackTrace();
        }

        try{
            env.load(JDBCTest.class.getResourceAsStream("/application.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String url = env.getProperty("url");
        String user = env.getProperty("user");
        String password = env.getProperty("password");
        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        //3. SQL구문 송신
        Statement stmt = null;

        //4. SQL결과 수신
        ResultSet rs = null;
        try {
            stmt = conn.createStatement();
            String selectSQL = "SELECT * FROM users";
            rs = stmt.executeQuery(selectSQL);
            //rs.next();
            while(rs.next()){
                String id = rs.getString("id");
                System.out.println(id);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        //5. 연결닫기
        try{
            rs.close();
        }catch(SQLException e){}
        try {
            stmt.close();
        }catch(SQLException e){}
        try {
            conn.close();
        }catch(SQLException e){}
    }
}
