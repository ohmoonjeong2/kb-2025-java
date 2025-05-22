import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.junit.jupiter.api.Assertions.*;
import org.scoula.jdbc_ex.common.JDBCUtil;

import static org.junit.jupiter.api.Assertions.*;

public class JunitTest {
    @Test
    void testConnection() throws SQLException {
        //1. JDBC드라이버 로드
        assertDoesNotThrow( ()->
            Class.forName("com.mysql.cj.jdbc.Driver")
        );

        //2. DB연결
        Connection conn = null;

        String url = "jdbc:mysql://localhost:3306/test";
//        String user = "scoula";
        String user = "AAA";
        String password = "1234";
        assertThrows(SQLException.class, ()->{
            DriverManager.getConnection(url, user, password);
        });

    }
    @Test
    @DisplayName("JDBCUtil테스트")
    void testConnection2(){
        Connection conn = null;
        conn = JDBCUtil.getConnection();
        assertNotNull(conn);
    }
}