import java.util.Date;

public class Aluguel {

	private Date data;
	private int horaInicio;
	private int horaFim;
	private Cliente cliente;
	private Tema tema;
	private String endereco;

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		if (data != null) {
			this.data = data;
		} else {
			System.out.println("Data deve ser preenchido");
		}
	}

	public int getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(int horaInicio) {
		if (horaInicio >= 0 && horaInicio <= 23) {
			this.horaInicio = horaInicio;
		} else {
			System.out.println("Hora deve ser entre 0 e 23");
		}
	}

	public int getHoraFim() {
		return horaFim;
	}

	public void setHoraFim(int horaFim) {
		if (horaFim >= 0 && horaFim <= 23) {
			this.horaFim = horaFim;
		} else {
			System.out.println("Hora deve ser entre 0 e 23");
		}
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		if (cliente != null) {
			this.cliente = cliente;
		} else {
			System.out.println("Cliente deve ser informado");
		}
	}

	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		if (tema != null) {
			this.tema = tema;
		} else {
			System.out.println("Tema deve ser informado");
		}
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		if (endereco != null && !endereco.isEmpty() && endereco.length() >= 3) {
			this.endereco = endereco;
		} else {
			System.out.println("Endereço deve ser preenchido");
		}
	}

}
