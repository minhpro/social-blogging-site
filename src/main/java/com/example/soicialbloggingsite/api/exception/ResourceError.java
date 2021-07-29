package com.example.soicialbloggingsite.api.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class ResourceError {
	private List<FieldError> errors;
}
