package co.edu.ue.services.business_logic.create;

public class CategoriaCreate {
    private String nombre;
    private String descripcion;
    private String tipo;
    private Integer usuario_Id;

    public CategoriaCreate(String nombre, String descripcion, String tipo, Integer usuario_Id) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.usuario_Id = usuario_Id;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getUsuario_Id() {
        return usuario_Id;
    }

    public void setUsuario_Id(Integer usuario_Id) {
        this.usuario_Id = usuario_Id;
    }
}
