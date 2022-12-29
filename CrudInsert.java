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


public class CrudInsert {

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
		System.out.print("Enter the sid: ");
		int sid = scanner.nextInt();

		System.out.print("Enter the sname ::");
		String sname = scanner.next();
		
		System.out.print("Enter the sage: ");
		int sage = scanner.nextInt();

		System.out.print("Enter the saddress ::");
		String saddr = scanner.next();

		String sqlInsertQuery = "insert into student values(?,?,?,?)";
		try {

			connection = JdbcConnection.getJdbcConnection();
			if (connection != null)
				pstmt = connection.prepareStatement(sqlInsertQuery);
			if (pstmt != null) {

				pstmt.setInt(1, sid);
				pstmt.setString(2, sname);
				pstmt.setInt(3, sage);
				pstmt.setString(4, saddr);

				int rowAffected = pstmt.executeUpdate();
				System.out.println("No of rows Affected is :: " + rowAffected);
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
