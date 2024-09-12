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
        model.init(Service.instance().getData().getClientes(),Service.instance().getData().getCajeros(),Service.instance().search(new Linea()));
        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);
    }

    public void AgregarLinea(Producto filter) throws  Exception{
        Linea nuevo = new Linea();
        nuevo.setCantidad(1);
        filter.setExistencias(filter.getExistencias()-1);
        nuevo.setProducto(filter);
        Service.instance().create(nuevo);
        model.setLineas(Service.instance().getData().getLineas());
    }

    public void BorrarLinea() throws Exception {
        Service.instance().delete(model.getCurrent());
        model.setLineas(Service.instance().getData().getLineas());
    }

    public double calcularPagoTotal(){
        return Service.instance().PagoTotal(model.getLineas());
    }

    public Producto BuscarProducto(Producto e) throws Exception {
        model.setFilter(e);
        return Service.instance().read(model.getFilter());
    }


    public void cancelar(){
        model.setFilter(new Producto());
        Service.instance().getData().getLineas().clear();
        model.setLineas(Service.instance().getData().getLineas());
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

    public void iniciarLineas(){
        List<Linea> lineas = Service.instance().getData().getLineas();
        model.setLineas(lineas);
    }

    public Factura crearFactura(String nombreCli,String nombreCaje) {
        int numero = Service.instance().getData().getFacturas().size()+1;
        String fecha = java.time.LocalDate.now().toString();
        String numCodigo = Integer.toString(numero);
        String nombreFactura = "FC0"+ numCodigo;
        Factura factura = new Factura(nombreFactura, nombreCli, nombreCaje, model.getLineas());
        return factura;
    }

}