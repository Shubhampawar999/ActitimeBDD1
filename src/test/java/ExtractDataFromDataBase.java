
import java.sql.*;

public class ExtractDataFromDataBase {


    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:oracle://http://localhost:3000/student","scott","tiger");
        Statement stm=connection.createStatement();
        String s="select * from customerInfo";
        ResultSet resultSet= stm.executeQuery(s);
        while(resultSet.next()){
            resultSet.getString("BOOKNAME");
        }
    }
}


