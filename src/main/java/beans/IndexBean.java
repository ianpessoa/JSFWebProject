package main.java.beans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.primefaces.model.diagram.Connection;
import org.primefaces.model.diagram.DefaultDiagramModel;
import org.primefaces.model.diagram.DiagramModel;
import org.primefaces.model.diagram.Element;
import org.primefaces.model.diagram.endpoint.DotEndPoint;
import org.primefaces.model.diagram.endpoint.EndPointAnchor;

import main.java.util.Util;

@ManagedBean(name = "indexBean")
@RequestScoped
public class IndexBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private DefaultDiagramModel model;

	@PostConstruct
    public void init() {
        model = new DefaultDiagramModel();
        model.setMaxConnections(-1);
        model.setConnectionsDetachable(false);

        Element elementA = new Element("A", "20em", "6em");
        elementA.addEndPoint(new DotEndPoint(EndPointAnchor.BOTTOM));

        Element elementB = new Element("B", "10em", "18em");
        elementB.addEndPoint(new DotEndPoint(EndPointAnchor.TOP));

        Element elementC = new Element("C", "40em", "18em");
        elementC.addEndPoint(new DotEndPoint(EndPointAnchor.TOP));

        model.addElement(elementA);
        model.addElement(elementB);
        model.addElement(elementC);

        model.connect(new Connection(elementA.getEndPoints().get(0), elementB.getEndPoints().get(0)));
        model.connect(new Connection(elementA.getEndPoints().get(0), elementC.getEndPoints().get(0)));
    }

    public DiagramModel getModel() {
        return model;
    }

	public String getMenu() {
		if (Util.getUser() != null) {
			return "/includes/menu.xhtml";
		}
		else {
			return "/includes/menulogin.xhtml";
		}
	}

}
