package classes;

import java.math.BigInteger;
import java.security.MessageDigest;


public class Usuario {
    private String usuario;
    private String senha;


    public Usuario(){
    }

    public Usuario(String usuario, String senha) {
        setUsuario(usuario);
        setSenha(senha);
    }

    public String getUsuario() {
            return usuario;
    }
    public String getSenha() {
            return senha;
    }
    public void setUsuario(String usuario) {
            this.usuario = usuario;
    }
    public void setSenha(String senha) {
            this.senha = SHA1(senha);
    }
    public void setSenhaCrypto(String senha) {
        this.senha = senha;
    }


	private String SHA1(String usuario) {
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-1");
	        digest.reset();
	        digest.update(usuario.getBytes("utf8"));
	        usuario = String.format("%040x", new BigInteger(1, digest.digest()));
		} catch (Exception e){
			e.printStackTrace();
		}
		return usuario;
	}
    @Override
    public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("\n| User=");
            builder.append(this.getUsuario());
            builder.append("\n| Pass=");
            builder.append(this.getSenha());
            return builder.toString();
    }	
}
