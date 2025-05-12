import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCTest {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/employees";
        String user = "root";
        String password = "kb2025";
        try(Connection con = DriverManager.getConnection(url, user, password);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from employees");
        ){
            while(rs.next()){
                int emp_no = rs.getInt("emp_no");
                String first_name = rs.getString("first_name");
                String gender = rs.getString("gender");
                java.sql.Date hire_date = rs.getDate("hire_date");
                System.out.println(emp_no+ ":" + first_name + ":" + gender + ":" + hire_date);
            }
        }catch(Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
