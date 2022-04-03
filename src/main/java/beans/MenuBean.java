package main.java.beans;

import java.io.IOException;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

import main.java.entities.User;
import main.java.util.Util;

@ManagedBean(name = "menuBean")
@RequestScoped
public class MenuBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private UIComponent buttonIndex;
	
	private UIComponent buttonLogin;
	
	private UIComponent buttonProducts;
	
	private User user;

    @PostConstruct
    public void init() {
        user = Util.getUser();
    }
    
    public void goToIndex() {
    	try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("/JSFWebProject/faces/pages/index.xhtml");
		} catch (IOException e) {
			FacesContext context = FacesContext.getCurrentInstance();
			FacesMessage message = new FacesMessage(e.getMessage());
			context.addMessage(buttonIndex.getClientId(context), message);
		}
    }
    
    public void goToLogin() {
    	try {
    		Util.setUser(null);
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("/JSFWebProject/faces/pages/login.xhtml");
		} catch (IOException e) {
			FacesContext context = FacesContext.getCurrentInstance();
			FacesMessage message = new FacesMessage(e.getMessage());
			context.addMessage(buttonIndex.getClientId(context), message);
		}
    }
    
    public void goToProducts() {
    	try {
    		Util.setUser(null);
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("/JSFWebProject/faces/pages/products.xhtml");
		} catch (IOException e) {
			FacesContext context = FacesContext.getCurrentInstance();
			FacesMessage message = new FacesMessage(e.getMessage());
			context.addMessage(buttonProducts.getClientId(context), message);
		}
    }

	public UIComponent getButtonIndex() {
		return buttonIndex;
	}

	public void setButtonIndex(UIComponent buttonIndex) {
		this.buttonIndex = buttonIndex;
	}

	public UIComponent getButtonLogin() {
		return buttonLogin;
	}

	public void setButtonLogin(UIComponent buttonLogin) {
		this.buttonLogin = buttonLogin;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UIComponent getButtonProducts() {
		return buttonProducts;
	}

	public void setButtonProducts(UIComponent buttonProducts) {
		this.buttonProducts = buttonProducts;
	}
}
