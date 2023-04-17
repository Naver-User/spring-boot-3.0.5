package org.zerock.myapp.config;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.SessionScope;
import org.zerock.myapp.domain.Cart;
import org.zerock.myapp.listener.ApplicationScopeAttributesListener;
import org.zerock.myapp.listener.CustomHttpSessionListener;
import org.zerock.myapp.listener.CustomServletContextListener;
import org.zerock.myapp.listener.RequestScopeAttributesListener;
import org.zerock.myapp.listener.SessionScopeAttributesListener;
import org.zerock.myapp.sevlet.CustomServlet;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;


@Log4j2
@NoArgsConstructor

@Configuration
public class WebMvcConfig
	implements InitializingBean, DisposableBean {
	
	
	@Bean
//	@Scope(
		//--1. Web Aware Scopes
//		scopeName=WebApplicationContext.SCOPE_SESSION,
//		scopeName=WebApplicationContext.SCOPE_REQUEST,
//		scopeName=WebApplicationContext.SCOPE_APPLICATION,
//			
//			
		//--2. Other Scopes
		//--2-1. singleton scope
		// This scope is the default value if no other scope is specified.
//		scopeName="singleton",
//		scopeName=ConfigurableBeanFactory.SCOPE_SINGLETON,
//		
		//--2-2. prototype scope
		// A bean with the prototype scope will return a different instance 
		// every time it is requested from the container.
//		scopeName="prototype",
//		scopeName=ConfigurableBeanFactory.SCOPE_PROTOTYPE,
//			
		//--2-3. websocket scope
//		When first accessed, WebSocket scoped beans are stored in the WebSocket session attributes. 
//		The same instance of the bean is then returned whenever that bean is accessed 
//		during the entire WebSocket session.
//
//		We can also say that it exhibits singleton behavior, 
//		but limited to a WebSocket session only.
//		scopeName="websocket",
//		
//		proxyMode=ScopedProxyMode.TARGET_CLASS
//	)	// Before spring v4.3
	
	// 아래의 모든 어노테이션의 기본 proxyMode는 모두 ScopedProxyMode.TARGET_CLASS 임.
	// 따라서, 굳이 proxyMode를 지정해 줄 필요 없음.
//	@SessionScope(proxyMode=ScopedProxyMode.TARGET_CLASS)		// Since spring v4.3
	@SessionScope
	
//	@RequestScope(proxyMode=ScopedProxyMode.TARGET_CLASS)		// Since spring v4.3
//	@RequestScope
	
//	@ApplicationScope(proxyMode=ScopedProxyMode.TARGET_CLASS)	// Since spring v4.3
//	@ApplicationScope
	public Cart createCartBean() {
		log.debug("createCartBean() invoked.");
		
		return new Cart();
	} // createCartBean
	
	
	// 새로운 Servlet 을 Bean 으로 등록하면, 이 Servlet 이 동작함.
	@Bean
	public ServletRegistrationBean<CustomServlet> customSevletBean() {
		log.debug("customSevletBean() invoked.");
		
		ServletRegistrationBean<CustomServlet> bean = 
			new ServletRegistrationBean<>(new CustomServlet(), "/customServlet");
		
		return bean;
	} // customSevletBean
	

	// 새로운 CustomServletContextListener 을 Bean 으로 등록하면, 이 Listener 이 동작함.
	@Bean
	public ServletListenerRegistrationBean<CustomServletContextListener> customServletContextListenerBean() {
		log.debug("customServletContextListenerBean() invoked.");
		
		ServletListenerRegistrationBean<CustomServletContextListener> bean = 
			new ServletListenerRegistrationBean<>();
		
		bean.setListener(new CustomServletContextListener());
		
		return bean;
	} // customServletContextListenerBean
	

	// 새로운 ApplicationScopeAttributesListener 을 Bean 으로 등록하면, 이 Listener 이 동작함.
	@Bean
	public ServletListenerRegistrationBean<ApplicationScopeAttributesListener> applicationScopeAttributesListenerBean() {
		log.debug("applicationScopeAttributesListenerBean() invoked.");
		
		ServletListenerRegistrationBean<ApplicationScopeAttributesListener> bean = 
			new ServletListenerRegistrationBean<>();
		
		bean.setListener(new ApplicationScopeAttributesListener());
		
		return bean;
	} // applicationScopeAttributesListenerBean
	

	// 새로운 RequestScopeAttributesListener 을 Bean 으로 등록하면, 이 Listener 이 동작함.
	@Bean
	public ServletListenerRegistrationBean<RequestScopeAttributesListener> requestScopeAttributesListenerBean() {
		log.debug("requestScopeAttributesListenerBean() invoked.");
		
		ServletListenerRegistrationBean<RequestScopeAttributesListener> bean = 
			new ServletListenerRegistrationBean<>();
		
		bean.setListener(new RequestScopeAttributesListener());
		
		return bean;
	} // requestScopeAttributesListenerBean
	

	// 새로운 SessionScopeAttributesListener 을 Bean 으로 등록하면, 이 Listener 이 동작함.
	@Bean
	public ServletListenerRegistrationBean<SessionScopeAttributesListener> sessionScopeAttributesListenerBean() {
		log.debug("sessionScopeAttributesListenerBean() invoked.");
		
		ServletListenerRegistrationBean<SessionScopeAttributesListener> bean = 
			new ServletListenerRegistrationBean<>();
		
		bean.setListener(new SessionScopeAttributesListener());
		
		return bean;
	} // sessionScopeAttributesListenerBean
	
	
	// 새로운 SessionScopeAttributesListener 을 Bean 으로 등록하면, 이 Listener 이 동작함.
	@Bean
	public ServletListenerRegistrationBean<CustomHttpSessionListener> customHttpSessionListener() {
		log.debug("sessionScopeAttributesListenerBean() invoked.");
				
		ServletListenerRegistrationBean<CustomHttpSessionListener> bean = 
			new ServletListenerRegistrationBean<>();
		
		bean.setListener(new CustomHttpSessionListener());
		
		return bean;
	} // customHttpSessionListener

	
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
