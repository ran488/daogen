package org.redneck.persistinator.generator;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.exception.MethodInvocationException;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.redneck.persistinator.log.SimpleLogger;
import org.redneck.persistinator.meta.Database;
import org.redneck.persistinator.meta.Procedure;
import org.redneck.persistinator.meta.Table;
import org.redneck.persistinator.util.Strings;

// import org.apache.commons.lang.WordUtils;

import java.io.*;
import java.sql.*;
import java.util.*;

/**
 * @author ran488
 * 
 *         TODO 
 *         - Procedure DAO and VO 
 *         -- right now nothing in template but empty class 
 *         - Views 
 *         - find by PK is broken for Views 
 *         - CLOBs and BLOBs handling is not correct (at least for Oracle) - need to look at
 *         this again 
 *         - resource manager, daofactory should probably be in diff
 *         dir than DAO's 
 *         - add abliity to select FOR UPDATE without hacking it
 *         into the setOrderByClause 
 *         - speaking of setOrderBy - that fails Fortify's "SQL Injection" rules, maybe that should be removed
 *         altogether or cleansed
 */
public class CodeGenerator {

	/**
     *
     */
	public CodeGenerator() {
		super();
	}

	/**
	 * Take the List of TableInfo objects, iterate through it and build the
	 * source files using Velocity.
	 * 
	 * @param db
	 * @param templatePath
	 * @param rootDir
	 * @throws Exception
	 */
	public void generateSources(Database db, String templatePath,
			String rootDir, String basePackage) throws Exception {
		SimpleLogger
				.log("Start of Code Generation: \n Using Velocity templates at "
						+ templatePath
						+ "\n Look for generated sources at "
						+ rootDir);
		// get loc of gen classes based on root + package
		String basePath = rootDir
				+ basePackage.replace('.', File.separatorChar) + File.separator;
		// create that loc if not already there
		createDirectoryStructure(basePath);

		// Velocity setup
		VelocityEngine ve = null;
		VelocityContext vctx = null;
		ve = new VelocityEngine();
		Properties p = new Properties();
		p.setProperty("file.resource.loader.path", templatePath);
		ve.init(p);
		vctx = new VelocityContext();
		vctx.put("voPackageName", basePackage + ".vo");
		vctx.put("daoPackageName", basePackage + ".dao");
		vctx.put("daoFactoryClassName", "DaoFactory");

		generateBaseVoDao(basePath, ve, vctx);
		generateDaoFactory(db, basePath, ve, vctx);
		generateResourceManager(basePath, ve, vctx);
		generateTablePersistentObjects(db, basePath, ve, vctx);
		// generateProcPersistentObjects(db, basePath, ve, vctx); -- not 100%
		// yet

		SimpleLogger.log("Finished generating sources");
	}

