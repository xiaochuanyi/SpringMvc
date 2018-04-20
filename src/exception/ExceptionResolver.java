package exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/*
 * �쳣������
 */
public class ExceptionResolver implements HandlerExceptionResolver{

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object arg2,
			Exception e) {
		ModelAndView mav = new ModelAndView(); 
		if(e instanceof MessageException){//�ж��׳����쳣�Ƿ�Ϊ�Լ�������쳣
			MessageException me = (MessageException)e;
			mav.addObject("error",me.getMsg());
			mav.setViewName("/WEB-INF/jsp/error.jsp");
			return mav;
		}else{
		mav.addObject("error","δ֪���쳣");
		mav.setViewName("/WEB-INF/jsp/error.jsp");
		}
		return mav;
	}

}
