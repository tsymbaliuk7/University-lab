package com.university;

public class NoUnitUniversityException extends Exception {
    public NoUnitUniversityException(String errorMessage) {
        super(errorMessage);
    }

    public NoUnitUniversityException() {
        super();
    }
}
