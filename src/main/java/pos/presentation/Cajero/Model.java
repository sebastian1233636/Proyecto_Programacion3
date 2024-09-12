package pos.presentation.Cajero;

import pos.Application;
import pos.logic.Cajero;
import pos.presentation.AbstractModel;
import java.beans.PropertyChangeListener;
import java.util.List;

public class Model extends AbstractModel {
    Cajero filter;
    List<Cajero> list;
    Cajero current;
    int mode;

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        super.addPropertyChangeListener(listener);
        firePropertyChange(LIST);
        firePropertyChange(CURRENT);
        firePropertyChange(FILTER);
    }

    public Model() {}

    public void init(List<Cajero> list){
        this.list = list;
        this.current = new Cajero();
        this.filter = new Cajero();
        this.mode= Application.MODE_CREATE;
    }

    public List<Cajero> getList() {
        return list;
    }
    public Cajero getCurrent() {
        return current;
    }
    public Cajero getFilter() {
        return filter;
    }
    public int getMode() {
        return mode;
    }

    public void setList(List<Cajero> list){
        this.list = list;
        firePropertyChange(LIST);
    }

    public void setCurrent(Cajero current) {
        this.current = current;
        firePropertyChange(CURRENT);
    }

    public void setFilter(Cajero filter) {
        this.filter = filter;
        firePropertyChange(FILTER);
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

    public static final String LIST="list";
    public static final String CURRENT="current";
    public static final String FILTER="filter";
}