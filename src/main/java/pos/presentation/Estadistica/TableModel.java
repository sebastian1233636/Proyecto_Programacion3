package pos.presentation.Estadistica;

import pos.logic.Producto;
import pos.presentation.AbstractTableModel;
import java.util.List;

public class TableModel extends AbstractTableModel<Producto> implements javax.swing.table.TableModel {
    public TableModel(int[] cols, List<Producto> rows) {
        super(cols, rows);
    }

    public static final int ID=0;
    public static final int NOMBRE=1;

    @Override
    protected Object getPropetyAt(Producto e, int col) {
        switch (cols[col]){

            default: return "";
        }
    }

    @Override
    protected void initColNames(){
        colNames = new String[5];
        colNames[ID]= "Id";
        colNames[NOMBRE]= "Nombre";
    }
}