import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class Locacao {
	private Date dataLocacao;
	private Cliente cliente;
	private List<Veiculo> veiculos;
	
	public Locacao(Cliente cliente) {
		setCliente(cliente);
		setDataLocacao(new Date());
		setVeiculos(new ArrayList<Veiculo>());
	}
	
	
}
