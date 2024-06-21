package com.camel.project.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class Reserve {

	private int reservNo;
	private String memberId;
	private int programNo;
	private int reservTotalCount;
	private int childCount;
	private int adultCount;
	private Date paymentDate;
	private Date reservDate;
	private String reservCancle;
	private String reservExprt;
}
