package pos.presentation.Facturar;

import pos.Application;
import pos.logic.*;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    view view;
    Model model;

    public Controller(view view, Model model) {
        model.init(Service.instance().search(new Cliente()),Service.instance().search(new Cajero()),Service.instance().search(new Linea()));
        this.view = view;
        this.model = model;
    }

    public void AgregarLinea(Producto filter) throws  Exception{
        Linea nuevo = new Linea();
        model.setFilter(filter);
        nuevo.setProducto(Service.instance().read(filter));
        model.getLineas().add(nuevo);
    }


    public void BorrarLinea() throws Exception {
        Service.instance().delete(model.getCurrent());
    }


    public double calcularPagoTotal(){
        return Service.instance().PagoTotal(model.getLineas());
    }

    public Producto BuscarProducto(Producto e) throws Exception {
        return Service.instance().read(e);
    }
    public void establecerCantidad(int cant){
        model.getCurrent().setCantidad(cant);
    }
    public void establecerDescuento(double des){
        model.getCurrent().setDescuento(des);
    }

    public void cancelar(){
        model.setFilter(new Producto());
        model.setLineas(Service.instance().search(new Linea()));
    }


    public void edit(int row){
        Linea e = model.getLineas().get(row);
        try {
            model.setCurrent(Service.instance().read(e));
        } catch (Exception ex) {}
    }

    public void loadClientes(){
        model.setClietes(Service.instance().getData().getClientes());
    }
    public void loadCajeros(){
        model.setCajeros(Service.instance().getData().getCajeros());
    }























}
