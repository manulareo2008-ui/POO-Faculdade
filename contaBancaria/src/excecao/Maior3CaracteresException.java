package excecao;

public class Maior3CaracteresException extends IllegalArgumentException {

	public Maior3CaracteresException(String campo) {
		super(campo + " deve ter no mínimo 3 caracteres.");
	}
}
