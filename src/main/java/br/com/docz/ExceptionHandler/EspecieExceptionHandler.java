package br.com.docz.ExceptionHandler;

import br.com.docz.Helper.ExceptionHelper;

public class EspecieExceptionHandler implements ExceptionHelper {
	public static String objectNotFound(){
		return "Espécie não encontrada";
	}
	
	public static String fieldNotNull(){
		return "Campos não podem ser nulos";
	}
	
	public static String parameterNotNull(){
		return "Parâmetro não pode ser nulo";
	}
	
}
