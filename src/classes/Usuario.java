package exercicios_lista.exer01.classes;

import exercicios_lista.exer01.cripto.criptografia;

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


    @Override
    public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("usuario [usuario=");
            builder.append(usuario);
            builder.append(", senha=");
            builder.append(senha);
            builder.append("]");
            return builder.toString();
    }	
}
