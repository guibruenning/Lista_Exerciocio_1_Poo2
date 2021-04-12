package view.functionsVisuals;

import java.util.Scanner;
import classes.Funcionario;

public class Menu {
	private int i;
	private int fim;
	private Cadastros cadastros;
	private Funcionario fun;
	
	static Scanner entrada = new Scanner(System.in);
	
	public Menu(int i) {
		this.i=i;
		cadastros = new Cadastros();
		fun = new Funcionario();
	}
	public void menu() {
		do{
			if(i == 0) {
				fun = cadastros.informacao();
				i = 1; 
			}else {
				System.out.print("---------------menu---------------"
						+ "\n1 - Adicionar horas trabalhadas"
						+ "\n2 - Mostrar informações"
						+ "\n9 - sair"
						+ "\n: ");
				fim = Integer.parseInt(entrada.nextLine());
				switch (fim) {
				case 1:
					fun = cadastros.horasTrab(fun);
					break;
				case 2:
					mostrarInformacao();
					break;
				default:
					System.out.println("Volte sempre");
					break;
				}
			}
		}while(fim != 9);
	}
	
	
	public void mostrarInformacao() {
		for (int i = 0; i < fun.getHorasTrabalhadas().size(); i++) {
			System.out.print("Salario "+(i+1)+": ");
			System.out.println(fun.getHorasTrabalhadas().get(i)*fun.getValorHoras().get(i));
		}
		System.out.println(fun.toString());
	}
}
