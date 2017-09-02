package rkp;
import java.sql.*;

public class JDBCExample {
	private static String jdbcDriver = "com.mysql.jdbc.Driver";
    private static String dbName = "TIGER";


    public static void main(String[] args) throws Exception {
        Class.forName(jdbcDriver);
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/?user=root&password=tom");
        Statement s = conn.createStatement();
        int Result = s.executeUpdate("CREATE DATABASE "+dbName);
    }
}//end JDBCExample