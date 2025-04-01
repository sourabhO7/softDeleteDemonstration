package com.app.softDelete.exception;

import lombok.Getter;

import static com.app.softDelete.util.ConstantUtility.EXCEPTION_MESSAGE_FORMAT;

@Getter
public class ResourceNotFoundException extends RuntimeException{
    private final String resourceName;
    private final String fieldName;
    private final Long fieldValue;

    public ResourceNotFoundException(String resourceName, String fieldName, Long fieldValue) {
        super(String.format(EXCEPTION_MESSAGE_FORMAT,resourceName,fieldName,fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
}
