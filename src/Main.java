import java.sql.*;

public class Main {
    public static final String DB_URL = "jdbc:postgresql://localhost:5432/Deneme";
    public static final String DB_USERNAME = "postgres";
    public static final String DB_PASSWORD = "admin";

    public static void main(String[] args) {
        Connection connect = null;
        String insertSql ="SELECT * FROM employees";
        try {
            // Veritabanına bağlan
            connect = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            // Statement nesnesini oluştur
            Statement statement = connect.createStatement();
            System.out.println(statement.executeQuery(insertSql));
            // SQL sorgusunu çalıştır ve sonuç kümesini al
            ResultSet data = statement.executeQuery(insertSql);
            while (data.next()){
                // Her bir sütunu al ve ekrana yazdır
                System.out.println("ID : " + data.getInt("id"));
                System.out.println("Ad : " + data.getString("name"));
                System.out.println("Pozisyon : " + data.getString("position"));
                System.out.println("Maaş : " + data.getInt("salary"));
                System.out.println("####################################");

            }

            // Hata durumunda hata mesajını ekrana yazdır
        } catch (SQLException e) {

            System.out.println(e.getMessage());
        }
    }

}