package com.challenge.test;

import java.math.BigDecimal;

import com.challenge.desafio.CalculadorDeClasses;

public class Teste {

	public static void main(String[] args) throws IllegalAccessException {
		CalculadorDeClasses calculador = new CalculadorDeClasses();
		ClasseTest classeTest = new ClasseTest(null,null,"Teste");
		
		System.out.println(BigDecimal.ZERO.equals(calculador.somar(classeTest)));
		System.out.println(calculador.somar(classeTest));
		System.out.println(calculador.somar(classeTest).equals(new BigDecimal(5000)));
	}
}
