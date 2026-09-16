import javax.swing.JOptionPane;

public class Clinica {

	public Clinica() {
		Veterinario v1 = new Veterinario("Miguel");

		try {
			Dono d1 = new Dono("Manuel", "47996558432");
			Dono d2 = new Dono("José", "99999999999");

			Animal a1 = new Animal("Pepito", "Cachorro", d1);
			a1.setPesos(new float[] { 10, 12, 14 });
			Animal a2 = new Animal("Cacau", "Pássaro", d1);
			a2.setPesos(new float[] { 0.3f, 0.4f, 0.5f });
			Animal a3 = new Animal("Miau", "Gato", d2);
			a3.setPesos(new float[] { 4, 5, 6 });
			Animal a4 = new Animal("Lolo", "Porco", d2);
			a4.setPesos(new float[] { 80, 90, 100 });
			Animal a5 = new Animal("Mimimi", "Gato", d2);
			a5.setPesos(new float[] { 2, 3, 4 });

			v1.addAnimal(a1);
			v1.addAnimal(a2);
			v1.addAnimal(a3);
			v1.addAnimal(a4);
			v1.addAnimal(a5);
		} catch (IllegalArgumentException e) {
			JOptionPane.showMessageDialog(null, "Erro no cadastro: " + e.getMessage());
		}

		try {
			String r = "ANIMAIS:\n" + v1.listarAnimais();

			float media = v1.mediaGeralPeso();
			if (media == -1) {
				r += "\nMédia geral: nenhum animal cadastrado";
			} else {
				r += "\nMédia geral: " + media;
			}

			Animal maior = v1.maiorPesoMedio();
			if (maior != null) {
				r += "\nMaior média: " + maior.getNome() + " (" + maior.calcularMediaPeso() + ")";
			}

			r += "\nAcima de 10kg: " + v1.qntAnimaisAcimaPesoInformado(10);
			r += "\nQtd. do José: " + v1.qntAnimaisDoDono("José");
			r += "\nContato do dono da Cacau: " + v1.dadosContatoDonoDoAnimal("Cacau");

			JOptionPane.showMessageDialog(null, r);
		} catch (IllegalArgumentException e) {
			JOptionPane.showMessageDialog(null, "Erro no relatório: " + e.getMessage());
		}
	}

	public static void main(String[] args) {
		new Clinica();
	}
}