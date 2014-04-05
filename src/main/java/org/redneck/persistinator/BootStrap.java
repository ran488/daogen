package org.redneck.persistinator;

import java.sql.*;

import javax.sql.*;

import org.redneck.persistinator.generator.CodeGenerator;
import org.redneck.persistinator.log.SimpleLogger;
import org.redneck.persistinator.meta.Database;
import org.redneck.persistinator.meta.DbDescriptor;

/**
 * Legacy bootstrapper class from when this was an experimental command line
 * tool.
 * 
 * @TODO - I should either remove this altogether (only launch via Swing app) or
 *       make it launchable as an ANT task (minus the properties file ugh)
 * @author ran488
 */
public class BootStrap {
	// DATABASE information - what to describe/generate
	private static String dbUrl = Messages.getString("BootStrap.dbUrl"); //$NON-NLS-1$
	private static String userName = Messages.getString("BootStrap.userName"); //$NON-NLS-1$
	private static String password = Messages.getString("BootStrap.password"); //$NON-NLS-1$
	private static String driverClassName = Messages
			.getString("BootStrap.driverClass"); //$NON-NLS-1$
	private static String schemaFilter = Messages
			.getString("BootStrap.schemaFilter"); //$NON-NLS-1$

	// GENERATED CODE info -- what and where to generate?
	private static String basePkgName = Messages
			.getString("BootStrap.basePackage");
	private static String rootDir = Messages.getString("BootStrap.rootDir");
	private static String templatePath = Messages
			.getString("BootStrap.templatePath");

	/**
	 * constructor
	 */
	public BootStrap() throws ClassNotFoundException, SQLException {
		super();
	}

	/**
	 * Describe the database into an Object representation. FIXME: after
	 * describing of course comes code generation
	 * 
	 * @throws SQLException
	 */
	public Database describe() throws Exception {
		DbDescriptor dbd;
		Database db;
		if ((schemaFilter != null) && (!schemaFilter.trim().equals("")))
			dbd = new DbDescriptor(schemaFilter);
		else
			dbd = new DbDescriptor();

		db = dbd.describe(dbUrl, userName, password, driverClassName);
		SimpleLogger.log(db.toString());
		return db;
	}

	/**
	 * generate the code using the described database
	 * 
	 * @throws Exception
	 */
	public void generate(Database db) throws Exception {
		CodeGenerator gen = new CodeGenerator();
		gen.generateSources(db, templatePath, rootDir, basePkgName);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SimpleLogger.log("Starting");
		SimpleLogger.log(userName + "/" + password + "@" + dbUrl + "("
				+ driverClassName + ")");
		BootStrap bs;
		Database db;

		try {
			bs = new BootStrap();
			db = bs.describe();
			bs.generate(db);
		} catch (ClassNotFoundException e) {
			SimpleLogger.log("Couldn't load Database Driver: " + e.toString());
		} catch (SQLException e) {
			SimpleLogger.log("Database Error: " + e.toString());
			e.printStackTrace();
		} catch (Exception e) {
			SimpleLogger.log("An error occurred generating source code: "
					+ e.toString());
			e.printStackTrace();
		}

		SimpleLogger.log("Finished");
	}
}
