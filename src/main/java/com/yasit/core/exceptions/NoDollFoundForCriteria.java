package com.yasit.core.exceptions;

import com.yasit.core.doll.criteria.DollCriteria;

public class NoDollFoundForCriteria extends RuntimeException {
    public NoDollFoundForCriteria(DollCriteria criteria) {
        super(String.format("no doll found for criteria %s", criteria));
    }
}
