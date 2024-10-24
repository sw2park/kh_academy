package com.codingbox.jpaitem.embedded;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter //@Setter
/*
 * 부작용을 막기위해서 setter를 없앤다.
 */
public class Address {
	private String city;
	private String street;
	private String zipcode;
	
	// 테스트를 위해 파라미터가 있는 생성자
	public Address(String city, String street, String zipcode) {
		super();
		this.city = city;
		this.street = street;
		this.zipcode = zipcode;
	}
	
	// 기본생성자는 반드시 있어야한다.
	public Address() {}
}
