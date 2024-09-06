package pos.logic;

import java.util.ArrayList;
import java.util.List;

public class Factura {
    private String ID;
    private String fecha;
    private String codigo;
    private final List<Linea> carrito;

    public Factura() {
       carrito = new ArrayList<>();
        ID = " ";
        fecha = " ";
        codigo = " ";
    }

    public Factura(String ID, String fecha, String codigo) {
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

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {this.codigo = codigo;}

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
                ", Fecha='" + fecha + '\'' +
                ", Codigo=" + codigo +
                '}';
    }

    public void stringFractura(){
        toString();
        for(Linea linea : carrito){
            System.out.println(linea.toString());
        }
        System.out.println("Total: " +totalFactura());
    }
}