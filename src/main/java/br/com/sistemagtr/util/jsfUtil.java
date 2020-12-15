package br.com.sistemagtr.util;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import java.util.Map;

public class jsfUtil {
	public static String getParam(String nome) {

		FacesContext contexto = FacesContext.getCurrentInstance();

		ExternalContext externalContext = contexto.getExternalContext();

		Map<String, String> parametros = externalContext.getRequestParameterMap();

		String valor = parametros.get(nome);

		return valor;
	}
}
