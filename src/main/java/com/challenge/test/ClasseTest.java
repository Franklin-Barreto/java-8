package com.challenge.test;

import java.math.BigDecimal;

import com.challenge.annotation.Somar;
import com.challenge.annotation.Subtrair;

public class ClasseTest {

	@Somar
	private BigDecimal bigDecimal;
	@Subtrair
	private BigDecimal bigDecimal2;
	@Somar
	private String string;

	public ClasseTest(BigDecimal bigDecimal, BigDecimal bigDecimal2, String string) {
		this.bigDecimal = bigDecimal;
		this.bigDecimal2 = bigDecimal2;
		this.string = string;
		// TODO Auto-generated constructor stub
	}

	public BigDecimal getBigDecimal() {
		return bigDecimal;
	}

	public BigDecimal getBigDecimal2() {
		return bigDecimal2;
	}

	public String getString() {
		return string;
	}

}
