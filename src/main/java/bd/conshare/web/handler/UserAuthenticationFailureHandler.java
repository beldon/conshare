package bd.conshare.web.handler;

import bd.conshare.core.utils.HttpUtils;
import bd.conshare.core.utils.RenderUtils;
import bd.conshare.core.utils.ResDataUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Beldon.
 * Copyright (c)  2017/4/30, All Rights Reserved.
 * http://beldon.me
 */
public class UserAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    private final Logger logger = LoggerFactory.getLogger(RenderUtils.class);

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        logger.info("auth error", exception);

        if (HttpUtils.isAjaxRequest(request)) {
            RenderUtils.renderJson(response, ResDataUtils.getData(-1, "用户名或密码错误"));
        }

    }
}
