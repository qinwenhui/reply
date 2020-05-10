package cn.qinwh.reply.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.qinwh.reply.pojo.Role;
import cn.qinwh.reply.pojo.User;
import cn.qinwh.reply.service.PermissionService;
import cn.qinwh.reply.utils.BaseJson;
import cn.qinwh.reply.utils.ConstUtil;
import cn.qinwh.reply.utils.RedisUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Component
public class PermissionInterceptor implements HandlerInterceptor{

	@Autowired
	PermissionService permissionService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		System.out.println("权限拦截器");
		//先判断该urk属于什么角色可以访问
		List<Role> roleList = permissionService.queryRoleByUrl(request.getServletPath());
		if(roleList.isEmpty()){
			//不属于任何的角色，说明游客可以访问
			return true;
		}
		//获取用户请求发送过来的token
		String userToken = request.getHeader("Token");
		System.out.println("11111"+request.getServletPath()+" "+userToken);
		if(userToken == null){
			//token无效,拒绝访问
			no(response);
			System.out.println("11111");
			return false;
		}
		//通过与redis中保存的token比较
		User user = RedisUtil.get(userToken, User.class);
		if(user == null){
			//token失效,拒绝访问
			no(response);
			System.out.println("22222");
			return false;
		}
		//查看该用户是否属于能访问该url的角色
		for (Role role : roleList){
			if(user.getRoleId() == role.getId()){
				//可以通过，设置用户id到request域
				request.setAttribute("user", user);
				//更新Redis中保存的token时效
				RedisUtil.set(userToken, user, ConstUtil.TOKEN_SAVE_TIME);
				return true;
			}else{
				System.out.println(user.getRoleId()+"-"+role.getId()+""+role.getName()+"-"+roleList.size());
			}
		}

		no(response);
		return false;
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

	private void no(HttpServletResponse response) throws Exception {
		response.setStatus(200);
		BaseJson json = new BaseJson(403, "没有权限", null);
		ObjectMapper mapper=new ObjectMapper();
		String jsonStr = mapper.writeValueAsString(json);
		response.getWriter().write(jsonStr);
	}
}
