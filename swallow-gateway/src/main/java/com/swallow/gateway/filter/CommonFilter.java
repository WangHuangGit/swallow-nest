package com.swallow.gateway.filter;

import com.alibaba.fastjson.JSONObject;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.swallow.gateway.comment.ResponseResult;
import com.swallow.gateway.comment.ResponseUtil;
import com.swallow.gateway.comment.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

/**
 * 网关过滤器
 * @author WangHan
 * @date 2018/12/21 14:57
 */

@Slf4j
@Component
public class CommonFilter extends ZuulFilter{

    private final RedisTemplate<String, String> redisTemplate;

    @Autowired
    public CommonFilter (RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @SuppressWarnings("ConstantConditions")
    @Override
    public Object run() {
        //取request请求
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        //取response返回，并设置返回格式
        HttpServletResponse response = requestContext.getResponse();
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        //取请求的cookie
        Cookie[] cookies = request.getCookies();
        String token = null;
        //循环cookie取出token的值
        if (cookies != null && cookies.length > 0){
            for (Cookie cookie : cookies) {
                if ("token".equalsIgnoreCase(cookie.getName())) {
                    token = cookie.getValue();
                }
            }
        }
        //验证token是否存在
        if (token == null || token.isEmpty()) {
            log.warn("权限校验失败 [%s]", "token为空");

            requestContext.setSendZuulResponse(false);
            requestContext.setResponseStatusCode(401);
            try {
                ResponseResult result = ResponseUtil.getInstance(false, ResultCode.PERMISSION_TOKEN_NULL, new HashMap<>(0));
                response.getWriter().append(JSONObject.toJSONString(result));
            } catch (IOException e) {
                log.error(e.getMessage(), e);
            }
        }else {
            boolean flag = false;

            try {
                flag = redisTemplate.hasKey(token);
            } catch (Exception e) {
                log.error(e.getMessage(), e);
            }

            if (!flag) {
                log.warn("权限校验失败 [%s]", "token过期");

                requestContext.setSendZuulResponse(false);
                requestContext.setResponseStatusCode(401);

                try {
                    ResponseResult result = ResponseUtil.getInstance(false, ResultCode.PERMISSION_TOKEN_EXPIRED, new HashMap<>(0));
                    response.getWriter().append(JSONObject.toJSONString(result));
                } catch (IOException e) {
                    log.error(e.getMessage(), e);
                }
            }
        }

        return null;
    }
}
