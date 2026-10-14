import java.util.Date;

public class Servico {
	private int numero;
	private String descricao;
	private float valor;
	private Veiculo veiculo;
	private Date data;

	public Servico(int numero, String descricao, float valor, Veiculo veiculo) {
		setNumero(numero);
		setDescricao(descricao);
		setValor(valor);
		setVeiculo(veiculo);
		setData(new Date());
	}

	public int getNumero() {
		return numero;
	}

	public String getDescricao() {
		return descricao;
	}

	public float getValor() {
		return valor;
	}

	public Date getData() {
		return data;

	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setNumero(int numero) throws IllegalArgumentException {
		if (numero <= 0) {
			throw new IllegalArgumentException("O número deve ser maior do que 0");
		}

		this.numero = numero;
	}

	public void setDescricao(String descricao) {
		if (descricao == null || descricao.isBlank()) {
			throw new IllegalArgumentException("A descrição deve ser informada");
		}
		if (descricao.length() < 3) {
			throw new IllegalArgumentException("A descrição deve ter pelo menos 3 caracteres");
		}

		this.descricao = descricao;
	}

	public void setValor(float valor) throws IllegalArgumentException {
		if (valor <= 0) {
			throw new IllegalArgumentException("O valor deve ser maior do que 0");
		}

		this.valor = valor;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public void setVeiculo(Veiculo veiculo) throws IllegalArgumentException {
		if (veiculo == null) {
			throw new IllegalArgumentException("O veveículo deve ser informado");
		}

		this.veiculo = veiculo;
	}
	
	public String imprimirDados() {
		return getNumero() + " - " + getDescricao() + " - " + getValor() + " - " + getData() + " - Placa: " + veiculo.getPlaca();
	}
}