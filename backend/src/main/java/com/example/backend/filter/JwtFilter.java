package com.example.backend.filter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.backend.config.JWTUtil;
import com.example.backend.config.VerifyResult;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@Component
@WebFilter(urlPatterns = {"/user/*", "/admin/*", "/producer/*"})
public class JwtFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        ContentCachingRequestWrapper httpServletRequest = new ContentCachingRequestWrapper((HttpServletRequest) servletRequest);
        ContentCachingResponseWrapper httpServletResponse = new ContentCachingResponseWrapper((HttpServletResponse) servletResponse);

        // 전처리
        // req
        String url = httpServletRequest.getRequestURI();
        String jwt = httpServletRequest.getHeader("Authorization");
        String reqContent = new String(httpServletRequest.getContentAsByteArray());
        System.out.println(url + " " + reqContent);

        System.out.println("jwt :" + jwt);
        VerifyResult result = JWTUtil.verify(jwt);
        if(result.isSuccess()) {
            filterChain.doFilter(httpServletRequest, httpServletResponse);

        } else {

            httpServletResponse.setStatus(203);

            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("name", "anna");
            jsonObject.addProperty("id", 1);

            httpServletResponse.getWriter().write(jsonObject.toString());
            httpServletResponse.getWriter().flush();
            httpServletResponse.copyBodyToResponse();

        }

    }

}