package br.com.project.librook.exception;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError{

    List<FieldMessage> errors = new ArrayList<>();

    public ValidationError(Long timestamp, Integer status, String error) {
        super(timestamp, status, error);
    }

    public ValidationError() {
    }

    public List<FieldMessage> getErrors() {
        return errors;
    }

    public void addErrors(String fieldName, String message) {
        this.errors.add(new FieldMessage(fieldName,message));
    }
}
