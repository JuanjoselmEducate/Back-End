package co.edu.ue.services.business_logic.createI;

public class ProductoCreate {
    private String nombre;
    private String descripcion;
    private Integer precioUnitario;
    private Integer costoPorUnidad;
    private String sku;
    private Integer categoria_id;
    private Integer usuario_id;

    public ProductoCreate(String nombre, String descripcion, Integer precioUnitario, Integer costoPorUnidad, String sku,  Integer categoria_id, Integer usuario_id) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioUnitario = precioUnitario;
        this.costoPorUnidad = costoPorUnidad;
        this.sku = sku;
        this.categoria_id = categoria_id;
        this.usuario_id = usuario_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Integer precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public Integer getCostoPorUnidad() {
        return costoPorUnidad;
    }

    public void setCostoPorUnidad(Integer costoPorUnidad) {
        this.costoPorUnidad = costoPorUnidad;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }


    public Integer getCategoria_id() {
        return categoria_id;
    }

    public void setCategoria_id(Integer categoria_id) {
        this.categoria_id = categoria_id;
    }

    public Integer getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(Integer usuario_id) {
        this.usuario_id = usuario_id;
    }
}
