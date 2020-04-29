package com.challenge.interfaces;

import java.math.BigDecimal;

public interface Calculavel {

	BigDecimal somar(Object classe) throws IllegalAccessException;

	BigDecimal subtrair(Object classe) throws IllegalAccessException;

	BigDecimal totalizar(Object classe) throws IllegalAccessException;
}
