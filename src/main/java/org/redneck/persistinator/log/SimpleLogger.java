package org.redneck.persistinator.log;

import java.text.DateFormat;

/**
 * This should be eliminated in favor of standard JDK logging when I get time.
 * The main reason for using this instead of log4j or JDK logging was so I could
 * easily write to the textarea. I'm sure I could accomplish the same thing with
 * a logging framework but haven't looked into it yet (logging is at the very
 * bottom of priorities list).
 * 
 * @author ran488
 * 
 */
public class SimpleLogger {

	public static javax.swing.JTextArea textArea = null;

	public static void setOut(java.io.PrintStream out) {
		System.setOut(out);
		System.setErr(out);
	}

	public static synchronized void log(String o) {
		StringBuffer msg = new StringBuffer("[");
		msg.append(DateFormat.getDateTimeInstance(DateFormat.SHORT,DateFormat.FULL).format(new java.util.Date()));
		msg.append("] ").append(o);

		if (textArea == null) {
			System.out.println(msg.toString());
		} else {
			textArea.append(msg.toString());
			textArea.append("\n");
			textArea.setCaretPosition(textArea.getText().length());
		}
	}
}
