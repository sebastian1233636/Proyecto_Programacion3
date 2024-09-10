package pos.presentation.Facturar;

import pos.Application;
import pos.logic.*;

import java.beans.PropertyChangeEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Filter;

public class Controller {
    view view;
    Model model;

    public Controller(view view, Model model) {
        model.init(Service.instance().search(new Cliente()),Service.instance().search(new Cajero()),Service.instance().search(new Linea()));
        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);
    }

    public void AgregarLinea(Producto filter) throws  Exception{
        Linea nuevo = new Linea();
        nuevo.setProducto(filter);
        Service.instance().create(nuevo);
        model.setLineas(Service.instance().getData().getLineas());


    }

    public void BorrarLinea() throws Exception {
        Service.instance().delete(model.getCurrent());
    }

    public double calcularPagoTotal(){
        return Service.instance().PagoTotal(model.getLineas());
    }

    public Producto BuscarProducto(Producto e) throws Exception {
        model.setFilter(e);
        return Service.instance().read(model.getFilter());
    }

    public void establecerCantidad(int cant){
        model.getCurrent().setCantidad(cant);
    }
    public void establecerDescuento(double des){
        model.getCurrent().setDescuento(des);
    }

    public void cancelar(){
        model.setFilter(new Producto());
        model.setLineas(new ArrayList<>());
    }

    public void edit(int row){
        Linea e = model.getLineas().get(row);
        try {
            model.setCurrent(Service.instance().read(e));
        } catch (Exception ex) {}
    }

    public  List<Cliente> loadClientes() {
        List<Cliente> clientes = Service.instance().getData().getClientes();
        model.setClietes(clientes);
        return clientes;
    }

    public  List<Cajero> loadCajeros() {
        List<Cajero> cajeros = Service.instance().getData().getCajeros();
        model.setCajeros(cajeros);
        return cajeros;
    }

    public List<Linea> iniciarLineas(){
        List<Linea> lineas = Service.instance().search(new Linea());
        model.setLineas(lineas);
        return lineas;
    }
























}
