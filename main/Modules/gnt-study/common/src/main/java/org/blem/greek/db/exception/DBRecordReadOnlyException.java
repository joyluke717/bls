package org.blem.greek.db.exception;

public class DBRecordReadOnlyException extends Exception {
	/**
	 * A custom exception indicating change was attempted to a read only record.
	 */
	private static final long serialVersionUID = 1L;

	public DBRecordReadOnlyException(String message) {
        super(message);
    }
}
