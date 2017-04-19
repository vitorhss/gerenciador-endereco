package br.com.gerenciador.endereco.utils;

public class Utils {
    public static boolean isValidCep(String cep)
    {
    	String padrao = "^\\d{5}[-]\\d{3}$";
        return cep.matches(padrao);
    }
}
