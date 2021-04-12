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
		builder.append("| Nome=");
		builder.append(getNome());
		builder.append(" | E-mail=");
		builder.append(getEmail());
		builder.append("\n| HorasTrabalhadas=");
		int count = 0;
		for ( Integer Integer : getHorasTrabalhadas()){
			builder.append(" | ");
			builder.append(Integer);
			builder.append(" | ");
			count ++ ;
			if(count%5 == 0 ) {
				builder.append("\n");
			}
		}
		builder.append(" | valorHoras=");
		builder.append("\n");
		count = 0;
		for ( float valor : getValorHoras()){
			builder.append(" | ");
			builder.append(valor);
			builder.append(" | ");
			count ++ ;
			if(count % 5 == 0 ) {
				builder.append("\n");
			}
		}
		builder.append(" | dataNascimento=");
		try {
			builder.append(dataUtil.dateToString(getDataNascimento()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return builder.toString();
	}
	
	
	
	
	
}
