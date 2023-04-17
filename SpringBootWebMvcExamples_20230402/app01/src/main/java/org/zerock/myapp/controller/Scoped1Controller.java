package org.zerock.myapp.controller;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.zerock.myapp.domain.Cart;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;



@Log4j2
@NoArgsConstructor

@Controller
public class Scoped1Controller
	implements InitializingBean, DisposableBean {

//	@Autowired
	@Setter(onMethod_=@Autowired)
	private Cart cart;
	

	
	@GetMapping("/setCart")
	void setCart(String name, Integer age, Model model) {
		log.debug("setCart(name, age, model) invoked.");
		
		this.cart.setName(name);
		this.cart.setAge(age);
		
		//-----------------------------------------//
		log.info("\t+ cart: " + this.cart);
		log.info("\t+ type: " + this.cart.getClass().getName());
		log.info("\t+ hashCode: " + this.cart.hashCode());
		//-----------------------------------------//
		
		// 만일 주입받은 Scoped Bean의 scope이 "singleton or prototype"인 경우는
		// 아래와 같이, 이미 주입받은 Scoped Bean 객체를 Model에 추가하여
		// View(JSP)에 전달(request scope에 저장하여 전달)
//		model.addAttribute("scopedTarget.cart", this.cart);
	} // setCart

		
	
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
