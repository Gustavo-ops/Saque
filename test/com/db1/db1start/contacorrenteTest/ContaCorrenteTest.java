package com.db1.db1start.contacorrenteTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import coom.db1.db1stat.contacorrente.ContaCorrente;

public class ContaCorrenteTest {
	 @Test
	    public void deveRetornarErroQuandoInformadoAgenciaInvalida() {
	        String mensagem = null;

	        try {
	            ContaCorrente contaCorrente = new ContaCorrente(null, "00009876", "Gustavo Fatega");
	        } catch (RuntimeException e) {
	            mensagem = e.getMessage();
	        }

	        assertNotNull(mensagem);
	        assertEquals("Deve ser informada uma agência válida", mensagem);
	    }

	    @Test
	    public void deveRetornarErroQuandoInformadoNumeroInvalido() {
	        String mensagem = null;

	        try {
	            ContaCorrente contaCorrente = new ContaCorrente("0465", null, "Gustavo Fatega");
	        } catch (RuntimeException e) {
	            mensagem = e.getMessage();
	        }

	        assertNotNull(mensagem);
	        assertEquals("Deve ser informado um número de conta válido", mensagem);
	    }

	    @Test
	    public void deveRetornarErroQuandoInformadoClienteInvalido() {
	        String mensagem = null;

	        try {
	            ContaCorrente contaCorrente = new ContaCorrente("0465", "0135293", null);
	        } catch (RuntimeException e) {
	            mensagem = e.getMessage();
	        }

	        assertNotNull(mensagem);
	        assertEquals("Deve ser informado um cliente válido", mensagem);
	    }

	    @Test
	    public void deveCriarContaCorrenteComValoresValidos() {
	        ContaCorrente contaCorrente = new ContaCorrente("0465", "02487532", "Gustavo Fatega");

	        assertEquals("0465", contaCorrente.getAgencia());
	        assertEquals("02487532", contaCorrente.getNumero());
	        assertEquals("Guilherme Amado", contaCorrente.getCliente());
	        assertEquals(0.0, contaCorrente.getSaldo(), 0.0001);
	        assertEquals(0, contaCorrente.getHistorico().size());
	    }

	    @Test
	    public void deveRetornarErroQuandoValorDepositadoInvalido() {
	        ContaCorrente contaCorrente = new ContaCorrente("0465", "02487532", "Gustavo Fatega");
	        String mensagem = null;

	        try {
	            contaCorrente.depositar(-0.01);
	        } catch (RuntimeException e) {
	            mensagem = e.getMessage();
	        }

	        assertEquals("Valor a ser depositado deve ser maior que zero", mensagem);
	        assertEquals(0.0, contaCorrente.getSaldo(), 0.0001);
	        assertEquals(0, contaCorrente.getHistorico().size());
	    }

	    @Test
	    public void deveRetornarErroQuandoValorDepositadoForZero() {
	        ContaCorrente contaCorrente = new ContaCorrente("0465", "02487532", "Gustavo Fatega");
	        String mensagem = null;

	        try {
	            contaCorrente.depositar(0.0);
	        } catch (RuntimeException e) {
	            mensagem = e.getMessage();
	        }

	        assertEquals("Valor a ser depositado deve ser maior que zero", mensagem);
	        assertEquals(0.0, contaCorrente.getSaldo(), 0.0001);
	        assertEquals(0, contaCorrente.getHistorico().size());
	    }

	    @Test
	    public void deveRetornarErroQuandoValorDepositadoForNull() {
	        ContaCorrente contaCorrente = new ContaCorrente("0465", "02487532", "Gustavo Fatega");
	        String mensagem = null;

	        try {
	            contaCorrente.depositar(null);
	        } catch (RuntimeException e) {
	            mensagem = e.getMessage();
	        }

	        assertEquals("Valor a ser depositado deve ser maior que zero", mensagem);
	        assertEquals(0.0, contaCorrente.getSaldo(), 0.0001);
	        assertEquals(0, contaCorrente.getHistorico().size());
	    }

	    @Test
	    public void deveDepositarValor() {
	        ContaCorrente contaCorrente = new ContaCorrente("0465", "02487532", "Gustavo Fatega");
	        contaCorrente.depositar(100.0);

	        assertEquals(100.0, contaCorrente.getSaldo(), 0.001);
	        assertEquals("Depositado: R$ 100.0", contaCorrente.getHistorico().get(0));
	    }
	    @Test
	    public void deveRetornarErroQuandoValorSacadoInvalido() {
	        ContaCorrente contaCorrente = new ContaCorrente("0465", "02487532", "Gustavo Fatega");
	        String mensagem = null;

	        try {
	            contaCorrente.sacar(-0.01);
	        } catch (RuntimeException e) {
	            mensagem = e.getMessage();
	        }

	        assertEquals("Valor a ser sacado deve ser maior que zero", mensagem);
	        assertEquals(0.0, contaCorrente.getSaldo(), 0.0001);
	        assertEquals(0, contaCorrente.getHistorico().size());
	    }

	    @Test
	    public void deveRetornarErroQuandoValorSacadoForZero() {
	        ContaCorrente contaCorrente = new ContaCorrente("0465", "02487532", "Gustavo Fatega");
	        String mensagem = null;

	        try {
	            contaCorrente.sacar(0.0);
	        } catch (RuntimeException e) {
	            mensagem = e.getMessage();
	        }

	        assertEquals("Valor a ser sacado deve ser maior que zero", mensagem);
	        assertEquals(0.0, contaCorrente.getSaldo(), 0.0001);
	        assertEquals(0, contaCorrente.getHistorico().size());
	    }

	    @Test
	    public void deveRetornarErroQuandoValorSacadoForNull() {
	        ContaCorrente contaCorrente = new ContaCorrente("0465", "02487532", "Gustavo Fatega");
	        String mensagem = null;

	        try {
	            contaCorrente.sacar(null);
	        } catch (RuntimeException e) {
	            mensagem = e.getMessage();
	        }

	        assertEquals("Valor a ser sacado deve ser maior que zero", mensagem);
	        assertEquals(0.0, contaCorrente.getSaldo(), 0.0001);
	        assertEquals(0, contaCorrente.getHistorico().size());
	    }

	    @Test
	    public void deveRetornarErroQuandoValorSacadoForMaiorQueSaldo() {
	        ContaCorrente contaCorrente = new ContaCorrente("0465", "02487532", "Gustavo Fatega");
	        String mensagem = null;

	        try {
	            contaCorrente.sacar(30.0);
	        } catch (RuntimeException e) {
	            mensagem = e.getMessage();
	        }

	        assertEquals("Valor a ser sacado é maior do que disponível em conta", mensagem);
	        assertEquals(0.0, contaCorrente.getSaldo(), 0.0001);
	        assertEquals(0, contaCorrente.getHistorico().size());
	    }

	    @Test
	    public void deveSacarValor() {
	        ContaCorrente contaCorrente = new ContaCorrente("0465", "02487532", "Gustavo Fatega");
	        contaCorrente.depositar(100.0);
	        contaCorrente.sacar(30.0);

	        assertEquals(70.0, contaCorrente.getSaldo(), 0.001);
	        assertEquals("Depositado: R$ 100.0", contaCorrente.getHistorico().get(0));
	        assertEquals("Sacado: R$ 30.0", contaCorrente.getHistorico().get(1));
	    }

}
