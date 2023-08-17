package br.com.docz.ExceptionHandler;

import br.com.docz.Helper.ExceptionHelper;

public class AssuntoBasicoExceptionHandler implements ExceptionHelper {
	
	public static String objectNotFound(){
		return "Assunto Básico não encontrado";
	}
	
	public static String fieldNotNull(){
		return "Nenhum campo pode ser nulo";
	}
	
	public static String parameterNotNull(){
		return "Parâmetro não pode ser nulo";
	}
}
