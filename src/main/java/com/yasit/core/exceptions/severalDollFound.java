package com.yasit.core.exceptions;

import com.yasit.core.doll.criteria.DollCriteria;

public class severalDollFound extends RuntimeException {
    public severalDollFound(DollCriteria criteria) {
        super(String.format("criteria : %s", criteria));
    }
}
