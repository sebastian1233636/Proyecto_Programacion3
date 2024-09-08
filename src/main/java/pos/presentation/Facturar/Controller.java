package pos.presentation.Facturar;

import pos.Application;
import pos.logic.*;

public class Controller {
    view view;
    Model model;

    public Controller(view view, Model model) {
        model.init(Service.instance().search(new Cliente()),Service.instance().search(new Cajero()),Service.instance().search(new Linea()));
        this.view = view;
        this.model = model;
        //view.setController(this);
        //view.setModel(model);
    }

    public void Guardar(Factura e) throws  Exception{
        switch (model.getMode()) {
            case Application.MODE_CREATE:
                Service.instance().create(e);
                break;
            case Application.MODE_EDIT:
                Service.instance().update(e);
                break;
        }
        model.setFilter(new Producto());
    }

    public void AgregarLinea(Producto filter) throws  Exception{
        Linea nuevo = new Linea();
        model.setFilter(filter);
        nuevo.setProducto(Service.instance().read(filter));
        model.getLineas().add(nuevo);
    }


    public void BorrarLinea() throws Exception {Service.instance().delete(model.getCurrent());}

    public void clear() {
        model.setMode(Application.MODE_CREATE);
        model.setCurrent(new Linea());
    }

    public double calcularPagoTotal(){
        return Service.instance().PagoTotal(model.getLineas());
    }


    public void delete() throws Exception {
        Service.instance().delete(model.getCurrent());
    }



}
