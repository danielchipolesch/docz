package br.com.docz.exception;

import br.com.docz.helper.ExceptionHelper;

public class EspecieException implements ExceptionHelper {
	
	private static final String ESPECIE_NAO_ENCONTRADA = "Espécie não encontrada";
	private static final String CAMPO_NAO_ENCONTRADO = "Nenhum campo pode ser nulo";
	private static final String PARAMETRO_BASICO_NAO_ENCONTRADO = "Parâmetro não pode ser nulo";
	
	public static String objectNotFound(){
		return ESPECIE_NAO_ENCONTRADA;
	}
	
	public static String fieldNotNull(){
		return CAMPO_NAO_ENCONTRADO;
	}
	
	public static String parameterNotNull(){
		return PARAMETRO_BASICO_NAO_ENCONTRADO;
	}
	
}
