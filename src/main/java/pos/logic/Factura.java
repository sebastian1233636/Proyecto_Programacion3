package pos.logic;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;

import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class Factura {
    private String ID;
    private String fecha;
    private String codigo;
    private final List<Linea> carrito;

    public Factura() {
        carrito = new ArrayList<>();
        ID = "";
        fecha = "";
        codigo = "";
    }

    public Factura(String ID, String fecha, String codigo, List<Linea> lineas) {
        this.ID = ID;
        this.fecha = fecha;
        this.codigo = codigo;
        this.carrito = new ArrayList<>(lineas);
    }

    public String getID() {return ID;}
    public String getFecha() {return fecha;}
    public String getCodigo() {return codigo;}
    public List<Linea> getCarrito() {return carrito;}

    public void setID(String ID) {this.ID = ID;}
    public void setFecha(String fecha) {this.fecha = fecha;}
    public void setCodigo(String codigo) {this.codigo = codigo;}


    public void agregar(Linea obj) {carrito.add(obj);}

    public double totalFactura() {
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
                ", Codigo='" + codigo + '\'' +
                '}';
    }

    public void stringFactura() {
        System.out.println(toString());
        for (Linea linea : carrito) {
            System.out.println(linea.toString());
        }
        System.out.println("Total: " + totalFactura());
    }
}