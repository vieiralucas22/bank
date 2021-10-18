package Classes;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import java.lang.String;
public class Controlador {
	private static ArrayList<CadastraCliente> dados_cliente =  new ArrayList<>();
	private static ArrayList<CadastraGerente> dados_gerente =  new ArrayList<>();
	private static ArrayList<Poupanca> dados_poupanca =  new ArrayList<>();
	private static ArrayList<Simples> dados_simples =  new ArrayList<>();
	private static ArrayList<Especial> dados_especial =  new ArrayList<>();
	private static ArrayList<Acoes> dados_extrato =  new ArrayList<>();
	
	
	public static String usando;
	public float soma;
	public float retira;
	//variavel para saber qual o nome do usuario que esta usando o banco
	public String getUsando() {
		return usando;
	}

	public void setUsando(String usando) {
		this.usando = usando;
	}
	//retorna dados
	
	
	
	//função para verificar o login 
	public boolean verificaLoginCliente(String nome, String senha) {
		for(CadastraCliente i : dados_cliente)
		{			
			if(nome.equals(i.getLogin())&&senha.equals(i.getSenha())) {
				return true;
			}
		}
		return false;
	}
	
	public static ArrayList<Poupanca> retornarDadosPoupanca() {
		return dados_poupanca;
	}
	
	public static ArrayList<Simples> retornarDadosSimples() {
		return dados_simples;
	}
	public static ArrayList<Especial> retornarDadosEspecial() {
		return dados_especial;
	}

	public boolean verificaLoginGerente(String nome, String senha) {
		for(CadastraGerente i : dados_gerente)
		{			
			if(nome.equals(i.getLogin())&&senha.equals(i.getSenha())) {
				return true;
			}
		}
		return false;
	}

	//função para adicionar usuario 
	public void adicionarCliente(CadastraCliente cc)
	{
		dados_cliente.add(cc);
	}
	public void adicionarGerente(CadastraGerente cg)
	{
		dados_gerente.add(cg);
	}
	public void adicionarNumeroContaPoupanca(Poupanca p)
	{
		dados_poupanca.add(p);
	}
	public void adicionarNumeroContaSimples(Simples s)
	{
		dados_simples.add(s);
	}
	public void adicionarNumeroContaEspecial(Especial e)
	{
		dados_especial.add(e);
	}
	//função para verificar se o usuario ja foi cadastrado
	public boolean existeCliente(String nome)
	{
		for(CadastraCliente i : dados_cliente)
		{			
			if(nome.equals(i.getLogin())) {
				return false;
			}
		}
		return true;
	}
	
	public boolean existeGerente(String nome)
	{
		for(CadastraGerente i : dados_gerente)
		{			
			if(nome.equals(i.getLogin())) {
				return false;
			}
		}
		return true;
	}
	
	//função para alterar a senha do usuario
	public boolean alterarSenhaCliente(String senha_antiga, String senha_nova)
	{
		for(CadastraCliente i : dados_cliente)
		{
			if(getUsando().equals(i.getLogin()))
			{
				if(senha_antiga.equals(i.getSenha()))
				{
					if(senha_antiga.equals(senha_nova)) {
						return false;
					}
					else {
					i.setSenha(senha_nova);
					return true;
					}
				}
			}
		}
		return false;
	}
	

	public boolean alterarSenhaGerente(String senha_antiga, String senha_nova)
	{
		for(CadastraGerente i : dados_gerente)
		{
			if(getUsando().equals(i.getLogin()))
			{
				if(senha_antiga.equals(i.getSenha()))
				{
					if(senha_antiga.equals(senha_nova)) {
						return false;
					}
					else {
					i.setSenha(senha_nova);
					return true;
					}
				}
			}
		}
		return false;
	}
	
	//verifica se é apenas inteiros
	public boolean verificaCaracter(String numero)
	{
		if(numero.matches("[0-9]+"))
		{
			return true;
		}
		return false;
	}
	//verifica se a string é um float ou int
	public boolean verificaCaracterFloat(String numero)
	{
		if(numero.matches("[0-9]||[,]+"))
		{
			return true;
		}
		return false;
	}
	
	public boolean isInteger( String input ) {
		try{
	        Float.parseFloat(input);
	        return true;
	    }catch(NumberFormatException e){
	        
	    }
		return false;
	}
	//verifica o numero da conta ja existe
	public boolean existeNumeroContas(int numero)
	{
		for(Poupanca i : dados_poupanca)
		{			
			if(numero==i.getNumero_conta()) {
				return true;
			}
		}
		for(Simples i : dados_simples)
		{			
			if(numero==i.getNumero_conta()) {
				return true;
			}
		}
		for(Especial i : dados_especial)
		{			
			if(numero==i.getNumero_conta()) {
				return true;
			}
		}
		return false;
	}
	
	
	//verificar qual o gerente da conta que esta sendo usada
	public String gerente_usado()
	{
		for(CadastraCliente i : dados_cliente)
		{			
			if(getUsando().equals(i.getLogin())) {
				return i.getNome_gerente();
			}
		}
		return getUsando();
	}
	
