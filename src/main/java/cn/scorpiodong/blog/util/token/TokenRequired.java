package cn.scorpiodong.blog.util.token;

import java.lang.annotation.*;

/**
 * This is Description
 *
 * @author ScorpioDong
 * @date 2020/05/06
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface TokenRequired {
}
