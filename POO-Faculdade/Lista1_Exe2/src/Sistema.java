
public class Sistema {
	public static void main (String[] args) {
		Endereco end = new Endereco();
		end.setRua("Rua Rudolfo Schippmann");
		end.setNumero(211);
		end.setUf(UF.SC);
		
		Responsavel res = new Responsavel();
		res.setNome("Manuel Lareo");
		res.setEndereco(end);
		
		Especie esp = new Especie();
		esp.setNome("Paumo Lengo");
		
		Raca rac = new Raca();
		rac.setNome("Manularus Piernensis");
		
		Animal ani = new Animal();
		ani.setNome("Rex");
		ani.setIdade(10);
		ani.setEspecie(esp);
		ani.setRaca(rac);
		ani.setResponsavel(res);
		
		Veterinario vet = new Veterinario();
		vet.setNome("Mario");
		vet.setNrRegistro("555");
		
		Consulta cons = new Consulta();
		cons.setData("12-10-2026");
		cons.setVeterinario(vet);
		cons.setMotivo("Vacinação");
		cons.setDiagnostico("Leve");
		cons.setAnimal(ani);
		cons.setResponsavel(res);
		
		System.out.println("Animal: " + cons.getAnimal().getNome());
		System.out.println("Dono: " + cons.getAnimal().getResponsavel().getNome());
		System.out.println("Rua do dono: " + cons.getAnimal().getResponsavel().getEndereco().getRua());
		System.out.println("Estado: " + cons.getAnimal().getResponsavel().getEndereco().getUf());
		System.out.println("Especie: " + cons.getAnimal().getEspecie().getNome());
	}
}
