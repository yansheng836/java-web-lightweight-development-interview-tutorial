	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.SQLException;
	import java.sql.Statement;
	public class JDBCBatch {
		public static void main(String[] args) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				System.out.println("Where is your MySQL JDBC Driver?");
				e.printStackTrace();
				return;
			}
			Connection connection = null;
	        PreparedStatement pstmt;
			try {
				connection = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/class3", "root", "123456");
				if (connection != null) {
					
					//设置非自动提交，开始用事务的方式提交
					//connection.setAutoCommit(false);

					
					String query = "insert into student values (?,?)";
					pstmt = connection.prepareStatement(query);
					pstmt.setString(1,"1");
					pstmt.setString(2,"Peter");
					pstmt.addBatch();
					pstmt.setString(1,"2");
					pstmt.setString(2,"Mike");
					pstmt.addBatch();
					//执行批处理
					pstmt.executeBatch();	
					
					//提交事务
					//connection.commit();

					
				} else {
					System.out.println("Failed to make connection!");
				}
			} catch (SQLException e) {
				System.out.println("Some of Students were not inserted correctly, please check the student table and insert manually.");
				e.printStackTrace();
			} finally {
				//在catch里，一旦出现异常，需要回滚事务  
//				try {
//					connection.rollback();
//				} catch (SQLException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				} 

				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
