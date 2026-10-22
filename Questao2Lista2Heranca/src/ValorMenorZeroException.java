
public class ValorMenorZeroException extends IllegalArgumentException {

	public ValorMenorZeroException(String campo) {
		super(campo + " deve ser maior do que 0");
	}

}
