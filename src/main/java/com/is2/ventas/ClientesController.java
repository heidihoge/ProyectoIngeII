package com.is2.ventas;

import com.is2.ventas.util.MobilePageController;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "clientesController")
@ViewScoped
public class ClientesController extends AbstractController<Clientes> {

    @Inject
    private MobilePageController mobilePageController;

    public ClientesController() {
        // Inform the Abstract parent controller of the concrete Clientes Entity
        super(Clientes.class);
    }

    /**
     * Sets the "items" attribute with a collection of Ventas entities that are
     * retrieved from Clientes?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Ventas page
     */
    public String navigateVentasList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Ventas_items", this.getSelected().getVentasList());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/ventas/index";
    }

}
