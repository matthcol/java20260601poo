package org.example.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

// @Target(ElementType.METHOD)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface Kingdoo {
}
