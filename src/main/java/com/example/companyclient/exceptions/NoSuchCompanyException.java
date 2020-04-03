package com.example.companyclient.exceptions;

public class NoSuchCompanyException extends ServiceException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoSuchCompanyException() {
		super();
	}

	public NoSuchCompanyException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public NoSuchCompanyException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public NoSuchCompanyException(String arg0) {
		super(arg0);
	}

	public NoSuchCompanyException(Throwable arg0) {
		super(arg0);
	}

}
