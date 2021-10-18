package Classes;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import view.Usuario;

public class Menu {
	
	public static void main(String[] args) {
		
		Controlador c = new Controlador();
		CadastraGerente cg = new CadastraGerente();
		CadastraCliente cc = new CadastraCliente();
		Poupanca p = new Poupanca();
		
		cg.setLogin("xastre");
		cg.setSenha("123");
		c.adicionarGerente(cg);
		
		cc.setLogin("julia");
		cc.setSenha("1");
		cc.setNome_gerente("xastre");
		c.adicionarCliente(cc);

		Usuario.main(args);

	}
	
}
