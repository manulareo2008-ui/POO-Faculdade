package empresa.testes; // pacote onde fica a classe de testes

import static org.junit.jupiter.api.Assertions.*; // traz assertEquals, assertTrue, assertFalse, assertThrows...

import org.junit.jupiter.api.Test; // anotação que marca cada método como um teste

import empresa.excecao.CampoVazioException; // exceção lançada quando um campo obrigatório vem vazio ou nulo
import empresa.excecao.MenorIgual0Exception; // exceção lançada quando um número deveria ser maior que 0
import empresa.modelo.Empresa; // classe que guarda e gerencia os funcionários
import empresa.modelo.Programador; // funcionário que pode ganhar bônus por saber Java
import empresa.modelo.Venda; // uma venda feita por um vendedor
import empresa.modelo.Vendedor; // funcionário que ganha comissão sobre as vendas

// Ordem usada em todos os asserts: assertEquals(ESPERADO, REAL).
// Assim, se um teste falhar, a mensagem mostra cada valor no lugar certo.
class Teste {

	// ===================== VENDA =====================

	@Test // marca o método como teste: sem isto, o JUnit ignora o método
	void testarVenda() {
		Venda venda = new Venda(100); // cria uma venda válida de R$ 100

		assertEquals(100, venda.getValor(), 0.01); // confere se o valor foi realmente guardado (pega setter que não atribui)

		assertThrows(MenorIgual0Exception.class, () -> new Venda(0)); // valor 0 deve ser recusado
		assertThrows(MenorIgual0Exception.class, () -> new Venda(-50)); // valor negativo deve ser recusado
	}

	// ===================== VENDEDOR =====================

	@Test
	void testarVendedorSemVendas() {
		Vendedor luiz = new Vendedor("Luiz", 1000, 10); // vendedor com salário base 1000 e 10% de comissão

		assertEquals("Luiz", luiz.getNome()); // o nome foi guardado
		assertEquals(1000, luiz.getSalarioBase(), 0.01); // o salário base foi guardado
		assertEquals(10, luiz.getPercentualComissao(), 0.01); // o percentual foi guardado
		assertEquals(0, luiz.getVendas().size()); // a lista de vendas começa vazia
		assertEquals(1000, luiz.calcularSalario(), 0.01); // sem vendas, recebe só o salário base
	}

	@Test
	void testarVendedorComVendas() {
		Vendedor luiz = new Vendedor("Luiz", 1000, 10); // vendedor do enunciado
		luiz.incluirVenda(new Venda(200)); // primeira venda do enunciado
		luiz.incluirVenda(new Venda(100)); // segunda venda do enunciado

		assertEquals(2, luiz.getVendas().size()); // as duas vendas entraram na lista
		assertEquals(1030, luiz.calcularSalario(), 0.01); // 1000 + 10% de (200 + 100) = 1030
		assertEquals(1030, luiz.calcularSalario(), 0.01); // chamar de novo dá o mesmo valor: o cálculo não altera nada

		Vendedor paula = new Vendedor("Paula", 1200, 7); // segunda vendedora do enunciado
		paula.incluirVenda(new Venda(500)); // vendas de 500,
		paula.incluirVenda(new Venda(350)); // 350
		paula.incluirVenda(new Venda(280)); // e 280 (total 1130)

		assertEquals(1279.1, paula.calcularSalario(), 0.01); // 1200 + 7% de 1130 = 1279,10 (delta por causa da porcentagem)
	}

	@Test
	void testarRegrasDeVenda() {
		Vendedor luiz = new Vendedor("Luiz", 1000, 10); // vendedor para testar as regras
		Venda venda = new Venda(100); // uma venda de 100

		luiz.incluirVenda(venda); // inclui a venda pela primeira vez
		assertThrows(IllegalArgumentException.class, () -> luiz.incluirVenda(venda)); // o MESMO objeto de novo é recusado

		luiz.incluirVenda(new Venda(100)); // outra venda, com o mesmo valor, é uma venda diferente
		assertEquals(2, luiz.getVendas().size()); // então ela é aceita: agora são 2 vendas

		assertThrows(CampoVazioException.class, () -> luiz.incluirVenda(null)); // venda nula é recusada
	}

