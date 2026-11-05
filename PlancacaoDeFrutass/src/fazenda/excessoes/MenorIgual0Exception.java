package fazenda.excessoes;

public class MenorIgual0Exception extends IllegalArgumentException {

	public MenorIgual0Exception(String campo) {
		super(campo + " deve ser maior que 0");
	}
}
