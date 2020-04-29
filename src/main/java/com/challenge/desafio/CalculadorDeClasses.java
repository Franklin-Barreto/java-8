package com.challenge.desafio;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.Arrays;

import com.challenge.annotation.Somar;
import com.challenge.annotation.Subtrair;
import com.challenge.interfaces.Calculavel;

public class CalculadorDeClasses implements Calculavel {

	@Override
	public BigDecimal somar(Object classe) throws IllegalAccessException {
		return calcularStream(classe, Somar.class);
	}

	@Override
	public BigDecimal subtrair(Object classe) throws IllegalAccessException {
		return calcularForeach(classe, Subtrair.class);
	}

	@Override
	public BigDecimal totalizar(Object classe) throws IllegalAccessException {
		return somar(classe).subtract(subtrair(classe));
	}

	public BigDecimal calcularStream(Object obj, Class<? extends Annotation> anotacao) {
		Field[] fields = obj.getClass().getDeclaredFields();

		return Arrays.stream(fields).filter(f -> f.isAnnotationPresent(anotacao)).map(f -> obterValor(f, obj))
				.reduce(BigDecimal.ZERO, BigDecimal::add);
	}

	private BigDecimal obterValor(Field f, Object obj) {

		try {
			f.setAccessible(true);
			if (f.getType().equals(BigDecimal.class) && f.get(obj) != null) {
				return (BigDecimal) f.get(obj);
			}
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return BigDecimal.ZERO;
	}

	private BigDecimal calcularForeach(Object classe, Class<? extends Annotation> anotacao) {
		Field[] fields = classe.getClass().getDeclaredFields();
		BigDecimal valor = BigDecimal.ZERO;
		for (Field field : fields) {

			if (field.getAnnotation(anotacao) != null) {
				field.setAccessible(true);
				try {
					if (field.getGenericType().equals(BigDecimal.class) && field.get(classe) != null) {
						valor = valor.add((BigDecimal) field.get(classe));
					}
				} catch (IllegalArgumentException | IllegalAccessException e) {
					e.printStackTrace();
				}
			}

		}
		return valor;
	}

}