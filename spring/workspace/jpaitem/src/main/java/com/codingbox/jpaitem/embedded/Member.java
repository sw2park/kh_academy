package com.codingbox.jpaitem.embedded;

import java.time.LocalDateTime;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_generator6")
	@SequenceGenerator(name = "seq_generator6", sequenceName = "member3_seq", allocationSize = 1)
	private Long id;
	@Column(name = "name", nullable = false)
	private String username;
	
	// 기간
	@Embedded
	private Period period;
//	private LocalDateTime startDate;
//	private LocalDateTime endDate;
	
	// 주소
	@Embedded
	private Address address;
//	private String city;
//	private String street;
//	private String zipcode;
	
	// 회사 주소
//	@Embedded
//	@AttributeOverrides({
//		@AttributeOverride(name = "city", column = @Column(name = "WORK_CITY")),
//		@AttributeOverride(name = "street", column = @Column(name = "WORK_STREET")),
//		@AttributeOverride(name = "zipcode", column = @Column(name = "WORK_ZIPCODE")),
//	})
//	private Address workAddress;
}