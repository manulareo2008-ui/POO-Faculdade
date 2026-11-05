package pizzaria.excessao;

public class CampoVazioException extends IllegalArgumentException {

	public CampoVazioException(String campo) {
		super(campo + " deve ser preenchido(a)");
	}
}
