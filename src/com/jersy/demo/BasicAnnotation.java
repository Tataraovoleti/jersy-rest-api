/**
 * 
 */
package com.jersy.demo;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.ElementType;
/**
 * @author Tatarao voleti
 * @date   22-Aug-2014
 * 
 */
@Documented
@Target(ElementType.METHOD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface BasicAnnotation {
	
	String author() default "Tata";
	String date();
    int revision() default 1;
    String comments();

}