	/**
	 * TODO implement this!
	 * 
	 * @param db
	 * @param basePath
	 * @param ve
	 * @param vctx
	 * @throws ResourceNotFoundException
	 * @throws ParseErrorException
	 * @throws Exception
	 * @throws IOException
	 * @throws MethodInvocationException
	 */
	private void generateProcPersistentObjects(Database db, String basePath,
			VelocityEngine ve, VelocityContext vctx)
			throws ResourceNotFoundException, ParseErrorException, Exception,
			IOException, MethodInvocationException {
		Template procDaoIntfcTempl = null;
		Template procDaoImplTempl = null;
		Template procVoTempl = null;
		procDaoIntfcTempl = ve.getTemplate("ProcedureDaoTemplate.vm");
		procDaoImplTempl = ve.getTemplate("ProcedureDaoImplTemplate.vm");
		procVoTempl = ve.getTemplate("ProcedureVoTemplate.vm");
		for (Procedure proc : db.getProcedures()) {
			vctx.put("daoImplClassName", proc.getJProperFieldName() + "DaoImpl");
			vctx.put("voClassName", proc.getJProperFieldName() + "Vo");
			vctx.put("daoImplClassName", proc.getJProperFieldName() + "DaoImpl");
			vctx.put("daoInterfaceName", proc.getJProperFieldName() + "Dao");
			vctx.put("outFields", proc.getOutParams());
			vctx.put("inFields", proc.getInParams());
			vctx.put("procName", proc.getProcName());
			vctx.put("inOutFields", proc.getInOutParams());

			vctx.put("schema", proc.getProcSchema());

			FileWriter procVoWriter = null;
			try {
				procVoWriter = new FileWriter(basePath + "vo" + File.separator
						+ proc.getJProperFieldName() + "Vo.java");
				procVoTempl.merge(vctx, procVoWriter);
			} finally {
				procVoWriter.close();
			}

			FileWriter procDaoWriter = null;
			try {
				procDaoWriter = new FileWriter(basePath + "dao"
						+ File.separator + proc.getJProperFieldName()
						+ "Dao.java");
				procDaoIntfcTempl.merge(vctx, procDaoWriter);
			} finally {
				procDaoWriter.close();
			}

			FileWriter procImplWriter = null;
			try {
				procImplWriter = new FileWriter(basePath + "dao"
						+ File.separator + proc.getJProperFieldName()
						+ "DaoImpl.java");
				procDaoImplTempl.merge(vctx, procImplWriter);
			} finally {
				procImplWriter.close();
			}
		}
	}

	/**
	 * @param db
	 * @param basePath
	 * @param ve
	 * @param vctx
	 * @throws ResourceNotFoundException
	 * @throws ParseErrorException
	 * @throws Exception
	 * @throws IOException
	 * @throws MethodInvocationException
	 */
	private void generateTablePersistentObjects(Database db, String basePath,
			VelocityEngine ve, VelocityContext vctx)
			throws ResourceNotFoundException, ParseErrorException, Exception,
			IOException, MethodInvocationException {
		Template voTempl = null;
		Template daoIntfcTempl = null;
		Template daoImplTempl = null;
		voTempl = ve.getTemplate("VoTemplate.vm");
		daoIntfcTempl = ve.getTemplate("DaoTemplate.vm");
		daoImplTempl = ve.getTemplate("DaoImplTemplate.vm");

		// The MEAT and POTATOES
		for (Table table : db.getTables()) {
			// put everything from table into Velocity context
			vctx.put("voClassName", table.getJProperFieldName() + "Vo");
			vctx.put("daoImplClassName", table.getJProperFieldName()
					+ "DaoImpl");
			vctx.put("daoInterfaceName", table.getJProperFieldName() + "Dao");
			vctx.put("dbTableName", table.getTableName());
			vctx.put("javaTableName", table.getTableName());
			vctx.put("persistableFields", table.getColumns());
			vctx.put("primaryKeyFields", table.getPrimaryKeys());
			int numPks = (table.getPrimaryKeys() != null) ? table
					.getPrimaryKeys().size() : 0;
			vctx.put("numPkFields", numPks);

			vctx.put("schema", table.getTableSchema());
			vctx.put("tableType", table.getTableType());

			vctx.put("primaryIndexFields", table.getPrimaryIndexes());
			int numIdx = (table.getPrimaryIndexes() != null) ? table
					.getPrimaryIndexes().size() : 0;
			vctx.put("numIdx", numIdx);

			// custom methods support
			vctx.put("customMethods", table.getCustomMethods());

			FileWriter voWriter = null;
			try {
				voWriter = new FileWriter(basePath + "vo" + File.separator
						+ table.getJProperFieldName() + "Vo.java");
				voTempl.merge(vctx, voWriter);
			} finally {
				voWriter.close();
			}

			FileWriter daoIntfcWriter = null;
			try {
				daoIntfcWriter = new FileWriter(basePath + "dao"
						+ File.separator + table.getJProperFieldName()
						+ "Dao.java");
				daoIntfcTempl.merge(vctx, daoIntfcWriter);
			} finally {
				daoIntfcWriter.close();
			}

			FileWriter daoImplWriter = null;
			try {
				daoImplWriter = new FileWriter(basePath + "dao"
						+ File.separator + table.getJProperFieldName()
						+ "DaoImpl.java");
				daoImplTempl.merge(vctx, daoImplWriter);
			} finally {
				daoImplWriter.close();
			}
		}
	}

