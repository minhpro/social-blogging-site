package com.example.socialbloggingsite.api.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException e,
			HttpHeaders headers,
			HttpStatus status,
			WebRequest request) {
		List<FieldError> errorResources =
				e.getBindingResult().getFieldErrors().stream()
						.map(
								fieldError ->
										new FieldError(
												fieldError.getField(),
												fieldError.getDefaultMessage()))
						.collect(Collectors.toList());

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResourceError(errorResources));
	}

	@ExceptionHandler({ConstraintViolationException.class})
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ResourceError handleConstraintViolation(ConstraintViolationException ex, WebRequest request) {
		List<FieldError> errors = new ArrayList<>();
		for (ConstraintViolation<?> violation : ex.getConstraintViolations()) {
			FieldError fieldErrorResource =
					new FieldError(
							getParam(violation.getPropertyPath().toString()),
							violation.getMessage());
			errors.add(fieldErrorResource);
		}

		return new ResourceError(errors);
	}

	@ExceptionHandler(InvalidAuthenticationException.class)
	public ResponseEntity<Object> handleInvalidAuthentication(
			InvalidAuthenticationException e, WebRequest request) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(
						new HashMap<String, Object>() {
							{
								put("message", e.getMessage());
							}
						});
	}

	private String getParam(String s) {
		String[] splits = s.split("\\.");
		if (splits.length == 1) {
			return s;
		} else {
			return String.join(".", Arrays.copyOfRange(splits, 2, splits.length));
		}
	}
}
