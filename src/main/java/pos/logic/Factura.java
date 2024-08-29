package pos.logic;
import java.util.ArrayList;
import java.util.List;
public class Factura {
    private String ID;
    private String fecha;
    private int codigo;
    private List<Linea> carrito;

    public Factura(String ID, String fecha, int codigo) {
        this.ID = ID;
        this.fecha = fecha;
        this.codigo = codigo;
        carrito = new ArrayList<>();
    }


    public String getID() {
        return ID;
    }
    public void setID(String ID) {
        this.ID = ID;
    }
    public String getFecha() {
        return fecha;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public List<Linea> getCarrito() {
        return carrito;
    }

    void agregar(Linea obj){
        carrito.add(obj);
    }

    public double totalFactura(){
        double total = 0.0;
        for (Linea linea : carrito) {
            total += linea.getImporte();
        }
        return total;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "ID='" + ID + '\'' +
                ", fecha='" + fecha + '\'' +
                ", codigo=" + codigo +
                ", carrito=" + carrito +
                '}';
    }
}
