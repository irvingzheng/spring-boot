package irving.project.cluster.logback.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogbackController {
	Logger log = LoggerFactory.getLogger(LogbackController.class);

	@RequestMapping(value = "/hello",method = {RequestMethod.POST,RequestMethod.GET})
	public String hello(){
		log.debug("this is debug");
		log.info("this is info");
		log.warn("this is warm ");
		log.error("this is error");
		return "hello";

	}

}
