package rw.ugv.qualifiers;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.inject.Qualifier;

/**
 * User: Siarhei Yanusheusky
 * Date: 23.10.13
 * Time: 13:39
 */
@Qualifier
@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = {ElementType.METHOD,ElementType.PARAMETER,ElementType.FIELD })
public @interface UgvForm {
}
