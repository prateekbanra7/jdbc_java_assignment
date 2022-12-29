/*Question2

perform insertion opertion and also perform retrieval operation on the following
data
name =>
address=>
gender =>
DOB => dd-MM-yyyy
DOJ => MM-dd-yyyy
DOM => yyyy-MM-dd

*/
package in.ineuron.dynamicinput;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import in.ineuron.jdbcUtil.JdbcUtil;

public class Question2 {

	public static void main(String[] args) throws ParseException, SQLException {

		// Loading and register the driver
		Driver driver = new com.mysql.jdbc.Driver();
		DriverManager.registerDriver(driver);

		// resource used
		Connection connection = null;
		PreparedStatement pstmt = null;

		// 2. Establish the connection
		String url = "jdbc:mysql://localhost:3306/user";
		String user = "root";
		String password = "root";

		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter the name :: ");
		String name = scanner.next();
		
		System.out.print("Enter the address :: ");
		String address = scanner.next();
		
		System.out.print("Enter the gender :: ");
		String gender = scanner.next();

		System.out.print("Enter the dob ::(dd-MM-yyyy) ");
		String udob = scanner.next();
		
		System.out.print("Enter the doj ::(MM-dd-yyyy) ");
		String udoj = scanner.next();
		
		System.out.print("Enter the dom ::(yyyy-MM-dd) ");
		String udom = scanner.next();

		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		java.util.Date uDate = sdf.parse(udob);

		long time = uDate.getTime();
		java.sql.Date sqlDate = new java.sql.Date(time);

		System.out.println("user name is     :: " + name);
		System.out.println("user address is  :: " + address);
		System.out.println("user gender is   :: " + gender);
		System.out.println("user dob is      :: " + udob);
		System.out.println("user doj is      :: " + udoj);
		System.out.println("user dom is      :: " + udom);

		String sqlInsertQuery = "insert into user values (?,?,?,?,?,?)";

		try {

			connection = JdbcUtil.getJdbcConnection();

			if (connection != null)
				pstmt = connection.prepareStatement(sqlInsertQuery);
			if (pstmt != null) {
				pstmt.setString(1, name);
				pstmt.setString(2, address);
				pstmt.setString(3, gender);
				pstmt.setDate(4, sqlDate);
				pstmt.setDate(5, sqlDate);
				pstmt.setDate(6, sqlDate);

				int rowAffected = pstmt.executeUpdate();

				System.out.println("No of rows affected is ::" + rowAffected);
			}

		} catch (SQLException se) {
			se.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				JdbcUtil.closeConnection(null, pstmt, connection);
			} catch (SQLException e) {

				e.printStackTrace();
			}
			if (scanner != null) {
				scanner.close();
			}
		}

	}

}
