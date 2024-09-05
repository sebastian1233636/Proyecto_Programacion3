package pos.presentation.Historico;

import pos.Application;
import pos.logic.Cajero;
import pos.logic.Factura;
import pos.logic.Linea;
import pos.presentation.AbstractModel;

import java.beans.PropertyChangeListener;
import java.util.List;

public class Model extends AbstractModel {
Factura filter;
List<Factura> facturas;
Factura current;

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        super.addPropertyChangeListener(listener);
        firePropertyChange(LIST);
        firePropertyChange(CURRENT);
        firePropertyChange(FILTER);
    }

    public Model() {
    }

    public void init(List<Factura> list){
        this.facturas = list;
        this.current = new Factura();
        this.filter = new Factura();
    }

    public List<Factura> getList() {
        return facturas;
    }

    public void setList(List<Factura> list){
        this.facturas = list;
        firePropertyChange(LIST);
    }

    public Factura getCurrent() {
        return current;
    }

    public void setCurrent(Factura current) {
        this.current = current;
        firePropertyChange(CURRENT);
    }

    public Factura getFilter() {
        return filter;
    }

    public void setFilter(Factura filter) {
        this.filter = filter;
        firePropertyChange(FILTER);
    }

    public static final String LIST="list";
    public static final String CURRENT="current";
    public static final String FILTER="filter";

}
