package view.functionsVisuals;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;


import classes.Funcionario;
import classes.Usuario;
import util.dataUtil;

public class Cadastros{
	static Scanner entrada = new Scanner(System.in);
	
	//Cadastro de Usuário
	public Usuario Login() {
		Usuario user = new Usuario();
		
		
		String usuario = "";
		do {
			System.out.println("Digite um Usuário");
			usuario = entrada.nextLine();
			if(usuario.length() < 3)
				System.out.println("Usuário tem que ser maior que 3 caracteres");
		}while(usuario.length() < 3);
		String senha;
		
		int i = 1;
		do {
			System.out.println("Digite uma Senha");
			senha = entrada.nextLine();
			if(senha.equals(usuario)) {
				System.out.println("Senha não pode ser igual ao Usuário");
				i = 1;
			}else {
				i = 0; 
			}
			if(usuario.length() < 3)
				System.out.println("Usuário tem que ser maior que 3 caracteres");
		}while(i != 0 || senha.length() < 3);
		user.setUsuario(usuario);
		user.setSenha(senha);
		return user;
		
	}
	
	//Cadastro de Funcionario
	public Funcionario informacao() {
		Funcionario fun = new Funcionario();
		Usuario user = Login();
		fun.setUsuario(user);
		System.out.println("Digite seu nome");
		do {
			fun.setNome(entrada.nextLine());
			if(fun.getNome().length() < 3)
				System.out.println("Usuário tem que ser maior que 3 caracteres");
		}while(fun.getNome().length() < 3);
		System.out.println("Digite seu Email");
		do {
			fun.setEmail(entrada.nextLine());
			if(fun.getEmail().length() < 3)
				System.out.println("Usuário tem que ser maior que 3 caracteres");
		}while(fun.getEmail().length() < 3);
		
		System.out.println("Digite sua data de nascimento, Ex: 01/01/2001");
		try {
			fun.setDataNascimento(dataUtil.stringToDate(entrada.nextLine()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return fun;	
	}
	
	public Funcionario horasTrab(Funcionario fun) {
		
		List<Integer> horasTrabalhadas = fun.getHorasTrabalhadas();
		List<Float> valorHoras = fun.getValorHoras();
		int horas;
		do {
			System.out.println("Digite as Horas Trabalhadas");
			horasTrabalhadas.add(Integer.parseInt(entrada.nextLine()));
			System.out.println("Digite o valor pode hora");
			valorHoras.add(Float.parseFloat(entrada.nextLine()));
			
			System.out.print("Continuar Digitando as horas trabalhadas?"
					+ "\n1 - sim"
					+ "\n2 - não"
					+ "\n: ");
			horas = Integer.parseInt(entrada.nextLine());
		}while(horas != 2);
		fun.setHorasTrabalhadas(horasTrabalhadas);
		fun.setValorHoras(valorHoras);
		return fun;
	}


}

