package com.ancaiyun.intercetpor;

import com.alibaba.fastjson.JSON;
import com.ancaiyun.utils.Result;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class AddIntercetpor implements HandlerInterceptor {

	@Autowired
	private RestTemplate restTemplate;
	@Override
	public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
		response.setContentType("application/json;charset=UTF-8");
		String adminToken = null;
		Cookie[] cookies = request.getCookies();
		if(cookies != null){
			for(Cookie cookie : cookies){
				if(cookie.getName().equals("adminToken")){
					adminToken = cookie.getValue();
				}
			}
		}
		if(StringUtils.isBlank(adminToken)){
			adminToken=request.getParameter("adminToken");
		}
		String uri = request.getRequestURI().toString();
		String method = request.getMethod();
//		if(StringUtils.isNotBlank(adminToken)){
//			Result result  = restTemplate.getForEntity("http://micro-ancaiyun-zuul/admin-sso/v1/admin-authenticate?adminToken="+adminToken+"&requestUrl="+uri+"&method="+method,Result.class).getBody();
//			if("0".equals(result.getCode())){
//				return true;
//			}else{
//				PrintWriter writer = response.getWriter();
//				writer.write(JSON.toJSONString(result));
//				writer.flush();
//				writer.close();
//				return false;
//			}
//		}else{
//			Result result = new Result();
//			result.setMsg("后台未登录");
//			result.setCode("-998");
//			PrintWriter writer = response.getWriter();
//			writer.write(JSON.toJSONString(result));
//			writer.flush();
//			writer.close();
//			return false;
//		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {

	}

	@Override
	public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

	}

}
