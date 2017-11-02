package com.timeline.common;

import java.lang.annotation.*;

/**
 * mark the Object not compare, this will be used with @CompareUtils
 *
 * @author Haifeng.Zhu
 *         created at 8/2/17
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.LOCAL_VARIABLE})
public @interface NotConvert {
}
