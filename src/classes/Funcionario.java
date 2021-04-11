package exercicios_lista.exer01.classes;

import java.util.Arrays;
import java.util.Date;
import java.util.Timer;

public class Funcionario extends Usuario {

	public Funcionario(String usuario, String senha) {
		super(usuario, senha);
	}
	
	public Funcionario() {
		
	}
	private String nome;
	private String email;
	private Timer[] HorasTrabalhadas;
	private float[] valorHoras;
	private Date dataNascimento;
	public String getNome() {
		return nome;
	}
	public String getEmail() {
		return email;
	}
	public Timer[] getHorasTrabalhadas() {
		return HorasTrabalhadas;
	}
	public float[] getValorHoras() {
		return valorHoras;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setHorasTrabalhadas(Timer[] horasTrabalhadas) {
		HorasTrabalhadas = horasTrabalhadas;
	}
	public void setValorHoras(float[] valorHoras) {
		this.valorHoras = valorHoras;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("funcionario [nome=");
		builder.append(nome);
		builder.append(", email=");
		builder.append(email);
		builder.append(", HorasTrabalhadas=");
		builder.append(Arrays.toString(HorasTrabalhadas));
		builder.append(", valorHoras=");
		builder.append(Arrays.toString(valorHoras));
		builder.append(", dataNascimento=");
		builder.append(dataNascimento);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
	
}
