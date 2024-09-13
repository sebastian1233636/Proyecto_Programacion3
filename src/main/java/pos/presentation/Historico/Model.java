package pos.presentation.Historico;

import pos.Application;
import pos.logic.Cliente;
import pos.logic.Factura;
import pos.logic.Linea;
import pos.presentation.AbstractModel;

import java.beans.PropertyChangeListener;
import java.util.*;

public class Model extends AbstractModel {
    Factura filter;
    List<Factura> list;
    List<Linea> listalineas;
    Factura current;
    int mode;

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
        this.list = list;
        this.current = new Factura();
        this.filter = new Factura();
        this.listalineas = current.getCarrito();
        this.mode= Application.MODE_CREATE;
    }

    public List<Factura> getList() {
        return list;
    }

    public void setList(List<Factura> list){
        this.list = list;
        firePropertyChange(LIST);
    }

    public List<Linea> getListalineas() {
        return listalineas;
    }
    public void setListalineas(List<Linea> listalineas){
        this.listalineas = listalineas;
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

    public int getMode() {
        return mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

    public static final String LIST="list";
    public static final String CURRENT="current";
    public static final String FILTER="filter";

}