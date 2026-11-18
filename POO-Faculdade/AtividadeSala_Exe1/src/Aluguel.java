import java.util.Date;

public class Aluguel {
	private Cliente cliente;
	private String endereco;
	private Tema tema;
	private Date data;
	private int horaInicio;
	private int horaFim;

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		if (endereco != null && !endereco.isEmpty() && endereco.length() >= 3) {
			this.endereco = endereco;
		}
	}

	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}

	public int getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(int horaInicio) {
		if (horaInicio >= 0 && horaInicio <= 23) {
			this.horaInicio = horaInicio;
		} else {
			System.out.println("A hora de inicio deve ser preenchida");
		}
	}

	public int getHoraFim() {
		return horaFim;
	}

	public void setHoraFim(int horaFim) {
		if (horaFim >= 0 && horaFim <= 23) {
			this.horaFim = horaFim;
		} else {
			System.out.println("A hora de inicio deve ser preenchida");
		}
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		if (data != null) {
			this.data = data;
		} else {
			System.out.println("Preencha a data corretamente");
		}
	}
}

