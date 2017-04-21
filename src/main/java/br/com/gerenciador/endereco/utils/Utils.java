package br.com.gerenciador.endereco.utils;

public class Utils {
	public static String replaceToString(String cep, Integer posicao) {
		
		StringBuilder str = new StringBuilder(cep);
		str.setCharAt(posicao, '0');
		return str.toString();
	}

}
