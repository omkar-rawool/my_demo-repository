package com.mapping.demo.interceptor;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mapping.demo.utils.HelperUtils;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Log4j2
@Component
public class MyInterceptor implements HandlerInterceptor {

    private final ObjectMapper objectMapper;

    public MyInterceptor(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("=========Inside PreHandle Interceptor=========");

        if (isHttpOptionsMethod(request)) {
            return true;
        }

        final String encToken = request.getHeader("token");

        if (StringUtils.isNotBlank(encToken)) {

            String externalId = HelperUtils.detokenize(encToken);



            JSONObject jsonObject = new JSONObject(externalId);
            Map<String, Long> externalIdsMap = objectMapper.readValue(jsonObject.toString(), new TypeReference<>() {
            });



            request.setAttribute("personId", externalIdsMap.get("personId"));

           // request.setAttribute("personId",externalId);
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        log.info("postHandle PostHandle Interceptor");
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("afterCompletion afterComplication Interceptor");
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }


    private boolean isHttpOptionsMethod(HttpServletRequest httpServletRequest) {
        return httpServletRequest.getMethod() != null && httpServletRequest.getMethod()
                .equalsIgnoreCase(HttpMethod.OPTIONS.name());
    }

}
