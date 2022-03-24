package br.com.JSFWebProject.servlet;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "loginBean")
@RequestScoped
public class Login implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String username;
	private String password;

	public void logar() throws IOException  {
		processValues();
		FacesContext.getCurrentInstance().getExternalContext().redirect("/JSFWebProject/faces/pages/index.xhtml");
	}

	private void processValues() throws IOException {
		validaDadosRecebidos();
	}

	private void validaDadosRecebidos() throws IOException{
		
		if (username.trim().equals("") || password.trim().equals("")) {
			throw new IOException("É necessário preencher ambos os campos");
		}
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
