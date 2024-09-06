package pos.presentation.Productos;

import pos.logic.Producto;
import pos.presentation.AbstractTableModel;
import java.util.List;

public class TableModel extends AbstractTableModel<Producto> implements javax.swing.table.TableModel {

    public TableModel(int[] cols, List<Producto> rows) { super(cols, rows); }

    public static final int CODIGO = 0;
    public static final int DESCRIPCION = 1;
    public static final int UNIDAD_MEDIDA = 2;
    public static final int PRECIO_UNITARIO = 3;
    public static final int CATEGORIA = 4;
    public static final int EXISTENCIAS = 5;

    @Override
    protected Object getPropetyAt(Producto e, int col) {
        switch (cols[col]) {
            case CODIGO: return e.getCodigo();
            case DESCRIPCION: return e.getDescripcion();
            case UNIDAD_MEDIDA: return e.getUnidadMedida();
            case PRECIO_UNITARIO: return e.getPrecioUnitario();
            case CATEGORIA: return e.getCategoria().getNombre();
            case EXISTENCIAS: return e.getExistencias();
            default: return "";
        }
    }

    @Override
    protected void initColNames(){
        colNames = new String[6];
        colNames[CODIGO]= "Código";
        colNames[DESCRIPCION]= " Descripción ";
        colNames[UNIDAD_MEDIDA]= " Unidad de Medida ";
        colNames[PRECIO_UNITARIO]= " Precio Unitario ";
        colNames[CATEGORIA]= " Categoría ";
        colNames[EXISTENCIAS]= " Existencias ";
    }
}