	/**
	 * @param basePath
	 * @param ve
	 * @param vctx
	 * @throws ResourceNotFoundException
	 * @throws ParseErrorException
	 * @throws Exception
	 * @throws IOException
	 * @throws MethodInvocationException
	 */
	private void generateResourceManager(String basePath, VelocityEngine ve,
			VelocityContext vctx) throws ResourceNotFoundException,
			ParseErrorException, Exception, IOException,
			MethodInvocationException {
		Template resourceMgrTempl = null;
		FileWriter resMgrWriter = null;

		resourceMgrTempl = ve.getTemplate("ResourceManagerTemplate.vm");
		try {
			resMgrWriter = new FileWriter(basePath + "dao"

			+ File.separator + "ResourceManager.java");
			resourceMgrTempl.merge(vctx, resMgrWriter);
		} finally {
			resMgrWriter.close();
		}
	}

	/**
	 * @param db
	 * @param basePath
	 * @param ve
	 * @param vctx
	 * @throws ResourceNotFoundException
	 * @throws ParseErrorException
	 * @throws Exception
	 * @throws IOException
	 * @throws MethodInvocationException
	 */
	private void generateDaoFactory(Database db, String basePath,
			VelocityEngine ve, VelocityContext vctx)
			throws ResourceNotFoundException, ParseErrorException, Exception,
			IOException, MethodInvocationException {
		Template daoFactoryTempl = null;
		FileWriter daoFactoryWriter = null;

		try {
			daoFactoryTempl = ve.getTemplate("DaoFactoryTemplate.vm");
			daoFactoryWriter = new FileWriter(basePath + "dao" + File.separator
					+ "DaoFactory.java");

			vctx.put("tableInfo", db.getTables());
			vctx.put("procInfo", db.getProcedures());

			daoFactoryTempl.merge(vctx, daoFactoryWriter);
		} finally {
			daoFactoryWriter.close();
		}
	}

	/**
	 * @param basePath
	 * @param ve
	 * @param vctx
	 * @throws ResourceNotFoundException
	 * @throws ParseErrorException
	 * @throws Exception
	 * @throws IOException
	 * @throws MethodInvocationException
	 */
	private void generateBaseVoDao(String basePath, VelocityEngine ve,
			VelocityContext vctx) throws ResourceNotFoundException,
			ParseErrorException, Exception, IOException,
			MethodInvocationException {
		Template baseVoTempl = null;
		FileWriter baseVoWriter = null;

		try {
			baseVoTempl = ve.getTemplate("BaseVoTemplate.vm");
			baseVoWriter = new FileWriter(basePath + "vo" + File.separator
					+ "BaseVo.java");
			baseVoTempl.merge(vctx, baseVoWriter);
		} finally {
			baseVoWriter.close();
		}

		Template baseDaoTempl = null;
		FileWriter baseDaoWriter = null;

		try {
			baseDaoTempl = ve.getTemplate("BaseDaoTemplate.vm");
			baseDaoWriter = new FileWriter(basePath + "dao" + File.separator
					+ "BaseDao.java");
			baseDaoTempl.merge(vctx, baseDaoWriter);
		} finally {
			baseDaoWriter.close();
		}
	}

	/**
	 * @param basePath
	 */
	private void createDirectoryStructure(String basePath) {
		File path = null;
		boolean dirCreated = false;

		path = new File(basePath);
		if (!path.exists()) {
			dirCreated = path.mkdirs();
		}

		path = new File(basePath + File.separator + "vo");
		if (!path.exists()) {
			dirCreated = path.mkdirs();
		}

		path = new File(basePath + File.separator + "dao");
		if (!path.exists()) {
			dirCreated = path.mkdirs();
		}
	}

}
