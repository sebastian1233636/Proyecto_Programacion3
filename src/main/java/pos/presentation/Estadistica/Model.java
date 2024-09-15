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
    String rango;
    String[] rows;
    String[] cols;
    float[][] data;

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        super.addPropertyChangeListener(listener);
        firePropertyChange(CATEGORASALL);
        firePropertyChange(CATEGORIAS);
        firePropertyChange(RANGO);

    }

    public void Init(List<Categoria> all,List<Categoria> cats){

    }

    public int getRowCount(){
        return rows.length;
    }
    public int getColumnCount(){
        return cols.length+1;
    }

    public Object getValueAt(int rowIndex, int columnIndex){
        if(columnIndex == 0){
            return rows[rowIndex];
        }else{
            return data[rowIndex][columnIndex-1];
        }
    }

    public String columnName(int column){
        if(column==0){
            return "Categoria";
        }else{
            return cols[column-1];
        }
    }

    public void setCategoriasAll(List<Categoria> categorias){
        this.categoriasAll = categorias;
        firePropertyChange(CATEGORASALL);
    }

    public static final String CATEGORASALL="CategoriasTodas";
    public static final String CATEGORIAS="Categorias";
    public static final String RANGO = "rango";
}
