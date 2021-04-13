package classes;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import util.dataUtil;

public class Funcionario extends Usuario {

	public Funcionario(String usuario, String senha) {
		super(usuario, senha);
	}
	
	public Funcionario() {
		
	}
	private String nome;
	private String email;
	private List<Integer> HorasTrabalhadas = new ArrayList<Integer>();
	private List<Float> valorHoras = new ArrayList<Float>();
	private Date dataNascimento;
	
	public void setUsuario(Usuario user) {
		super.setUsuario(user.getUsuario());
		super.setSenhaCrypto(user.getSenha());
	}
	
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Integer> getHorasTrabalhadas() {
		return HorasTrabalhadas;
	}

	public void setHorasTrabalhadas(List<Integer> horasTrabalhadas) {
		HorasTrabalhadas = horasTrabalhadas;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public List<Float> getValorHoras() {
		return valorHoras;
	}

	public void setValorHoras(List<Float> valorHoras) {
		this.valorHoras = valorHoras;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.toString());
		builder.append("\n| Nome=");
		builder.append(getNome());
		builder.append("\n| E-mail=");
		builder.append(getEmail());
		builder.append("\n| HorasTrabalhadas=");
		builder.append(horasTrabalhadas());
		
		builder.append("\n| valorHoras=");
		builder.append(valorHoras());
		
		builder.append("\n| dataNascimento=");
		try {
			builder.append(dataUtil.dateToString(getDataNascimento()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return builder.toString();
	}
	
	private String horasTrabalhadas() {
		StringBuilder builder = new StringBuilder();
		int count = 0;
		for ( Integer Integer : getHorasTrabalhadas()){
			builder.append(" | ");
			builder.append(Integer);
			count++;
			if(count%8 == 0 ) {
				builder.append("\n");
			}
		}
		return builder.toString();
	}
	
	private String valorHoras() {
		StringBuilder builder = new StringBuilder();
		int count = 0;
		for ( float valor : getValorHoras()){
			builder.append(" | ");
			builder.append(valor);
			count++;
			if(count % 8 == 0 ) {
				builder.append("\n");
			}
		}
		return builder.toString();
	}
	
}
