package empresa.modelo;
import empresa.excecao.MenorIgual0Exception;

public class FuncionarioHorista extends Funcionario {
	private int horasTrabalhadas;
	private double valorHora;

	public FuncionarioHorista(String nome, String matricula, int horasTrabalhadas, double valorHora) {
		super(nome, matricula);
		setHorasTrabalhadas(horasTrabalhadas);
		setValorHora(valorHora);
	}

	public int getHorasTrabalhadas() {
		return horasTrabalhadas;
	}

	public double getValorHora() {
		return valorHora;
	}

	public void setHorasTrabalhadas(int horasTrabalhadas) throws MenorIgual0Exception {
		if (horasTrabalhadas <= 0) {
			throw new MenorIgual0Exception("Horas trabalhadas");
		}
		this.horasTrabalhadas = horasTrabalhadas;
	}

	public void setValorHora(double valorHora) throws MenorIgual0Exception {
		if (valorHora <= 0) {
			throw new MenorIgual0Exception("Valor por hora");
		}
		this.valorHora = valorHora;
	}

	@Override
	public double calcularSalario() {
		return getHorasTrabalhadas() * getValorHora();
	}
}
