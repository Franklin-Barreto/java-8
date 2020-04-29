package com.challenge.desafio;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;

import com.challenge.annotation.Somar;
import com.challenge.annotation.Subtrair;
import com.challenge.interfaces.Calculavel;

public class CalculadorDeClasses2 implements Calculavel {

	//public ArrayList<Object> acumuladorBigDecimal(Object classe) {
		public BigDecimal acumuladorBigDecimal(Object classe) {
		//ArrayList<Object> todosBigDecimal = new ArrayList<>();
		BigDecimal valor = BigDecimal.ZERO;
		try {
			//Object.class.getDeclaredFields();
			Field[] parametros = classe.getClass().getDeclaredFields();
			for (Field parametro : parametros) {
				if ((parametro.isAnnotationPresent(Somar.class) || parametro.isAnnotationPresent(Subtrair.class))
						&& parametro.getType().isAssignableFrom(java.math.BigDecimal.class)) {
					parametro.setAccessible(true);
				  valor =	valor.add((BigDecimal) parametro.get(classe));
				} /*else {
					todosBigDecimal.add(BigDecimal.ZERO);
				}*/
			}
		} catch (Throwable e) {
			System.out.println("Erro ao acessar atributos da classe"+e.getMessage());
		}
		//todosBigDecimal.forEach(System.out::println);
		//return todosBigDecimal;
		return valor;
	}

	/*private BigDecimal fazerCalculoBase(Object classe, Class annotation) {
		BigDecimal somaBigDecimal = BigDecimal.ZERO;
		ArrayList<Object> todosBigDecimal = acumuladorBigDecimal(classe);
		for (Object valor : todosBigDecimal) {
			somaBigDecimal = somaBigDecimal.add((BigDecimal) valor);
		}
		return somaBigDecimal;
	}*/

	@Override
	public BigDecimal somar(Object classe) throws IllegalAccessException {
		//return fazerCalculoBase(classe, Somar.class);
	   return acumuladorBigDecimal(classe);
	}

	@Override
	public BigDecimal subtrair(Object classe) throws IllegalAccessException {
		//return fazerCalculoBase(classe, Subtrair.class);
		return acumuladorBigDecimal(classe);
	}

	@Override
	public BigDecimal totalizar(Object classe) throws IllegalAccessException {
		return somar(classe).subtract(subtrair(classe));
	}
}