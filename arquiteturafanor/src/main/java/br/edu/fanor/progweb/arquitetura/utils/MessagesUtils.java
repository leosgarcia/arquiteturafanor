package br.edu.fanor.progweb.arquitetura.utils;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
/**
 * @author patrick.cunha
 * 
 */
public class MessagesUtils {

	public static void info(String msg) {
		flashScope().setKeepMessages(true); // suporte a redirect
		facesContext().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Info:", msg));
	}

	public static void warn(String msg) {
		facesContext().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_WARN, "Atenção:", msg));
	}
	
	public static void error(String msg) {
		facesContext().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro:", msg));
	}
	
	public static void fatal(String msg) {
		facesContext().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_FATAL, "Crash:", msg));
	}
	
	private static Flash flashScope() {
		return facesContext().getExternalContext().getFlash();
	}

	private static FacesContext facesContext() {
		return FacesContext.getCurrentInstance();
	}
}