	//aplicar dinheiro 
	public boolean aplicarDinheiro(int numero, float dinheiro, int flag)
	{
		soma=0;
		switch(flag)
		{
		case 1: for(Poupanca i : dados_poupanca)
				{
					if(getUsando().equals(i.getLogin())) {
						if(numero==i.getNumero_conta()) {
								soma=dinheiro+i.getSaldo();
								i.setSaldo(soma);
								return true;
							}
						}
				}
				return false;
		 
		case 2:	for(Simples i : dados_simples)
				{			
					if(getUsando().equals(i.getLogin())) {
						if(numero==i.getNumero_conta()) {
								soma=dinheiro+i.getSaldo();
								i.setSaldo(soma);
								return true;
							}
						}
				}
				return false;
		case 3: for(Especial i : dados_especial)
				{			
					if(getUsando().equals(i.getLogin())) {
						if(numero==i.getNumero_conta()) {
								soma=dinheiro+i.getSaldo();
								i.setSaldo(soma);
								return true;
							}
						}
				}
				return false;
		}
		return false;
	}
	
	public boolean aplicarDinheiroGerente(int numero, float dinheiro)
	{
		soma=0;
			for(Poupanca i : dados_poupanca)
			{
				if(getUsando().equals(i.getNome_gerente())) {
					if(numero==i.getNumero_conta()) {
							soma=dinheiro+i.getSaldo();
							i.setSaldo(soma);
							return true;
						}
					}
			}
		
	
			for(Simples i : dados_simples)
			{			
				if(getUsando().equals(i.getNome_gerente())) {
					if(numero==i.getNumero_conta()) {
							soma=dinheiro+i.getSaldo();
							i.setSaldo(soma);
							return true;
						}
					}
			}

			 for(Especial i : dados_especial)
				{			
					if(getUsando().equals(i.getNome_gerente())) {
						if(numero==i.getNumero_conta()) {
								soma=dinheiro+i.getSaldo();
								i.setSaldo(soma);
								return true;
							}
						}
				}
	

		return false;
	}
	
	//retorna a flag 
	public int retornaFlag(int numero)
	{
		for(Poupanca i : dados_poupanca)
		{			
			if(numero==i.getNumero_conta())
				return 1;
		}
		for(Simples i : dados_simples)
		{			
			if(numero==i.getNumero_conta())
				return 2;
		}
		for(Especial i : dados_especial)
		{			
			if(numero==i.getNumero_conta())
				return 3;
		}
		return 4;
	}
	
	//remove dinheiro

	
	
	public int retirarSaldo(int numero, float dinheiro, int flag)
	{
		retira =0;
		switch(flag)
		{
		case 1: for(Poupanca i : dados_poupanca)
				{
					if(getUsando().equals(i.getLogin())) {
							if(numero==i.getNumero_conta()) {
								retira=i.getSaldo();
								retira=retira-dinheiro;
								if(retira>=0)
								{
									i.setSaldo(retira);
									return 1;
								}
								else 
									return 2;
							}
						}
					}
				return 3;
				
		case 2:	for(Simples i : dados_simples)
				{			
					if(getUsando().equals(i.getLogin())) {
						if(numero==i.getNumero_conta()) {
							retira=i.getSaldo();
							retira=retira-dinheiro;
							if(retira>0)
							{
								i.setSaldo(retira);
								return 1;
							}
							else 
								return 2;
						}
					}
				}
				return 3;
		case 3: for(Especial i : dados_especial)
				{			
					if(getUsando().equals(i.getLogin())) {
						if(numero==i.getNumero_conta()) {
							retira=i.getSaldo() ;
							retira=retira-dinheiro;
							if(retira+ i.getLimite()>=0)
							{
								i.setSaldo(retira);
								return 1;
							}
							else 
								return 2;
						}
					}
				}
				
				return 3;
		
		}
		return 4;
	}
	
