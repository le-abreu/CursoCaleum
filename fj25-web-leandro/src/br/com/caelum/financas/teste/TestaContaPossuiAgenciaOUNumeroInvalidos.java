package br.com.caelum.financas.teste;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import br.com.caelum.financas.infra.ValidatorUtil;
import br.com.caelum.financas.modelo.Conta;

public class TestaContaPossuiAgenciaOUNumeroInvalidos {

	public static void main(String[] args) {
		Validator validator = new ValidatorUtil().getValidator();
		
		Conta conta = new Conta();
		conta.setAgencia("Blabla");
		conta.setTitular("setiula");
		Set<ConstraintViolation<Conta>> erros = validator.validate(conta);
		
		for (ConstraintViolation<Conta> constraintViolation : erros) {
			System.out.println(constraintViolation.getPropertyPath() +" - "+ constraintViolation.getMessage());
		}

	}

}
