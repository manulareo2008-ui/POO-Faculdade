import java.util.List;
import java.util.ArrayList;

public class Pedido {
	private int numero;
	private String nomeCliente;
	private List<Sorvete> sorvetes;

	public Pedido(int numero, String nomeCliente) {
		setNumero(numero);
		setNomeCliente(nomeCliente);
		sorvetes = new ArrayList<Sorvete>();
	}

	public int getNumero() {
		return numero;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public List<Sorvete> getSorvetes() {
		return sorvetes;
	}

	public void setNumero(int numero) throws IllegalArgumentException {
		if (numero <= 0) {
			throw new IllegalArgumentException("O número do pedido deve ser maior do que 0");
		}

		this.numero = numero;
	}

	public void setNomeCliente(String nomeCliente) throws IllegalArgumentException {
		if (nomeCliente == null || nomeCliente.isBlank()) {
			throw new IllegalArgumentException("O nome do cliente deve ser preenchido");
		}
		if (nomeCliente.length() < 3) {
			throw new IllegalArgumentException("O nome do cliente deve ter pelo menos 3 caracteres");
		}

		this.nomeCliente = nomeCliente;
	}

	public Sorvete identificarSorvete(String nome) {
		for (Sorvete s : sorvetes) {
			if (s.getNome().equals(nome)) {
				return s;
			}
		}
		return null;
	}

	public boolean removerSorvete(String nome) {
		Sorvete sabor = identificarSorvete(nome);
		if (sabor == null) {
			return false;
		}
		sorvetes.remove(sabor);
		return true;
	}

	public void cadastrarSorvete(Sorvete sorvete) {
		if (sorvete != null) {
			sorvetes.add(sorvete);
		}
	}

	public int qntDeSorvetesNoPedido() {
		return sorvetes.size();
	}

	public Sorvete sorveteComMaiorNome() {
		if (sorvetes.isEmpty()) {
			return null;
		}
		Sorvete maior = sorvetes.get(0);
		for (Sorvete s : sorvetes) {
			if (s.getNome().length() > maior.getNome().length()) {
				maior = s;
			}
		}
		return maior;
	}

	public int qntSorvetesPorSabor(String sabor) {
	    int qnt = 0;
	    for (Sorvete s : sorvetes) {
	        if (s.getSabor().equals(sabor)) {
	            qnt++;
	        }
	    }
	    return qnt;
	}

	public String listarSabores() {
		String dados = "";
		for (Sorvete s : sorvetes) {
			dados += s.imprimirDados() + "\n";
		}
		return dados;
	}

	public String imprimirDados() {
		return getNumero() + " - " + getNomeCliente() + "\n" + listarSabores();
	}
}
