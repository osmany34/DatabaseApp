import java.sql.*;

public class Main {
    public static final String DB_URL = "jdbc:postgresql://localhost:5432/Deneme";
    public static final String DB_USERNAME = "postgres";
    public static final String DB_PASSWORD = "admin";

    public static void main(String[] args) {
        Connection connect = null;
        String insertSql ="SELECT * FROM employees";
        try {
            connect = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            Statement statement = connect.createStatement();
            System.out.println(statement.executeQuery(insertSql));
            ResultSet data = statement.executeQuery(insertSql); //kayıt sorgulama
            while (data.next()){
                System.out.println("ID : " + data.getInt("id"));
                System.out.println("Ad : " + data.getString("name"));
                System.out.println("Pozisyon : " + data.getString("position"));
                System.out.println("Maaş : " + data.getInt("salary"));
                System.out.println("####################################");

            }

        } catch (SQLException e) {

            System.out.println(e.getMessage());
        }
    }

}