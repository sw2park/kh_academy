package com.codingbox.core3.dto;

import lombok.Getter;
import lombok.Setter;

/*
 *  lombok 라이브러리
 *  @Getter @Setter @ToString
 *	@RequiredArgsConstructor
 *	@Data <- lombok 라이브러리가 갖고있는 모든 데이터를 만들기때문에 실무에서 절대 쓰면 안됨
 */

@Getter @Setter
public class HelloData {
	private String username;
	private int age;
}