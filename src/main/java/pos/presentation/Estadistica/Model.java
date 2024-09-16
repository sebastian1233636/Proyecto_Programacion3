package pos.presentation.Estadistica;

import pos.Application;
import pos.logic.Categoria;
import pos.logic.Cliente;
import pos.logic.Rango;
import pos.presentation.AbstractModel;
import pos.presentation.AbstractTableModel;
import java.beans.PropertyChangeListener;
import java.util.List;

public class Model extends AbstractModel {
    List<Categoria> categoriasAll;
    List<Categoria> categorias;
    List<String> anniodesde;
    List<String> annioHasta;
    List<String> mesDesde;
    List<String> mesHasta;
    Rango rango;
    String[] rows;
    String[] cols;
    float[][] data;


    public Model(){}

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        super.addPropertyChangeListener(listener);
        firePropertyChange(CATEGORASALL);
        firePropertyChange(CATEGORIAS);
        firePropertyChange(ANNIOD);
        firePropertyChange(ANNIOH);
        firePropertyChange(RANGO);
        firePropertyChange(MESDESDE);
        firePropertyChange(MESHASTA);

    }

    public void Init(List<Categoria> all,List<Categoria> cats){
        this.categoriasAll=all;
        this.categorias=cats;
    }

    public int getRowCount(){
        return rows.length;
    }
    public int getColumnCount(){
        return cols.length+1;
    }
    public List<String> getAnniodesde(){
        return anniodesde;
    }
    public List<String> getAnnioHasta(){
        return annioHasta;
    }
    public List<String> getMesDesde(){
        return mesDesde;
    }
    public List<String> getMesHasta(){
        return mesHasta;
    }
    public Rango getRango(){return rango;}
    public List<Categoria> getCategorias(){return categorias;}


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

    public void setAnniodesde(List<String> nuevo){
        anniodesde = nuevo;
        firePropertyChange(ANNIOD);
    }
    public void setAnnioHasta(List<String> nuevo){
        annioHasta = nuevo;
        firePropertyChange(ANNIOH);
    }
    public void setMesDesde(List<String> nuevo){
        mesDesde = nuevo;
        firePropertyChange(MESDESDE);
    }
    public void setMesHasta(List<String> nuevo){
        mesHasta = nuevo;
        firePropertyChange(MESHASTA);
    }

    public static final String CATEGORASALL="CategoriasTodas";
    public static final String CATEGORIAS="Categorias";
    public static final String RANGO = "rango";
    public static final String ANNIOD = "AnnioDesde";
    public static final String ANNIOH = "AnnioHasta";
    public static final String MESDESDE = "mesdesde";
    public static final String MESHASTA = "meshasta";
}
