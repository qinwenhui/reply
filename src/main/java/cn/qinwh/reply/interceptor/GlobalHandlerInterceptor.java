package cn.qinwh.reply.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/*
 * 全局拦截器
 */
@Component
public class GlobalHandlerInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		//执行handler之前,在这里进行拦截，设置响应跨域
		response.setHeader("Access-Control-Allow-Origin","http://localhost:8000");
		response.setHeader("Access-Control-Allow-Credentials", "true");
		response.setHeader("Access-Control-Allow-Methods","GET, OPTIONS, HEAD, PUT, POST");
		response.setHeader("Access-Control-Allow-Headers", "Content-Type,Token");
		response.setContentType("application/json; charset=utf-8");
		System.out.println("跨域设置拦截成功");
		return true;
	}
	
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception e)
			throws Exception {
		//执行handler之后
		
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
			throws Exception {
		//执行
		
	}

}
