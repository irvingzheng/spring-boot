package irving.project.cluster.logback.configuration;

import irving.project.cluster.logback.interceptor.AccessInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootConfiguration
public class AccessConfiguration extends WebMvcConfigurerAdapter {

	@Autowired
	private AccessInterceptor accessInterceptor ;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(accessInterceptor).addPathPatterns("/**");
	}
}
