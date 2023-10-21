import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {

	public static void main(String[] args) {
		//iniciando o banco
		Banco santander = new Banco("Santander");
		System.out.println("Bem-vindo ao Banco " + santander.getNome());
		System.out.println("");

		//criando cliente
		Cliente daniel = new Cliente();
		daniel.setNome("Daniel");

		//validar CPF
		Pattern pattern = Pattern.compile("[0-9]{11}");
		Matcher matcher = pattern.matcher("70266102440");

		if (matcher.matches()) {
			daniel.setCpf("70266102441");

			Conta cc = new ContaCorrente(daniel);
			Conta poupanca = new ContaPoupanca(daniel);

			santander.addConta(cc);
			santander.addConta(poupanca);

			santander.imprimirDetalhesTodasContas();

			System.out.println("Valores iniciais:");
			cc.extrato();
			poupanca.extrato();
			
			if(cc.depositar(100) == true) {;
				System.out.println("Valores após despósito:");
				cc.extrato();
				poupanca.extrato();
			}

			poupanca.desabilitarConta();
			
			if(cc.transferir(100, poupanca) == true) {
				System.out.println("Valores após transferência:");
				cc.extrato();
				poupanca.extrato();
			}

			poupanca.habilitarConta();
			
			if(cc.transferir(100, poupanca) == true) {
				System.out.println("Valores após transferência:");
				cc.extrato();
				poupanca.extrato();
			}
		}
		
	}
}