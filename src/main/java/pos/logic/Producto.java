package pos.logic;

public class Producto {
    private String codigo;
    private String descripcion;
    private String unidadMedida;
    private double precioUnitario;
    private int existencias;
    private String categoria;




    public Producto(String cod,String des,String UniMe,double precio,int exis,String cat){
        this.codigo=cod;
        this.descripcion=des;
        this.unidadMedida=UniMe;
        this.precioUnitario=precio;
        this.existencias=exis;
        this.categoria=cat;
    }

    String getCodigo() {
        return codigo;
    }
    String getDescripcion() {
        return descripcion;
    }
    String getUnidadMedida() {
        return unidadMedida;
    }
    double getPrecioUnitario() {
        return precioUnitario;
    }
    int getExistencias() {
        return existencias;
    }
    String getCategoria() {
        return categoria;
    }
    void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }
    void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }
    void setExistencias(int existencias) {
        this.existencias = existencias;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }



    public String toString() {
        return "Producto{" +
                "codigo='" + codigo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", unidadMedida='" + unidadMedida + '\'' +
                ", precioUnitario=" + precioUnitario +
                ", existencias=" + existencias +
                ", categoria='" + categoria + '\'' +
                '}';
    }

}
