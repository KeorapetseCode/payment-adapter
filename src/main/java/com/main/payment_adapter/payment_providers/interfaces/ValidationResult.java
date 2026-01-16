// THIS COULD BE OVERRITTEN BY THE TRANSACTION STATUS FILE
// package com.main.payment_adapter.payment_providers.interfaces;

// import java.util.List;

// /**
// * Validation Result
// * Contains the result of payment request validation
// */
// public class ValidationResult {

// private boolean valid;
// private List<String> errors;
// private List<String> warnings;

// public ValidationResult() {
// }

// public ValidationResult(boolean valid) {
// this.valid = valid;
// }

// public ValidationResult(boolean valid, List<String> errors) {
// this.valid = valid;
// this.errors = errors;
// }

// public static ValidationResult success() {
// return new ValidationResult(true);
// }

// public static ValidationResult failure(List<String> errors) {
// return new ValidationResult(false, errors);
// }

// public boolean isValid() {
// return valid;
// }

// public void setValid(boolean valid) {
// this.valid = valid;
// }

// public List<String> getErrors() {
// return errors;
// }

// public void setErrors(List<String> errors) {
// this.errors = errors;
// }

// public List<String> getWarnings() {
// return warnings;
// }

// public void setWarnings(List<String> warnings) {
// this.warnings = warnings;
// }

// public boolean hasErrors() {
// return errors != null && !errors.isEmpty();
// }

// public boolean hasWarnings() {
// return warnings != null && !warnings.isEmpty();
// }
// }