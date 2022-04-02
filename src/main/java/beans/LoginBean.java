package main.java.beans;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

import main.java.entities.User;
import main.java.model.dao.DAOFactory;
import main.java.model.dao.UserDAO;
import main.java.util.Util;

@ManagedBean(name = "loginBean")
@RequestScoped
public class LoginBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private String username;
	private String password;

	private UIComponent buttonLogin;
	private UIComponent buttonRegister;

	public void logar() {
		if (processValues()) {
			try {
				FacesContext.getCurrentInstance().getExternalContext()
						.redirect("/JSFWebProject/faces/pages/index.xhtml");
			} catch (IOException e) {
				FacesContext context = FacesContext.getCurrentInstance();
				FacesMessage message = new FacesMessage(e.getMessage());
				context.addMessage(buttonLogin.getClientId(context), message);
			}
		}
	}

	private boolean processValues() {
		return validaDadosRecebidos();
	}

	private boolean validaDadosRecebidos() {
		UserDAO userDAO = DAOFactory.createUserDAO();
		User user = userDAO.findByUsername(username);

		if (username.trim().equals("") || password.trim().equals("")) {
			FacesContext context = FacesContext.getCurrentInstance();
			FacesMessage message = new FacesMessage("É necessário preencher ambos os campos");
			context.addMessage(buttonLogin.getClientId(context), message);
			return false;
		}

		if (user == null) {
			FacesContext context = FacesContext.getCurrentInstance();
			FacesMessage message = new FacesMessage("Esse usuário não existe!");
			context.addMessage(buttonLogin.getClientId(context), message);
			return false;
		}

		if (user != null && !user.getPassword().equals(password)) {
			FacesContext context = FacesContext.getCurrentInstance();
			FacesMessage message = new FacesMessage("A senha do usuário está incorreta!");
			context.addMessage(buttonLogin.getClientId(context), message);
			return false;
		}
		Util.setUser(user);
		return true;
	}

	public void registrar() {
		UserDAO userDAO = DAOFactory.createUserDAO();

		if (username.trim().equals("") || password.trim().equals("")) {
			FacesContext context = FacesContext.getCurrentInstance();
			FacesMessage message = new FacesMessage("É necessário preencher ambos os campos");
			context.addMessage(buttonRegister.getClientId(context), message);
		}

		if (userDAO.findByUsername(username) != null) {
			FacesContext context = FacesContext.getCurrentInstance();
			FacesMessage message = new FacesMessage("Este nome de usuário já foi registrado.");
			context.addMessage(buttonRegister.getClientId(context), message);
		}

		else {
			User user = new User(null, username, password);

			userDAO.insert(user);
			try {
				FacesContext.getCurrentInstance().getExternalContext()
						.redirect("/JSFWebProject/faces/pages/login.xhtml");
			} catch (IOException e) {
				FacesContext context = FacesContext.getCurrentInstance();
				FacesMessage message = new FacesMessage(e.getMessage());
				context.addMessage(buttonRegister.getClientId(context), message);
			}
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

	public UIComponent getButtonLogin() {
		return buttonLogin;
	}

	public void setButtonLogin(UIComponent buttonLogin) {
		this.buttonLogin = buttonLogin;
	}

	public UIComponent getButtonRegister() {
		return buttonRegister;
	}

	public void setButtonRegister(UIComponent buttonRegister) {
		this.buttonRegister = buttonRegister;
	}

}
