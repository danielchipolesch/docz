package br.com.docz.exception;

import br.com.docz.helper.ExceptionHelper;

public class AssuntoBasicoException implements ExceptionHelper {
	
	private static final String ASSUNTO_BASICO_NAO_ENCONTRADO = "Assunto Básico não encontrado";
	private static final String CAMPO_NAO_ENCONTRADO = "Nenhum campo pode ser nulo";
	private static final String PARAMETRO_BASICO_NAO_ENCONTRADO = "Parâmetro não pode ser nulo";
	
	public static String objectNotFound(){
		return ASSUNTO_BASICO_NAO_ENCONTRADO;
	}
	
	public static String fieldNotNull(){
		return CAMPO_NAO_ENCONTRADO;
	}
	
	public static String parameterNotNull(){
		return PARAMETRO_BASICO_NAO_ENCONTRADO;
	}
}
