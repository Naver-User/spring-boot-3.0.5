package org.zerock.myapp.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {	
	private String 	owner;
	private Double	price;
	private String 	grade;

	
	
} // end class
