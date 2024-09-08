package pos.presentation.Facturar;
import java.util.List;
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
        // view.setModel(model);
    }

    public void AgregarProducto(Producto filter) throws  Exception{
        model.setFilter(filter);
        Linea nuevo = new Linea();
    }


    public double calcularPagoTotal(){
        return Service.instance().PagoTotal(model.getLineas());
    }


    public void delete() throws Exception {
        Service.instance().delete(model.getCurrent());
    }



}
