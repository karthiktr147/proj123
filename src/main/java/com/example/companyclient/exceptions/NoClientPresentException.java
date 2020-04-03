package com.example.companyclient.exceptions;

public class NoClientPresentException extends ServiceException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoClientPresentException() {
		super();
	}

	public NoClientPresentException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super();
	}

	public NoClientPresentException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public NoClientPresentException(String arg0) {
		super(arg0);
	}

	public NoClientPresentException(Throwable arg0) {
		super(arg0);
	}

}
