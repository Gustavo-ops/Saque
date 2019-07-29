
package com.db1.db1start.contacorrenteTest.infra;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import coom.db1.db1stat.contacorrente.infra.Verificadora;


public class VerificadoraTest {
	  @Test
	    public void deveRetornarExceptionQuandoValorNull() {
	        String mensagem = null;
	        try {
	            Verificadora.verificaStringValida(null, "Valor não pode ser nulo");
	        } catch (RuntimeException e) {
	            mensagem = e.getMessage();
	        }
	        assertEquals("Valor não pode ser nulo", mensagem);
	    }

	    @Test
	    public void deveRetornarExceptionQuandoValorVazio() {
	        String mensagem = null;
	        try {
	            Verificadora.verificaStringValida("   ", "Valor não pode ser vazio");
	        } catch (RuntimeException e) {
	            mensagem = e.getMessage();
	        }
	        assertEquals("Valor não pode ser vazio", mensagem);
	    }

	    @Test
	    public void naoDeveRetornarExceptionQuandoValorValido() {
	        String mensagem = null;
	        try {
	            Verificadora.verificaStringValida("DB1 Start", "Valor não pode ser vazio");
	        } catch (RuntimeException e) {
	            mensagem = e.getMessage();
	        }
	        assertNull(mensagem);
	    }

}