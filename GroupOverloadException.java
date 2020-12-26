package com.gmail.theslavahero;

public class GroupOverloadException extends Exception {
	@Override
	public String getMessage() {
		return " GroupOverloadException: The Group is already full";
	}
}
