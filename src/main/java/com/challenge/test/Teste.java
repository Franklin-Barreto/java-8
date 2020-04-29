package com.challenge.test;

import java.math.BigDecimal;

import com.challenge.desafio.CalculadorDeClasses;

public class Teste {

	public static void main(String[] args) throws IllegalAccessException {
		CalculadorDeClasses calculador = new CalculadorDeClasses();
		ClasseTest classeTest = new ClasseTest(new BigDecimal(2000),new BigDecimal(3000),"Teste");
		
		System.out.println(BigDecimal.ZERO.equals(calculador.somar(classeTest)));
		System.out.println(calculador.somar(classeTest));
		System.out.println(calculador.somar(classeTest).equals(new BigDecimal(5000)));
	}
}
