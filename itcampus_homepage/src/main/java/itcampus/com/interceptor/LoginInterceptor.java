package itcampus.com.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import itcampus.com.controller.AdminController;
import itcampus.com.vo.MemberVO;

@Component
public class LoginInterceptor implements HandlerInterceptor {
 
	Logger logger=LoggerFactory.getLogger(LoginInterceptor.class);

	@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 세션에서 로그인 사용자 정보를 가져옵니다.
        HttpSession session = request.getSession(false);

        if (session == null) {
            // 로그인 페이지로 리다이렉트
            response.sendRedirect("/admin/login");
            return false; // 컨트롤러 메소드 실행을 중단
        }
        
        Object loginUser = session.getAttribute("loginUser");

        // 로그인하지 않은 경우
        if (loginUser == null) {
            // 로그인 페이지로 리다이렉트
            response.sendRedirect("/admin/login");
            return false; // 컨트롤러 메소드 실행을 중단
        }
        
        logger.info("-- 이미 로그인 되어 있음 : " + ((MemberVO)loginUser).getMid());

        return true; // 로그인한 경우, 컨트롤러 메소드 실행
    }

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}
	
}
