package com.yasit.core.exceptions;

public class DollCriteriaContractNotRespected extends RuntimeException {

    public DollCriteriaContractNotRespected(Throwable cause) {
        super("criteria match a bean of the wrong class", cause);
    }
}
