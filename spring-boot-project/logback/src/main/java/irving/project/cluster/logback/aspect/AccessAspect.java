package irving.project.cluster.logback.aspect;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


/**
 * 该类的作用主要是运用AspectJ这个aop工具类
 * 该类的主要作用是打印所有的 并计算器所用的时间
 */

@Aspect
@Component
public class AccessAspect {
	private Logger logger =  LoggerFactory.getLogger(AccessAspect.class);
	//切点为 controller 文件夹下面的所有方法
	/**
	 * 关于切点的表达式问题
	 */
	@Pointcut("execution(* irving.project.cluster.logback.controller..*.*(..))")
	public void pointCut(){}

	/**
	 * 前置通知，打印请求url
	 */
	@Before("pointCut()")
	public  void  beforeMethod(){
		logger.info("前置通知==========");
	}

	@After("pointCut()")
	public  void  afterMethod(){
		logger.info("后置置通知==========");
	}


	@Around("pointCut()")
	public  void  aroundMethod(ProceedingJoinPoint joinPoint) throws Throwable {
		logger.info("环绕通知==========");
		long starTime = System.currentTimeMillis();
		joinPoint.proceed();
		long endTime = System.currentTimeMillis();

		logger.info("总共耗时：" +(endTime-starTime));

	}

}
