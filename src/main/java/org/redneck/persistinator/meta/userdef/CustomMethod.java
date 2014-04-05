/**
 *
 */
package org.redneck.persistinator.meta.userdef;

import java.io.Serializable;
import java.util.List;

/**
 * The meta-data needed to implement custom finder methods in the table DAO
 * 
 * @author ran488
 * 
 */
public class CustomMethod implements Serializable {

	private String methodName;
	private String methodSignature;
	private String methodBody;
	private static final long serialVersionUID = 7556383385762254607L;

	/**
     *
     */
	public CustomMethod() {
		super();
	}

	/**
     *
     */
	public CustomMethod(String methodName) {
		this();
		this.methodName = methodName;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public String toString() {
		return this.methodName;
	}

	public String getMethodSignature() {
		return methodSignature;
	}

	public void setMethodSignature(String methodSignature) {
		this.methodSignature = methodSignature;
	}

	public String getMethodBody() {
		return methodBody;
	}

	public void setMethodBody(String methodBody) {
		this.methodBody = methodBody;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((methodName == null) ? 0 : methodName.hashCode());
		result = prime * result
				+ ((methodSignature == null) ? 0 : methodSignature.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof CustomMethod)) {
			return false;
		}
		CustomMethod other = (CustomMethod) obj;
		if (methodName == null) {
			if (other.methodName != null) {
				return false;
			}
		} else if (!methodName.equals(other.methodName)) {
			return false;
		}
		if (methodSignature == null) {
			if (other.methodSignature != null) {
				return false;
			}
		} else if (!methodSignature.equals(other.methodSignature)) {
			return false;
		}
		return true;
	}
}
