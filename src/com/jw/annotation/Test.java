package com.jw.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.annotation.Resources;


@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Test{}
