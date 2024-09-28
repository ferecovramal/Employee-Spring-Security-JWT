package net.javaguides.java_ems.exception;

import org.aspectj.apache.bcel.classfile.annotation.RuntimeInvisAnnos;

public class WorkException extends RuntimeException {
    public WorkException(String message){
        super(message);
    }
}
