package pos.presentation.Historico;

import pos.logic.Cliente;
import pos.logic.Factura;
import pos.presentation.AbstractTableModel;

import java.util.List;

public class TableModel extends AbstractTableModel<Factura> implements javax.swing.table.TableModel {

    public TableModel(int[] cols, List<Factura> rows) {
        super(cols, rows);
    }
    public static final int CODIGO=0;
    public static final int FECHA=1;
    public static final int ID=2;
    public static final int TOTAL=3;

    @Override
    protected Object getPropetyAt(Factura e, int col) {
        switch (cols[col]){
            case ID: return e.getID();
            case FECHA: return e.getFecha();
            case CODIGO: return e.getCodigo();
            case TOTAL: return e.totalFactura();
            default: return "";
        }
    }

    public Object getValueAt(int row, int col) {
        Factura e = rows.get(row);
        return getPropetyAt(e, col);
    }



    @Override
    protected void initColNames(){
        colNames = new String[4];
        colNames[ID]= "Id-Cliente";
        colNames[FECHA]= "Fecha";
        colNames[CODIGO]= "Codigo";
        colNames[TOTAL]= "Total";

    }

}
