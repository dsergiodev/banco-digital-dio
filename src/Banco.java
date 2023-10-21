import java.util.ArrayList;
import java.util.List;

public class Banco {
	private String nome;
	private String telefone = "";
	private String endereco = "";
	private List<Conta> contas = new ArrayList<>();

	public Banco(String nome){
		this.nome = nome;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return this.telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return this.endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public List<Conta> getContas() {
		return this.contas;
	}

	public void setContas(List<Conta> contas) {
		this.contas = contas;
	}

	public void addConta(Conta conta) {
		this.contas.add(conta);
	}

	public void imprimirDetalhesTodasContas() {
		System.out.println("CONTAS CADASTRADAS:");

		int cont = 0;
		for (Conta conta : contas) {
			cont++;
			System.out.println("-- CONTA " + cont + " --");
			System.out.println("Agência: " + conta.getAgencia());
			System.out.println("Numero: " + conta.getNumero());
			System.out.println("Saldo: " + conta.getSaldo());
			System.out.println("Conta ativa: " + (conta.getStatus() == 1 ? "Sim" : "Não") );
			System.out.println("Cliente: " + conta.getCliente().getNome());
			System.out.println("");
		}
	  }

}