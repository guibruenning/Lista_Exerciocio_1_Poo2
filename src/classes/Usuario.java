package classes;

import cripto.criptografia;

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
            this.senha = criptografia.SHA1(senha);
    }
    public void setSenhaCrypto(String senha) {
        this.senha = senha;
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
