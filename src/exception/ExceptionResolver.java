package exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/*
 * 异常处理器
 */
public class ExceptionResolver implements HandlerExceptionResolver{

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object arg2,
			Exception e) {
		ModelAndView mav = new ModelAndView(); 
		if(e instanceof MessageException){//判断抛出的异常是否为自己定义的异常
			MessageException me = (MessageException)e;
			mav.addObject("error",me.getMsg());
			mav.setViewName("/WEB-INF/jsp/error.jsp");
			return mav;
		}
		mav.addObject("error","未知的异常");
		mav.setViewName("/WEB-INF/jsp/error.jsp");
		return mav;
	}

}
