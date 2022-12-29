/*
Question3
perform CRUD operation using preparedStatement
1. insert 2. update 3. select 4. delete
*/
package in.ineuron.dynamicinput;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

import in.ineuron.jdbcUtil.JdbcConnection;

public class CrudSelect {

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

		

		String sqlSelectQuery = "select sid,sname,sage,saddr from student";

		try {

			connection = JdbcConnection.getJdbcConnection();
			if (connection != null)
				pstmt = connection.prepareStatement(sqlSelectQuery);

			if (pstmt != null) {

				ResultSet resultSet = pstmt.executeQuery();
				
				
				if (resultSet != null) {

					// 5. Process the resultSet to get the data
					System.out.println("SID\tSNAME\tSAGE\tSADDR");
					System.out.println("==========================");
					while (resultSet.next()) {
						int sid = resultSet.getInt("sid");
						String sname = resultSet.getString("sname");
						int sage = resultSet.getInt("sage");
						String saddr = resultSet.getString("saddr");
						System.out.println(sid + "\t" + sname + "\t" + sage + "\t" + saddr);
					}
				}
			}

		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			JdbcConnection.closeConnection(null, pstmt, connection);

			
		}

	}

}