	public int retirarSaldoGerente(int numero, float dinheiro)
	{
		retira =0;
		
		
				for(Poupanca i : dados_poupanca)
				{
					if(getUsando().equals(i.getNome_gerente())) {
							if(numero==i.getNumero_conta()) {
								retira=i.getSaldo();
								retira=retira-dinheiro;
								if(retira>=0)
								{
									i.setSaldo(retira);
									return 1;
								}
								else 
									return 2;
							}
						}
					}
				
				
				for(Simples i : dados_simples)
				{			
					if(getUsando().equals(i.getNome_gerente())) {
						if(numero==i.getNumero_conta()) {
							retira=i.getSaldo();
							retira=retira-dinheiro;
							if(retira>0)
							{
								i.setSaldo(retira);
								return 1;
							}
							else 
								return 2;
						}
					}
				}
				
				for(Especial i : dados_especial)
				{			
					if(getUsando().equals(i.getNome_gerente())) {
						if(numero==i.getNumero_conta()) {
							retira=i.getSaldo();
							retira=retira-dinheiro;
							if(retira+ i.getLimite()>=0)
							{
								i.setSaldo(retira);
								return 1;
							}
							else 
								return 2;
						}
					}
				}
				
				return 3;
		
	}
	//verificar saldo 
	public boolean verificarSaldo(int numero)
	{
		int r = retornaFlag(numero);
		switch(r)
		{
		case 1: for(Poupanca i : dados_poupanca)
				{
					if(getUsando().equals(i.getLogin())) {
							if(numero==i.getNumero_conta()) {
								JOptionPane.showMessageDialog(null,i.getLogin()+" seu saldo é de: R$"+i.getSaldo());
								return true;
							}
					}
				}
				return false;
				
		case 2: for(Simples i : dados_simples)
				{
					if(getUsando().equals(i.getLogin())) {
						for(Simples k : dados_simples) {
							if(numero==k.getNumero_conta()) {
								JOptionPane.showMessageDialog(null,k.getLogin()+" seu saldo é de: R$"+k.getSaldo());
								return true;
							}
						}
						return false;
					}
				}
				break;
		case 3: for(Especial i : dados_especial)
				{
			if(getUsando().equals(i.getLogin())) {
					for(Especial k : dados_especial) {
						if(numero==k.getNumero_conta()) {
							JOptionPane.showMessageDialog(null,k.getLogin()+" seu saldo é de: R$"+k.getSaldo());
							return true;
						}
					}
					return false;
				}
			}
				break;
		}
		return false;
	}
	public void imprime()
	{
		for(CadastraCliente i : dados_cliente)
		{
			System.out.println("Login: "+i.getLogin());
			System.out.println("Senha: "+i.getSenha());
		}
	}
	public void imprimeg()
	{
		for(CadastraGerente i : dados_gerente)
		{
			System.out.println("Login: "+i.getLogin());
			System.out.println("Senha: "+i.getSenha());
		}
	}
	//transferencia 

	public boolean transferencia(int envia, int recebe, float valor)
	{
		retira=0;
		soma=0;
		for(Poupanca i : dados_poupanca)
		{
			if(envia==i.getNumero_conta())
			{
				retira=i.getSaldo();
				retira=retira-valor;
				if(retira>=0)
					i.setSaldo(retira);
				else {
					JOptionPane.showMessageDialog(null,"Seu saldo não pode ficar negativo!");
					return false;
				}
			}
			if(recebe==i.getNumero_conta())
			{
				soma=i.getSaldo();
				soma=soma+valor;
				i.setSaldo(soma);
			}
		}
		for(Simples i : dados_simples)
		{
			if(envia==i.getNumero_conta())
			{
				retira=i.getSaldo();
				retira=retira-valor;
				if(retira>=0)
					i.setSaldo(retira);
				else {
					JOptionPane.showMessageDialog(null,"Seu saldo não pode ficar negativo!");
					return false;
				}
			}
			if(recebe==i.getNumero_conta())
			{
				soma=i.getSaldo();
				soma=soma+valor;
				i.setSaldo(soma);
			}
		}
		for(Especial i : dados_especial)
		{
			if(envia==i.getNumero_conta())
			{
				retira=i.getSaldo();
				retira=retira-valor;
				i.setSaldo(retira);
				
			}
			if(recebe==i.getNumero_conta())
			{
				soma=i.getSaldo();
				soma=soma+valor;
				i.setSaldo(soma);
			}
		}
		return true;
	}


public boolean cadastraEditaLimite(int numeroConta, float limite)
{
	

	for(Especial i : dados_especial)
	{
		if(numeroConta==i.getNumero_conta())
		{
			i.setLimite(limite);
			return true;
		}
		
	}
return false;

}

public void adicionarExtrato(Acoes a)
{
	dados_extrato.add(a);
}
public static ArrayList<Acoes> retornarDadosExtrato() {
	return dados_extrato;


}
}
