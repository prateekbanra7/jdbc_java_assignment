/*
Question3
perform CRUD operation using preparedStatement
1. insert 2. update 3. select 4. delete
*/
package in.ineuron.dynamicinput;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.jdbc.Driver;

import in.ineuron.jdbcUtil.JdbcConnection;


public class CrudUpdate {

	public static void main(String[] args) throws SQLException {

		// Loading and register the driver
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		
		// 2. Establish the connection
		String url = "jdbc:mysql://localhost:3306/enterprisejavabatch";
		String user = "root";
		String password = "root";

		// resources used in jdbc
		Connection connection = null;
		PreparedStatement pstmt = null;

		
		

		Scanner scanner = new Scanner(System.in);
		try {
			
			connection = JdbcConnection.getJdbcConnection();
			String updateSqlQuery = "update student set sname =?, sage=?, saddr=? where sid=?";
			System.out.println("Enter new sname ::");
			String sname = scanner.next();
			
			
			System.out.println("Enter new sage: ");
			int sage = scanner.nextInt();
			
			System.out.println("Enter new saddress ::");
			String saddr = scanner.next();
			
			System.out.println("Enter the sid: ");
			//int sid = scanner.nextInt();
			int sid=Integer.parseInt(scanner.next());
			
			if (connection != null)
				pstmt = connection.prepareStatement(updateSqlQuery);
			
			if (pstmt != null) {

				pstmt.setString(1, sname);
				pstmt.setInt(2, sage);
				pstmt.setString(3, saddr);
				pstmt.setInt(4, sid);
				
				int noOfRows = pstmt.executeUpdate();
				System.out.println("No of rows updated is :: " + noOfRows);
			}

		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			JdbcConnection.closeConnection(null, pstmt, connection);

			if (scanner != null)
				scanner.close();
		}

	}

}
