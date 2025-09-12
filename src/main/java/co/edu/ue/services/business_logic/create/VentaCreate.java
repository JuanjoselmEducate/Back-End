package co.edu.ue.services.business_logic.create;

import java.math.BigDecimal;
import java.util.Date;

public class VentaCreate {

    private Integer cantidad;
    private BigDecimal precioUnitario;
    private BigDecimal montoTotal;
    private Date fechaVenta;
    private String nombreCliente;
    private String notas;
    private Integer usuarioId;
    private Integer productoId;

    public VentaCreate(Integer cantidad, BigDecimal precioUnitario, BigDecimal montoTotal, Date fechaVenta, String nombreCliente, String notas, Integer usuarioId, Integer productoId) {
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.montoTotal = montoTotal;
        this.fechaVenta = fechaVenta;
        this.nombreCliente = nombreCliente;
        this.notas = notas;
        this.usuarioId = usuarioId;
        this.productoId = productoId;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(BigDecimal precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public BigDecimal getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(BigDecimal montoTotal) {
        this.montoTotal = montoTotal;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Integer getProductoId() {
        return productoId;
    }

    public void setProductoId(Integer productoId) {
        this.productoId = productoId;
    }
}
