package com.example.socialbloggingsite.application.user;

import com.example.socialbloggingsite.core.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DuplicatedEmailValidator
    implements ConstraintValidator<DuplicatedEmailConstraint, String> {

  @Autowired private UserRepository userRepository;

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    return (value == null || value.isEmpty()) || !userRepository.findByEmail(value).isPresent();
  }
}
