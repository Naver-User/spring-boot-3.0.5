package org.zerock.myapp.controller;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.myapp.domain.Ticket;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;


@Log4j2
@NoArgsConstructor

@RestController
public class HelloController
	implements InitializingBean, DisposableBean {
	
	
	@GetMapping("/")
	String hello() {
		log.debug("hello() invoked.");
		
		return "Hello";
	} // hello
	
	
	@GetMapping("/ticket")
	Ticket ticket() {
		log.debug("ticket() invoked.");
		
		String owner = "trinity";
		Double price = 127.77;
		String grade = "B";
		
		Ticket ticket = new Ticket(owner, price, grade);
		log.info("\t+ newTicket: " + ticket);
		
		return ticket;
	} // ticket
	
	
	
	//==================================================//
	// 이 클래스로부터의 자바 빈 객체의 생성과 파괴에 대한 라이플사이클 메소드
	//==================================================//
	@Override
	public void afterPropertiesSet() throws Exception {
		log.debug("afterPropertiesSet() invoked.");

	} // afterPropertiesSet
	
	@Override
	public void destroy() throws Exception {
		log.debug("destroy() invoked.");
		
	} // destroy
	//==================================================//

} // end class
