package pos.presentation.Facturar;

import pos.Application;
import pos.logic.Cliente;
import pos.logic.Cajero;
import pos.logic.Linea;
import pos.logic.Producto;
import pos.presentation.AbstractModel;
import java.beans.PropertyChangeListener;

import java.util.List;

public class Model extends AbstractModel {
    private List<Cliente> clientes;
    private List<Cajero> cajeros;
    private List<Linea> lineas;
    private Linea Current;
    private Producto filter;


    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        super.addPropertyChangeListener(listener);
        firePropertyChange(LISTCLIENTES);
        firePropertyChange(LISTCAJEROS);
        firePropertyChange(LISTLINEAS);
        firePropertyChange(FILTER);
    }

    public Model() {
    }

    public void init(List<Cliente> list, List<Cajero> list2,List<Linea> list3){
       this.clientes = list;
       this.cajeros = list2;
       this.lineas = list3;
       this.filter = new Producto();

    }

    public List<Cliente> getClientes() {
        return clientes;
    }
    public List<Cajero> getCajeros() {
        return cajeros;
    }
    public List<Linea> getLineas() {return lineas;}
    public Producto getFilter() {
        return filter;
    }

    public Linea getCurrent() {
        return Current;
    }

    public void setClietes(List<Cliente> list){
        this.clientes = list;
        firePropertyChange(LISTCLIENTES);
    }
    public void setCajeros(List<Cajero> list){
        this.cajeros = list;
        firePropertyChange(LISTCAJEROS);
    }
    public void setLineas(List<Linea> list){
        this.lineas = list;
        firePropertyChange(LISTLINEAS);
    }

    public void setFilter(Producto filter) {
        this.filter = filter;
        firePropertyChange(FILTER);
    }
    public void setCurrent(Linea Current) {
        this.Current = Current;
    }



    public static final String LISTCLIENTES="listCli";
    public static final String LISTLINEAS="listLi";
    public static final String LISTCAJEROS="listCa";
    public static final String FILTER="filter";
}