	@Test
	void testarValidacoesVendedor() {
		assertThrows(MenorIgual0Exception.class, () -> new Vendedor("Luiz", 1000, 0)); // comissão 0 é recusada
		assertThrows(MenorIgual0Exception.class, () -> new Vendedor("Luiz", 1000, -5)); // comissão negativa é recusada
	}

	// ===================== PROGRAMADOR =====================

	@Test
	void testarProgramadorSemJava() {
		Programador anderson = new Programador("Anderson", 1200); // programador do enunciado
		anderson.incluirLinguagem("Python"); // conhece só Python

		assertEquals(1, anderson.getLinguagens().size()); // a linguagem entrou na lista
		assertEquals(1200, anderson.calcularSalario(), 0.01); // sem Java, recebe só o salário base
	}

	@Test
	void testarProgramadorComJava() {
		Programador julio = new Programador("Julio", 1000); // programador do enunciado
		julio.incluirLinguagem("C"); // conhece C
		julio.incluirLinguagem("Java"); // e Java

		assertEquals(2, julio.getLinguagens().size()); // as duas linguagens estão na lista
		assertEquals(1200, julio.calcularSalario(), 0.01); // com Java: 1000 + 20% = 1200
		assertEquals(1200, julio.calcularSalario(), 0.01); // de novo: o bônus não é aplicado duas vezes
		assertEquals(1000, julio.getSalarioBase(), 0.01); // o salário base continua intacto

		Programador ana = new Programador("Ana", 1000); // outra programadora
		ana.incluirLinguagem("java"); // "java" em minúsculas
		assertEquals(1200, ana.calcularSalario(), 0.01); // também conta como Java (equalsIgnoreCase)
	}

	@Test
	void testarRemoverLinguagem() {
		Programador julio = new Programador("Julio", 1000); // programador para testar a remoção
		julio.incluirLinguagem("C"); // conhece C
		julio.incluirLinguagem("Java"); // e Java

		julio.removerLinguagem("Java"); // remove Java
		assertEquals(1, julio.getLinguagens().size()); // sobrou só C
		assertEquals(1000, julio.calcularSalario(), 0.01); // sem Java, o bônus some

		assertThrows(IllegalArgumentException.class, () -> julio.removerLinguagem("Cobol")); // remover algo que não existe é recusado
	}

	@Test
	void testarValidacoesProgramador() {
		Programador julio = new Programador("Julio", 1000); // programador para testar as validações
		julio.incluirLinguagem("Java"); // inclui Java uma vez

		assertThrows(IllegalArgumentException.class, () -> julio.incluirLinguagem("Java")); // a mesma linguagem de novo é recusada
		assertThrows(CampoVazioException.class, () -> julio.incluirLinguagem("")); // texto vazio é recusado
		assertThrows(CampoVazioException.class, () -> julio.incluirLinguagem("   ")); // só espaços também (isBlank)
		assertThrows(CampoVazioException.class, () -> julio.incluirLinguagem(null)); // nulo é recusado
	}

	// ===================== FUNCIONÁRIO (testado pelas filhas, pois é abstrato) =====================

	@Test
	void testarValidacoesFuncionario() {
		assertThrows(CampoVazioException.class, () -> new Programador("", 1000)); // nome vazio é recusado (validação do pai)
		assertThrows(CampoVazioException.class, () -> new Programador("   ", 1000)); // nome só com espaços é recusado
		assertThrows(CampoVazioException.class, () -> new Vendedor(null, 1000, 10)); // nome nulo é recusado
		assertThrows(MenorIgual0Exception.class, () -> new Programador("Julio", 0)); // salário base 0 é recusado
		assertThrows(MenorIgual0Exception.class, () -> new Vendedor("Luiz", -100, 10)); // salário base negativo é recusado
	}

