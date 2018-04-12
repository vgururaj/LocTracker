package com.tracker.db;

public class DBApplicationException extends Exception {

	private static final long serialVersionUID = 1L;

    public DBApplicationException() { }

	public DBApplicationException(String message) {
        super(message);     
	}

    public DBApplicationException(String message, Throwable cause) {
        super(message, cause);      
    } 

}
