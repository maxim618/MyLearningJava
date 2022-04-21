import java.sql.*;

public class TestConnection {

    static final String URL = "jdbc:mysql://localhost:3306/mysql";
    static final String USER_NAME = "root";
    static final String PASSWORD = "vfrcbv0618";
    static  Statement statement;
    static  Connection connection;

    static {
        try {
            connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
        }catch(SQLException exception) {
            exception.printStackTrace();
            throw new RuntimeException();
        }
    }
    static {
        try {
            statement = connection.createStatement();
        } catch (SQLException exception) {
            exception.printStackTrace();
            throw new RuntimeException();
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //Class.forName("com.mysql.cj.jdbs.Driver");
        statement.executeUpdate("CREATE TABLE test("+ "id int auto_increment primary key,"+
                "name varchar(30) not null" +
                "name1 varchar(30) not null" +
                "name2 varchar(30) not null)");
        statement.executeUpdate("INSERT INTO carShop(name,quantity,price value ('Patrol', 12, 12)" );
        ResultSet resultSet = statement.executeQuery("SELECT * FROM carShop");
        while (resultSet.next()){
            System.out.println(resultSet.getString(2) + " " +
                    resultSet.getString(3) + " " +
                    resultSet.getString(4));
        }

    }

}

