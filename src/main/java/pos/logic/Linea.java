package pos.logic;

public class Linea {
    private Producto producto;
    private int cantidad;
    private double descuento;
    private double importe;

    public Linea(Producto producto, int cantidad, double descuento) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.descuento = descuento;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public double getImporte() {
        return importe;
    }

    public double sacarImporte(){
        double neto = producto.getPrecioUnitario() * getDescuento();
        return cantidad * neto;
    }

    public String toString() {
        return producto.getCodigo() + " " + producto.getDescripcion() + " " + cantidad + " " +
                producto.getPrecioUnitario() + " " + sacarImporte();
    }

}