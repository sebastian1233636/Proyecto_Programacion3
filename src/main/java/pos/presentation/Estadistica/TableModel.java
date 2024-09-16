package pos.presentation.Estadistica;

import pos.logic.Cliente;
import pos.logic.objetoEstadistica;
import pos.presentation.AbstractTableModel;
import java.util.List;
import java.util.ArrayList;

public class TableModel extends AbstractTableModel<objetoEstadistica> implements javax.swing.table.TableModel {
    private objetoEstadistica objetoEstadistica;
    public TableModel(int[] cols, List<objetoEstadistica> rows,objetoEstadistica obj) {
        super(cols, rows);
        this.objetoEstadistica = obj;
    }

    public static final int CATEGORIA=0;



    @Override
    protected Object getPropetyAt(objetoEstadistica e, int col) {
        switch (cols[col]){
             case CATEGORIA: return e.getCategoria();
            default: return "";
        }
    }

    @Override
    protected void initColNames(){
        colNames = new String[objetoEstadistica.contarFechas()];
        colNames[CATEGORIA]= "categoria";
        int indice = 1;
        for(String nombres : objetoEstadistica.getFechas()){
            colNames[indice]= nombres;
            indice++;
        }


    }
}
