package exercicios_lista.exer01.cripto;

import java.math.BigInteger;
import java.security.MessageDigest;

public class criptografia {
	public static String SHA1(String usuario) {
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
}
