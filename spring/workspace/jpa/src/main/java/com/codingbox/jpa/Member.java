package com.codingbox.jpa;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "MBR")
@Getter @Setter
public class Member {
	@Id
	private Long id;
	
	@Column(unique = true, length = 10)
	private String name;
	
	// 컬럼명 지정
	@Column(name="myage")
	private int age;
	
	// 날짜타입
	private LocalDateTime createdDate;
	
	// 매핑을 무시
	@Transient
	private int temp;
}