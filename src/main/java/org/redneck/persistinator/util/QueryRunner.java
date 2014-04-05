package org.redneck.persistinator.util;

import java.util.List;
import java.util.ArrayList;
import java.sql.*;

import org.redneck.persistinator.log.SimpleLogger;

/**
 * 
 * @author ran488
 */
public class QueryRunner {
	private String userName = null;

	private String dbUrl = null;

	private String password = null;

	/** Creates a new instance of QueryRunner */
	public QueryRunner(String driverClassName) {
		try {
			initDriver(driverClassName);
		} catch (Exception e) {
			SimpleLogger.log("Could not instantiate JDBC driver: "
					+ e.toString());
		}
	}

	public void runQuery(String query) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ResultSetMetaData rsmd = null;
		StringBuffer output = null;

		try {
			conn = DriverManager.getConnection(dbUrl, userName, password);
			ps = conn.prepareStatement(query);
			long start = System.currentTimeMillis();
			rs = ps.executeQuery();
			long end = System.currentTimeMillis();
			rsmd = rs.getMetaData();

			output = new StringBuffer();
			output.append("\nQUERY RESULTS\n==============\n");
			for (int ii = 1; ii <= rsmd.getColumnCount(); ii++) {
				output.append(rsmd.getColumnName(ii)).append("\t");
			}
			output.append("\n");

			int recordCount = 0;
			while (rs.next()) {
				recordCount++;
				for (int jj = 1; jj <= rsmd.getColumnCount(); jj++) {
					output.append(rs.getObject(jj)).append("\t");
				}
				output.append("\n");
			}
			output.append(recordCount).append(" rows found in ")
					.append(end - start).append(" ms.");
			SimpleLogger.log(output.toString());
		} catch (Exception e) {
			SimpleLogger.log("Exception running query: " + e.toString());
			throw e;
		} finally {
			try {
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				ps.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * load JDBC driver and initialize JDBC connection
	 * 
	 * @throws ClassNotFoundException
	 */
	private void initDriver(String driverClassName)
			throws ClassNotFoundException {
		SimpleLogger.log("- Initializing DB Driver...");
		Class.forName(driverClassName);
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getDbUrl() {
		return dbUrl;
	}

	public void setDbUrl(String dbUrl) {
		this.dbUrl = dbUrl;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
