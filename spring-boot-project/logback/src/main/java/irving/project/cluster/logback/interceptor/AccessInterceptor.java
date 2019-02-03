package irving.project.cluster.logback.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@Component
public class AccessInterceptor implements HandlerInterceptor {

	private Logger logger =  LoggerFactory.getLogger(AccessInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		logger.info("=========preHandle");
		//打印请求地址和参数
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer = stringBuffer.append("请求地址：").append(request.getRequestURL()).append("?") ;
		//请求参数
		Map<String,String[]> paramMap = request.getParameterMap();
		Set keSet=paramMap.entrySet();
		for(Iterator itr = keSet.iterator(); itr.hasNext();){
			Map.Entry me=(Map.Entry)itr.next();
			String key=me.getKey().toString();
			String[] ov=(String[])me.getValue();
			String value = ov[0];
			stringBuffer.append(key).append("=").append(value).append("&");
		}
		logger.info(stringBuffer.toString());
			return true ;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		logger.info("=========postHandle");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		logger.info("=========afterCompletion") ;
	}
}
