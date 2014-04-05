package org.redneck.persistinator.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.redneck.persistinator.gui.ProjectInfo;
import org.redneck.persistinator.log.*;

/**
 * Utility class to help serialize and deserialize List of objects to/from file.
 * Originally written for the Batch DSL Query "results" lists.
 * 
 * @author ran488
 * 
 */
public class SerializerUtil {

	public SerializerUtil() {
		super();
	}

	/**
	 * Load the given filename and de-serialize into a List
	 */
	public synchronized Object load(String filename) throws Exception {
		ObjectInputStream in = null;
		Object obj = null;

		try {
			FileInputStream fileIn = new FileInputStream(filename);
			in = new ObjectInputStream(fileIn);
			obj = in.readObject();
			SimpleLogger.log("Loaded Object of type: "
					+ ((obj == null) ? "null" : obj.getClass().getName()));
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("An error occurred reading " + filename + ": "
					+ e);
		} finally {
			try {
				in.close();
			} catch (Exception e) {
			}
		}

		return obj;
	}

	/**
	 * Load the given filename and de-serialize into a List
	 */
	public synchronized List loadList(String filename) throws Exception {
		return (ArrayList) this.load(filename);
	}

	/**
	 * Load the given filename and de-serialize into a List
	 */
	public synchronized ProjectInfo loadProject(String filename)
			throws Exception {
		return (ProjectInfo) this.load(filename);
	}

	/**
	 * Serialize the List to a file with given filename.
	 */
	public synchronized void save(String filename, Object o) throws Exception {
		ObjectOutputStream out = null;

		try {
			FileOutputStream fileOut = new FileOutputStream(filename);
			out = new ObjectOutputStream(fileOut);
			out.writeObject(o);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Could not write file " + filename + ": " + e);
		} finally {
			try {
				out.close();
			} catch (Exception e) {
			}
		}
	}

	/**
	 * Serialize the List to a file with given filename.
	 */
	public synchronized void saveList(String filename, List l) throws Exception {
		SimpleLogger.log("Writing serialized List to " + filename
				+ ". List has [" + l.size() + "] elements.");
		this.save(filename, l);
	}

	/**
	 * Serialize the List to a file with given filename.
	 */
	public synchronized void saveProject(String filename, ProjectInfo prj)
			throws Exception {
		this.save(filename, prj);
	}

}
