package main.java.beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;

import main.java.entities.Category;
import main.java.services.CategoryService;

@ManagedBean(name = "insertProductBean")
@RequestScoped
public class InsertProductBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private CategoryService categoryService;
	
	private List<Category> categories;
	
	private Category categorySelected;
	
	private String productName;
	
	
	@PostConstruct
	public void init() {
		categoryService = new CategoryService();
		categories = categoryService.findAll();
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	
	public Category getCategorySelected() {
		return categorySelected;
	}

	public void setCategorySelected(Category categorySelected) {
		this.categorySelected = categorySelected;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public void onSelect(SelectEvent<String> event) {
		String strId = event.getObject().toString();
		Integer id = Integer.parseInt(strId);
		categorySelected = categoryService.findById(id);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Categoria Selecionada: ", categorySelected.getName()));
    }
}
