package com.example.socialbloggingsite.api.exception;

public class InvalidAuthenticationException extends Exception {
	public InvalidAuthenticationException() {
		super("invalid email or password");
	}
}
