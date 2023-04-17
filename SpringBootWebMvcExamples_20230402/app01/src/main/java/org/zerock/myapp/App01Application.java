package org.zerock.myapp;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;


@Log4j2
@NoArgsConstructor

//@SpringBootApplication(scanBasePackages= {"org.zerock.myapp"})
@SpringBootApplication
public class App01Application
//	extends SpringBootServletInitializer
	implements InitializingBean, DisposableBean {

	
	
//	@Override
//	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//    	log.debug("==================================");
//		log.debug("configure(builder) invoked.");
//    	log.debug("==================================");
//		
//		return builder.sources(App01Application.class);
//	} // configure


	public static void main(String[] args) {
		log.debug("main(args) invoked.");
		
		SpringApplication.run(App01Application.class, args);
		
		//-------------------------------------------------------//
//		ConfigurableApplicationContext ctx = 
//				SpringApplication.run(App01Application.class, args);
//		
//		ctx.addApplicationListener(e -> {
//			log.debug("onApplicationEvent(e) invoked.");
//			
//			log.info("\t+ e: " + e);
//		}); // addApplicationListener
		//-------------------------------------------------------//
		
	} // main

	
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
