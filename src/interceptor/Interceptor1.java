package interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class Interceptor1 implements HandlerInterceptor{

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		System.out.println("拦截后");
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		System.out.println("页面渲染");
		
	}
	/*
	 * 
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		//登录界面不拦截
		if(!request.getRequestURI().contains("/login")){
		String	username = (String) request.getSession().getAttribute("user_session");
		System.out.println(username);
		if(username == null){	
			response.sendRedirect(request.getContextPath()+"/login.action");
			return false;
		}
		}
		//返回true代表放行
		return true;
		
	}

}
