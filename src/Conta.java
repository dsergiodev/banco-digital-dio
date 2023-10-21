public abstract class Conta implements IConta {
	
	private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;

	protected int agencia;
	protected int numero;
	protected double saldo;
	protected int contaAtiva = 1;
	protected Cliente cliente;

	public Conta(Cliente cliente) {
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
	}

	@Override
	public boolean sacar(double valor) {
		if(this.saldo >= valor){
			if(this.contaAtiva == 1){
				this.saldo -= valor;
				return true;
			} else {
				return false;
			}
		} else {
			System.out.println("Saldo insuficiente!");
			return false;
		}
		
	}

	@Override
	public boolean depositar(double valor) {
		if(valor > 0){
			if(this.contaAtiva == 1){
				this.saldo += valor;
				return true;
			} else {
				System.out.println("Conta inativa!");
				return false;
			}
		} else {
			System.out.println("Valor inválido!");
			return false;
		}
			
	}

	@Override
	public boolean transferir(double valor, IConta contaDestino) {
		if(valor <= this.saldo) {
			if(contaDestino.getStatus() == 1) {
				this.sacar(valor);
				contaDestino.depositar(valor);

				return true;
			} else {
				System.out.println("Conta inativa! Entre em contato para mais detalhes.");
				return false;
			}

		} else {
			System.out.println("Saldo insuficiente!");
			return false;
		}
		
	}

	public int getAgencia() {
		return this.agencia;
	}

	public int getNumero() {
		return this.numero;
	}

	public double getSaldo() {
		return this.saldo;
	}

	@Override
	public int getStatus(){
		return this.contaAtiva;
	}

	public Cliente getCliente(){
		return this.cliente;
	}

	public void habilitarConta(){
		this.contaAtiva = 1;
	}

	public void desabilitarConta(){
		this.contaAtiva = 0;
	}

	protected void imprimirInfosComuns() {
		System.out.println(String.format("Titular: %s", this.cliente.getNome()));
		System.out.println(String.format("Agência: %d", this.agencia));
		System.out.println(String.format("Número: %d", this.numero));
		System.out.println(String.format("Saldo: %.2f", this.saldo));
		System.out.println("Status da conta: " + (this.contaAtiva == 1 ? "Ativa" : "Inativa"));
        System.out.println("");
	}
}