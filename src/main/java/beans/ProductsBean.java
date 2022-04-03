package main.java.beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.inject.Inject;

import main.java.entities.Product;
import main.java.services.ProductService;

@ManagedBean(name = "productsBean")
@RequestScoped
public class ProductsBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private List<Product> products;
	
	private UIComponent buttonInsert;

    @Inject
    private ProductService service = new ProductService();

    @PostConstruct
    public void init() {
    	service.init();
        products = service.getProducts(100);
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setService(ProductService service) {
        this.service = service;
    }

	public UIComponent getButtonInsert() {
		return buttonInsert;
	}

	public void setButtonInsert(UIComponent buttonInsert) {
		this.buttonInsert = buttonInsert;
	}

}
