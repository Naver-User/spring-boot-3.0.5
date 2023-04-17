package org.zerock.myapp.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;



@Log4j2
@NoArgsConstructor

//@Component 어노테이션을 통해, Servlet container's Filter 등록가능
@Component
public class CustomFilter
	implements Filter, InitializingBean {

	
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
    	log.debug("==================================");
		log.debug("doFilter(req, res, chain) invoked.");
    	log.debug("==================================");
		
		chain.doFilter(req, res);		
	} // doFilter

	
	//==================================================//
	// 이 클래스로부터의 자바 빈 객체의 생성과 파괴에 대한 라이플사이클 메소드
	//==================================================//
	@Override
	public void afterPropertiesSet() throws Exception {
		log.debug("afterPropertiesSet() invoked.");
	} // afterPropertiesSet
	//==================================================//

} // end class
