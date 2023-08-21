package br.com.docz.helper;

public interface ExceptionHelper {
	
	public static String objectNotFound(String param){
		return param + " não encontrado(a)";
	}
	
	public static String fieldNotNull(String param){
		return param + " não pode(m) ser nulo(s)";
	}
	
	public static String parameterNotNull(){
		return "Parâmetro não pode ser nulo";
	}
}
