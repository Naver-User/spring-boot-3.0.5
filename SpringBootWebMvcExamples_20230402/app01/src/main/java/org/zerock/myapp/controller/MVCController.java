package org.zerock.myapp.controller;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;


@Log4j2
@NoArgsConstructor

@Controller
public class MVCController
	implements InitializingBean, DisposableBean {
	
	
	
	@GetMapping("/sample1")
	public String sample1() {
		log.debug("sample1() invoked.");
		
		return "sample1";
	} // sample1
	
	
	@GetMapping("/sample2")
	public void sample2() {
		log.debug("sample2() invoked.");
				
	} // sample2

	
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
