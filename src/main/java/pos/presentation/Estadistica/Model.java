package pos.presentation.Estadistica;


import pos.Application;
import pos.logic.Categoria;
import pos.logic.Cliente;
import pos.presentation.AbstractModel;
import pos.presentation.AbstractTableModel;
import java.beans.PropertyChangeListener;
import java.util.List;


public class Model extends AbstractModel {
    List<Categoria> categoriasAll;
    List<Categoria> categorias;
    String[] rows;
    String[] cols;
    float[][] data;

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        super.addPropertyChangeListener(listener);
        firePropertyChange(CATEGORASALL);

    }


    public static final String CATEGORASALL="CategoriasTodas";

}
