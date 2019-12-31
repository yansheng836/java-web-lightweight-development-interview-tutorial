	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
    import java.sql.SQLException;
	import java.sql.Statement;
	public class ResultDemo {
		public static void main(String[] args) {
			try {
	Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				System.out.println("Where is your MySQL JDBC Driver?");
				e.printStackTrace();
				return;
			}
			Connection connection = null;
			Statement stmt = null;
			try {
				connection = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/class3", "root", "123456");
				if (connection != null) {
					stmt = connection.createStatement();
					String query = "select ID,Name from student";
					ResultSet rs=stmt.executeQuery(query);
					while(rs.next())
					{
						System.out.println(rs.getString("ID"));
						System.out.println(rs.getString("Name"));
					}
				} else {
					System.out.println("Failed to make connection!");
				}
			} catch (SQLException e) {
	System.out.println("Check the JDBC Driver or Connection!");
				e.printStackTrace();
			} finally {
	        //close the connection 
				try {
						stmt.close();
				connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
