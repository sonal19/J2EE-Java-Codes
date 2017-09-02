import java.sql.*;



public class jdbccheck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/rk","root","tom");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM test1");
			while(rs.next())
			{
			   System.out.print(rs.getInt("id") + "\t" + rs.getString("name"));
			   System.out.println();
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
