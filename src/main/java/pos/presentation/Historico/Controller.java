package pos.presentation.Historico;

import pos.Application;
import pos.logic.Cajero;
import pos.logic.Factura;
import pos.logic.Service;
import pos.presentation.Cajero.View;

public class Controller {

    view View;
    Model model;

    public Controller(pos.presentation.Historico.view View, pos.presentation.Historico.Model model) {
        model.init(Service.instance().search(new Factura()));
        this.View = View;
        this.model = model;
        View.setController(this);
        View.setModel(model);
    }

    public void search(Factura filter) throws  Exception{
        model.setFilter(filter);
        model.setCurrent(new Factura());
        model.setList(Service.instance().search(model.getFilter()));
    }

    public void clear() {
        model.setCurrent(new Factura());
    }

}
