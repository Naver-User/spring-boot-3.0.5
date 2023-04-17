package org.zerock.myapp.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;


@Log4j2
@NoArgsConstructor

//@WebListener 어노테이션과 Spring component scan 으로는, listener 자동등록이 안됨
//@WebListener
public class CustomHttpSessionListener
	implements HttpSessionListener {
	
	
	
	@Override
	public void sessionCreated(HttpSessionEvent e) {
		log.debug("sessionCreated(e) invoked.");
		
		log.info("\t+ Session ID: " + e.getSession().getId());
	} // sessionCreated

	@Override
	public void sessionDestroyed(HttpSessionEvent e) {
		log.debug("sessionDestroyed(e) invoked.");

		log.info("\t+ Session ID: " + e.getSession().getId());
	} // sessionDestroyed

} // end class
