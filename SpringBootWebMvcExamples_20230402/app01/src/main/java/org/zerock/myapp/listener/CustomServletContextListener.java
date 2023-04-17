package org.zerock.myapp.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;


@Log4j2
@NoArgsConstructor

//@WebListener 어노테이션과 Spring component scan 으로는, listener 자동등록이 안됨
//@WebListener
public class CustomServletContextListener
	implements ServletContextListener {
	
	
	
	@Override
	public void contextInitialized(ServletContextEvent e) {
    	log.debug("==================================");
		log.debug("contextInitialized(e) invoked.");
    	log.debug("==================================");
		
	} // contextInitialized

	@Override
	public void contextDestroyed(ServletContextEvent e) {
    	log.debug("==================================");
		log.debug("contextDestroyed(e) invoked.");
    	log.debug("==================================");
		
	} // contextDestroyed

} // end class
