package pos.logic;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import java.math.BigDecimal;
import java.math.RoundingMode;

@XmlAccessorType(XmlAccessType.FIELD)
public class Linea {
    private Producto producto;
    private int cantidad;
    private double descuento;
    private double importe;

    public Linea() {
        producto = new Producto();
        cantidad = 0;
        descuento = 0;
        importe = 0;
    }

    public Linea(Producto producto, int cantidad, double descuento) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.descuento = descuento;
    }

    public Producto getProducto() { return producto; }
    public int getCantidad() { return cantidad; }
    public double getDescuento() { return round(descuento, 2); }
    public double getImporte() { return round(sacarImporte(), 2 );}

    public void setProducto(Producto producto) { this.producto = producto; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }
    public void setDescuento(double descuento) { this.descuento = (descuento / 100) * producto.getPrecioUnitario(); }

    public double sacarImporte() {
        double neto = producto.getPrecioUnitario() - getDescuento();
        return cantidad * neto;
    }

    @Override
    public String toString() {
        return producto.getCodigo() + " " + producto.getDescripcion() + " " + cantidad + " " +
                producto.getPrecioUnitario() + " " + sacarImporte();
    }

    private double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();
        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
