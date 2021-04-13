package view.functionsVisuals;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
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
			StringBuilder builder = new StringBuilder();
			if(i == 0) {
				fun = cadastros.informacao();
				i = 1; 
			}else {
				builder.append("---------------menu---------------");
				builder.append("\n1 - Adicionar horas trabalhadas");
				if(fun.getHorasTrabalhadas().size() > 0)
					builder.append("\n2 - Mostrar informações");
				builder.append("\n9 - sair");
				builder.append("\n: ");
						
				System.out.print(builder.toString());
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
	
	
	private void mostrarInformacao() {
		float soma = 0;
		List<Float> salarioList = new ArrayList<Float>();
		String maior = "";
		String menor = "";
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < fun.getHorasTrabalhadas().size(); i++) {
			float salario = fun.getHorasTrabalhadas().get(i)*fun.getValorHoras().get(i);
			salarioList.add(salario);
			builder.append("Salario "+(i+1)+": ");
			builder.append(salario);
			builder.append("\n");
			soma+=salario;
			
		}
		
		builder.append("\nMédia Salárial: ");
		builder.append(soma/fun.getHorasTrabalhadas().size());
		
		int mostrar = 0;
		do {
			System.out.print("\nQuantos salarios mostrar: ");
			 mostrar = Integer.parseInt(entrada.nextLine());
			 if(mostrar > salarioList.size()) {
				 System.out.println("Valor maior que a quantidade de salarios");
			 }
		}while(mostrar > salarioList.size());
		maior = Maior(salarioList, mostrar);
		menor = Menor(salarioList, mostrar);
		builder.append("\nMaiores Salários: ");
		builder.append(maior);
		builder.append("\nMenores salarios");
		builder.append(menor);
		builder.append("\nMeses Trabalhados: ");
		builder.append(fun.getHorasTrabalhadas().size());
		builder.append("\nAnosTrabalhados: ");
		int anos = (int)(fun.getHorasTrabalhadas().size()/12);
		builder.append(anos);
		int meses = (fun.getHorasTrabalhadas().size()%12);
		builder.append("\nFração (sobra) de meses trabalhas: ");
		builder.append(meses);
		builder.append("\nAnos e meses trabalhados: ");
		builder.append(anos);
		if(anos == 1) 
			builder.append(" ano ");
		else
			builder.append(" anos ");
		builder.append(meses);
		if(meses == 1) 
			builder.append(" mês");
		else
			builder.append(" Meses");
		builder.append("\nAno dos 35 anos de contribuição: ");
		Calendar cal = Calendar.getInstance();
		Calendar hj = Calendar.getInstance();
		builder.append(hj.get(Calendar.YEAR)+(35-anos));
		builder.append("\nAno idade minima(65 Anos): ");
		cal.setTime(fun.getDataNascimento());
		builder.append(cal.get(Calendar.YEAR)+65);
		builder.append("\nAno Nascimento: ");
		builder.append(cal.get(Calendar.YEAR));
		builder.append("\nAno Aposentadoria: ");
		int year = hj.get(Calendar.YEAR)+(35-anos) > cal.get(Calendar.YEAR)+65 ?hj.get(Calendar.YEAR)+(35-anos) : cal.get(Calendar.YEAR)+65;
		builder.append(year);
		builder.append("\nIdade Aposentadoria: ");
		int aposentadoria = (int)(hj.get(Calendar.YEAR)+(35-anos))-cal.get(Calendar.YEAR); 
		builder.append(aposentadoria);
		builder.append("\nIdade Atual: ");
		int idade = (int)hj.get(Calendar.YEAR)-cal.get(Calendar.YEAR);
		builder.append(idade);
		builder.append("\nAnos Faltantes para se aposentar: ");
		builder.append(aposentadoria - idade);
		
		
		builder.append("\n"+fun.toString());
		System.out.println(builder.toString());
	}
	private String Maior(List<Float> salarios, int mostrar) {
		StringBuilder builder = new StringBuilder();
		int count = 0;
		float[] maior = new float[mostrar];
		builder.append("Array("+mostrar+"){ ");
		for(int i = 0; i < mostrar; i++) {
			for (int j = 0; j < salarios.size();j++) {
				if(maior[i] < salarios.get(j)) {
					maior[i] = salarios.get(j);
					count = j;
				}
			}
			salarios.remove(count);
			builder.append("["+i+"] => float(");
			builder.append(maior[i]);
			builder.append("), ");
		}
		builder.append(" }");
		
		return builder.toString();
	}
	private String Menor(List<Float> salarios, int mostrar) {
		StringBuilder builder = new StringBuilder();
		int count = 0;
		float[] menor = new float[mostrar];
		for(int i = 0; i < mostrar; i++) {
			menor[i] = salarios.get(0);
			for (int j = 0; j < salarios.size();j++) {
				if(menor[i] > salarios.get(j)) {
					menor[i] = salarios.get(j);
					count = salarios.hashCode();
				}
			}
			salarios.remove(menor[i]);
			builder.append(" ");
			builder.append(menor[i]);
			if(i % 5 == 0) {
				builder.append("\n");
			}
		}
		
		return builder.toString();
	}
}
