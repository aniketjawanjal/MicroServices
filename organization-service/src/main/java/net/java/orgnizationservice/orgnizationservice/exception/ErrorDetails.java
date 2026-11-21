package net.java.orgnizationservice.orgnizationservice.exception;

import java.time.LocalDateTime;

public class ErrorDetails {

	public LocalDateTime timeStamp;
	public String massage;
	public String path;
	public String errorCode;
	public ErrorDetails(LocalDateTime timeStamp, String massage, String path, String errorCode) {
		super();
		this.timeStamp = timeStamp;
		this.massage = massage;
		this.path = path;
		this.errorCode = errorCode;
	}
	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String getMassage() {
		return massage;
	}
	public void setMassage(String massage) {
		this.massage = massage;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	@Override
	public String toString() {
		return "ErrorDetails [timeStamp=" + timeStamp + ", massage=" + massage + ", path=" + path + ", errorCode="
				+ errorCode + "]";
	}
	
	
}