	// ===================== EMPRESA =====================

	@Test
	void testarEmpresaCenarioDoEnunciado() {
		Empresa empresa = new Empresa("Empresa X"); // cria a empresa

		Vendedor luiz = new Vendedor("Luiz", 1000, 10); // Luiz: 1000 + 10% de 300 = 1030
		luiz.incluirVenda(new Venda(200)); // venda de 200
		luiz.incluirVenda(new Venda(100)); // venda de 100

		Vendedor paula = new Vendedor("Paula", 1200, 7); // Paula: 1200 + 7% de 1130 = 1279,10
		paula.incluirVenda(new Venda(500)); // venda de 500
		paula.incluirVenda(new Venda(350)); // venda de 350
		paula.incluirVenda(new Venda(280)); // venda de 280

		Programador julio = new Programador("Julio", 1000); // Julio: conhece Java → 1200
		julio.incluirLinguagem("C"); // C
		julio.incluirLinguagem("Java"); // Java

		Programador ana = new Programador("Ana", 1000); // Ana: conhece Java → 1200
		ana.incluirLinguagem("Java"); // Java
		ana.incluirLinguagem("C#"); // C#

		Programador anderson = new Programador("Anderson", 1200); // Anderson: sem Java → 1200
		anderson.incluirLinguagem("Python"); // Python

		empresa.incluirFuncionario(luiz); // inclui os cinco funcionários na empresa
		empresa.incluirFuncionario(paula);
		empresa.incluirFuncionario(julio);
		empresa.incluirFuncionario(ana);
		empresa.incluirFuncionario(anderson);

		assertEquals("Empresa X", empresa.getNome()); // o nome da empresa foi guardado
		assertEquals(5, empresa.getFuncionarios().size()); // os cinco estão na lista
		assertEquals(5909.1, empresa.calcularCustosSalarios(), 0.01); // 1030 + 1279,10 + 1200 + 1200 + 1200 = 5909,10
		assertEquals(5909.1, empresa.calcularCustosSalarios(), 0.01); // calcular de novo não muda nada
	}

	@Test
	void testarRemoverFuncionario() {
		Empresa empresa = new Empresa("Empresa X"); // empresa para testar a remoção
		Programador julio = new Programador("Julio", 1000); // 1000 (sem linguagens)
		Programador anderson = new Programador("Anderson", 1200); // 1200 (sem linguagens)
		empresa.incluirFuncionario(julio); // inclui Julio
		empresa.incluirFuncionario(anderson); // inclui Anderson

		empresa.removerFuncionario(anderson); // remove o Anderson
		assertEquals(1, empresa.getFuncionarios().size()); // sobrou só o Julio
		assertEquals(1000, empresa.calcularCustosSalarios(), 0.01); // o custo foi recalculado sem o Anderson

		assertThrows(IllegalArgumentException.class, () -> empresa.removerFuncionario(anderson)); // remover de novo é recusado
		assertThrows(CampoVazioException.class, () -> empresa.removerFuncionario(null)); // remover nulo é recusado
	}

	@Test
	void testarRegrasEmpresa() {
		Empresa empresa = new Empresa("Empresa X"); // empresa para testar as regras
		Programador julio = new Programador("Julio", 1000); // um funcionário
		empresa.incluirFuncionario(julio); // inclui uma vez

		assertThrows(IllegalArgumentException.class, () -> empresa.incluirFuncionario(julio)); // o mesmo funcionário de novo é recusado
		assertThrows(CampoVazioException.class, () -> empresa.incluirFuncionario(null)); // funcionário nulo é recusado
		assertThrows(CampoVazioException.class, () -> new Empresa("")); // empresa sem nome é recusada

		Empresa vazia = new Empresa("Empresa Y"); // empresa sem nenhum funcionário
		assertEquals(0, vazia.calcularCustosSalarios(), 0.01); // custo de uma empresa vazia é zero
	}
}