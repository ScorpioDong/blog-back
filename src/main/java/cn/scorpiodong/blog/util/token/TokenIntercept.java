package cn.scorpiodong.blog.util.token;

import cn.scorpiodong.blog.util.JsonResult;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * This is Description
 *
 * @author ScorpioDong
 * @date 2020/05/06
 */
@Aspect
public class TokenIntercept {

    @Pointcut("@annotation(cn.scorpiodong.blog.util.token.TokenRequired)")
    public void validateToken() {
    }

    @Around("validateToken()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(
                RequestContextHolder.getRequestAttributes())).getRequest();
        String token = request.getHeader("Authorization");
        DecodedJWT jwt = TokenUtils.verify(token);
        if (jwt != null) {
            return joinPoint.proceed();
        }
        return JsonResult.TOKEN_ERROR;
    }
}
