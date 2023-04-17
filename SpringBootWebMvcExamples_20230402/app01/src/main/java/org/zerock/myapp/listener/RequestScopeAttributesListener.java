package org.zerock.myapp.listener;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;


@Log4j2
@NoArgsConstructor

//@WebListener 어노테이션과 Spring component scan 으로는, listener 자동등록이 안됨
//@WebListener
public class RequestScopeAttributesListener
	implements ServletRequestAttributeListener {



	@Override
    public void attributeAdded(ServletRequestAttributeEvent e) {
    	if(
			e.getName().startsWith("org.springframework") || 
			e.getName().startsWith("org.apache") || 
			e.getName().startsWith("javax.servlet") || 
			e.getName().endsWith(".FILTERED")
		) {
    		return;
    	} // if

    	log.debug("==================================");
    	log.debug("attributeAdded(e) invoked.");
    	log.debug("==================================");
    	
    	String name = e.getName();
    	Object value = e.getValue();
    	
    	log.info("\t+ name: " + name);
    	log.info("\t+ value: " + value);
    } // attributeAdded
	
	
	@Override
    public void attributeRemoved(ServletRequestAttributeEvent e) {
    	if(
			e.getName().startsWith("org.springframework") || 
			e.getName().startsWith("org.apache") || 
			e.getName().startsWith("javax.servlet") || 
			e.getName().endsWith(".FILTERED")
		) {
    		return;
    	} // if

    	log.debug("==================================");
    	log.debug("attributeRemoved(e) invoked.");
    	log.debug("==================================");
    	
    	String name = e.getName();
    	Object value = e.getValue();
    	
    	log.info("\t+ name: " + name);
    	log.info("\t+ value: " + value);
    } // attributeRemoved


	@Override
    public void attributeReplaced(ServletRequestAttributeEvent e) {
    	if(
			e.getName().startsWith("org.springframework") || 
			e.getName().startsWith("org.apache") || 
			e.getName().startsWith("javax.servlet") || 
			e.getName().endsWith(".FILTERED")
		) {
    		return;
    	} // if

    	log.debug("==================================");
    	log.debug("attributeReplaced(e) invoked.");
    	log.debug("==================================");
    	
    	String name = e.getName();
    	Object value = e.getValue();
    	
    	log.info("\t+ name: " + name);
    	log.info("\t+ value: " + value);
    } // attributeReplaced
	
} // end class
