package org.zerock.myapp.controller;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.zerock.myapp.domain.Ticket;
import org.zerock.myapp.domain.User;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;


@Log4j2
@NoArgsConstructor


//(1) HTTP session 에 저장관리할 객체의 속성명을 지정
@SessionAttributes(names= { "USER", "TICKET" })

// (1) HTTP session 에 저장관리할 객체의 타입을 지정
//@SessionAttributes(types= { Ticket.class, User.class })

// (3) (1)과 (2)를 혼용
//@SessionAttributes(
//	names= { "USER", "TICKET" },
//	types= { Ticket.class, User.class }
//)


@Controller
public class SessionController 
	implements InitializingBean, DisposableBean {


	
	//===========================================================================//
	// 1. Session Scope 에 새로운 속성 바인딩
	//===========================================================================//
	// 이렇게 @ModelAttribute 어노테이션을 메소드에 붙이면, 이 handler 메소드의 리턴값이, 
	// 이 어노테이션의 value가 되고, 이 어노테이션에 붙인 이름이 key가 되어, request scope에 속성 바인딩됨.
	//
	// 더불어서, 이 어노테이션을 메소드에 붙이면, 비록 이 클래스에 @RestController 어노테이션이
	// 붙어 있어도, Spring MVC의 일반적인 @Controller 어노테이션을 붙인 메소드(즉, JSP 호출)가 됨
	// 이 때, 호출될 뷰의 이름은, 요청URI가 됨.
	//===========================================================================//
	
	@ModelAttribute("USER")	// request scope 속성명이 되고, 이 handler 메소드의 처리결과가 값이 됨. 	
	@GetMapping("/sessionScopeAutoBinding")
	User sessionScopeAutoBinding(String name, Integer age) {
		log.debug("sessionScopeAutoBinding(name, age) invoked.");
		
		log.info("\t+ name: " + name);
		log.info("\t+ age: " + age);
		
		return new User(name, age);
	} // sessionScopeAutoBinding
	
	// request scope 속성명이 되고, 이 handler 메소드의 처리결과가 값이 됨. 
	@ModelAttribute("TICKET")
	@GetMapping("/sessionScopeAutoBinding2")
	Ticket sessionScopeAutoBinding2(String owner, Double price, String grade) {
		log.debug("sessionScopeAutoBinding2(owner, price, grade");
		
		Ticket ticket = new Ticket(owner, price, grade);
		log.info("\t+ ticket: " + ticket);
		
		return ticket;
	} // sessionScopeAutoBinding2
	

	//===========================================================================//
	// 2. Session Scope 에 있는 속성 사용하기
	//===========================================================================//
	@GetMapping("/sessionScopeGetAttribute")
	void sessionScopeGetAttribute(
			// @ModelAttribute 어노테이션은, **Session Scope**에 바인딩되어있는 속성 중에, 
			// 그 이름이 value(name)속성에 지정된 이름의 속성값을 메소드의 매개변수 값으로 넣어줌.
			//
			// 이때, 핸들러 메소드 매개변수에 붙인 @ModelAttribute 어노테이션이, 전송파라미터의 바인딩을
			// 수행하여 매개변수 값을 엎어치지 않도록, binding 속성값을 false로 주면 됨.
			//
			// Session Scope에서 지정된 속성을 찾지 못하면, HttpSessionRequiredException 예외발생
			@ModelAttribute(name="USER", binding=false) User user
			
			// Case1: HttpSessionRequiredException: Expected session attribute 'KEY1'
			// @ModelAttribute("KEY1") String key	// XX : KEY1 이란 속성은 존재하지 않기 때문
		) {
		log.debug("sessionScopeGetAttribute(user) invoked.");
		
		log.info("\t+ user: " + user);
	} // sessionScopeGetAttribute
	
	
	@GetMapping("/sessionScopeGetAttribute2")
	void sessionScopeGetAttribute2(
			@ModelAttribute(name="TICKET", binding=false) Ticket ticket) {
		log.debug("sessionScopeGetAttribute2() invoked.");
		
		log.info("\t+ ticket: " + ticket);
	} // sessionScopeGetAttribute2

	
	//===========================================================================//
	// 3. Session Scope 에 있는 속성 삭제하기
	//===========================================================================//
	@GetMapping(path="/sessionScopeAllAttributesUnbinding", params= { "complete" })
	void sessionRemoveAllAttributes(SessionStatus sessionStatus) {
		log.debug("sessionRemoveAllAttributes(sessionStatus) invoked.");
		
		log.info("\t+ sessionStatus: " + sessionStatus);
		
		// Session Scope에 바인딩 되어있는 모든 속성들이 unbinding 됨.
		// 대신 HTTP session 자체를 파괴(invalidate)하지는 않음.
		//
		// 또한, Session Scope에 저장되어 있던 모든 속성은 자동으로 Request Scope에 저장되어
		// 호출될 뷰에 전달됨.
		sessionStatus.setComplete();
	} // sessionRemoveAllAttributes

		
	
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
