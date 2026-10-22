
public class CampoNaoInformadoException extends IllegalArgumentException {

	public CampoNaoInformadoException(String campo) {
		super(campo + " deve ser informado/a");
	}

}
