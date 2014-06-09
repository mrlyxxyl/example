package com.yuexin.action;

public class HelloWorldAction {
	private String message;
	private String path;
	
	public String getPath() {
		return path;
	}
	
	public void setPath(String path) {
		this.path = path;
	}
	
	public String getMessage() {
		return message;
	}
	
	public String execute() {
		message = "ÄãºÃÂğ°¡";
		return "success";
	}
}
