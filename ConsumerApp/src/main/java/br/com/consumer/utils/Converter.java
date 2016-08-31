package br.com.consumer.utils;

import java.util.List;

import com.google.gson.Gson;

/**
 * 
 * Classe responsável por oferecer métodos utilitários em geral 
 * @author Renan Lalier <renanlalier@yahoo.com.br>
 * @since 25 de ago de 2016
 * @version 1.0
 */
public class Converter {
	
	public static String converterObjToJson(Object obj){
		
		Gson gson = new Gson();
		return gson.toJson(obj);
		
	}
	
	public static <T> String convertArrayToJson(List<T> lista){
		
		Gson gson = new Gson();
		return gson.toJson(lista);
	}

}
