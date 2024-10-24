package com.codingbox.jpaitem.embedded;

import java.time.LocalDateTime;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter @Setter
public class Period {
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	
	public Period(LocalDateTime startDate, LocalDateTime endDate) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	public Period() {}
}
