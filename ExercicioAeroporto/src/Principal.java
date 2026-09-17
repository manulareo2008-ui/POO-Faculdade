import javax.swing.JOptionPane;

public class Principal {

	public Principal() {

		try {
			Aeronave a1 = new Aeronave(1, "Boeing 737", 100);
			Aeronave a2 = new Aeronave(2, "Airbus A320", 200);
			Aeronave a3 = new Aeronave(3, "Embraer 195", 300);

			Voo v1 = new Voo(a1, 4, "Miami", 100, "15:30");
			Voo v2 = new Voo(a2, 5, "Rio", 190, "19:00");
			Voo v3 = new Voo(a3, 6, "Espanha", 300, "23:00");
			Voo v4 = new Voo(a1, 7, "Lisboa", 80, "06:00");   

			Aeroporto aeroporto1 = new Aeroporto(7, "Niuberi", "Buenos Aires");
			
			aeroporto1.addVoo(v1);
			aeroporto1.addVoo(v2);
			aeroporto1.addVoo(v3);
			aeroporto1.addVoo(v4);
			
			JOptionPane.showMessageDialog(null, "Voos listados no momento: \n" + aeroporto1.listarVoos() + "\n");
			
			Voo achar = aeroporto1.buscarVooPeloNumero(4);
			JOptionPane.showMessageDialog(null, "Rusultado da busca peo voo número 4: " + achar.imprimirDados() + "\n");
			
			aeroporto1.removerVoo(7);
			JOptionPane.showMessageDialog(null, "Resltado após tentar eliminar o voo número 7: \n" + aeroporto1.listarVoos());


		} catch (IllegalArgumentException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

	public static void main(String[] args) {
		new Principal();
	}
}

