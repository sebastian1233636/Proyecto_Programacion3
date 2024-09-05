package pos.logic;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class Producto {
    private String codigo;
    private String descripcion;
    private String unidadMedida;
    private double precioUnitario;
    private int existencias;
    private String nomCat;
    private Categoria categoria;

    public Producto(String cod,String des,String UniMe,double precio,int exis,String nomC){
        this.codigo=cod;
        this.descripcion=des;
        this.unidadMedida=UniMe;
        this.precioUnitario=precio;
        this.existencias=exis;
        this.nomCat=nomC;
        this.categoria = new Categoria(nomC);
    }

    public Producto() {this("","","",0,0,"");}

    public String getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public int getExistencias() {
        return existencias;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public String getNomCat(){
        return nomCat;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public void setPrecioUnitario(double precioUnitario) { this.precioUnitario = precioUnitario; }

    public void setExistencias(int existencias) {
        this.existencias = existencias;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public void setNomCat(String nom){
        this.nomCat = nom;
    }

    public String toString() {
        return "Producto{" +
                "Codigo='" + codigo + '\'' +
                ", Descripcion='" + descripcion + '\'' +
                ", UnidadMedida='" + unidadMedida + '\'' +
                ", PrecioUnitario=" + precioUnitario +
                ", Existencias=" + existencias +
                ", Categoria='" + categoria + '\'' +
                '}';
    }
}