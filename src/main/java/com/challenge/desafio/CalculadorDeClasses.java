package com.challenge.desafio;

import java.lang.reflect.Field;
import java.math.BigDecimal;

import com.challenge.annotation.Somar;
import com.challenge.annotation.Subtrair;
import com.challenge.interfaces.Calculavel;

public class CalculadorDeClasses implements Calculavel {

	@Override
	public BigDecimal somar(Object classe) {
		// TODO Auto-generated method stub
		return calcular(classe, Somar.class);
	}

	@Override
	public BigDecimal subtrair(Object classe) {
		// TODO Auto-generated method stub
		return calcular(classe, Subtrair.class);
	}

	private BigDecimal calcular(Object classe, Class anotacao) {
		Field[] fields = classe.getClass().getDeclaredFields();
		BigDecimal valor = BigDecimal.ZERO;
		for (Field field : fields) {
			try {
				if (field.getAnnotation(anotacao) != null) {
					field.setAccessible(true);
					if (field.getGenericType().equals(BigDecimal.class) && field.get(classe) != null) {
						valor = valor.add((BigDecimal) field.get(classe));
					}
				}

			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return valor;
	}

	@Override
	public BigDecimal totalizar(Object classe) {
		BigDecimal somar = somar(classe);
		BigDecimal subtrair = subtrair(classe);
		return somar.subtract(subtrair);
	}

}
