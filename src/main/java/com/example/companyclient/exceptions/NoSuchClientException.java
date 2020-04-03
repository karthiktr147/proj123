package com.example.companyclient.exceptions;

public class NoSuchClientException extends ServiceException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoSuchClientException() {
		super();
	}

	public NoSuchClientException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public NoSuchClientException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public NoSuchClientException(String arg0) {
		super(arg0);
	}

	public NoSuchClientException(Throwable arg0) {
		super(arg0);
	}

}
