package com.team4d.lolhelper.api.dto.team;

public class MessageOfDay {
	private long createDate;	
	private String message;	
	private int version;
	/**
	 * @return the createDate
	 */
	public long getCreateDate() {
		return createDate;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @return the version
	 */
	public int getVersion() {
		return version;
	}
}
