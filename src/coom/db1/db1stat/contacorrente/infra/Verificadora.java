package coom.db1.db1stat.contacorrente.infra;

public class Verificadora {
	public static void verificaStringValida(String value, String message) {
		if (value == null || value.trim().isEmpty()) {
			throw new RuntimeException(message);
		}
	}
	
	public static void valorMaiorQueZero(Double value, String mensagem) {
		if (value == null || value <= 0) {
			throw new RuntimeException(mensagem);
		}
	}
}
