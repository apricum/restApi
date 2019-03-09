package com.example.bine.annotations;

import java.util.HashMap;

public @interface MDCLog {

    Map<String label,String value> putValue() default new HashMap<>();
    Map<String label,String value> removeValue() default new HashMap<>();
}
