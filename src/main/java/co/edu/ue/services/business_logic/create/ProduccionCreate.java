package co.edu.ue.services.business_logic.create;


import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

public class ProduccionCreate {
    private Integer cantidadProducida;
    private Date fechaProduccion;
    private BigDecimal costoProduccion;
    private Integer cantidadDesperdicio;
    private BigDecimal costoDesperdicio;
    private BigDecimal porcentajeEficiencia;
    private String notas;
    private Integer productoId;
    private Integer usuarioId;

    public ProduccionCreate(Integer cantidadProducida, Date fechaProduccion, BigDecimal costoProduccion, Integer cantidadDesperdicio, BigDecimal costoDesperdicio, BigDecimal porcentajeEficiencia, String notas, Integer productoId, Integer usuarioId) {
        this.cantidadProducida = cantidadProducida;
        this.fechaProduccion = fechaProduccion;
        this.costoProduccion = costoProduccion;
        this.cantidadDesperdicio = cantidadDesperdicio;
        this.costoDesperdicio = costoDesperdicio;
        this.porcentajeEficiencia = porcentajeEficiencia;
        this.notas = notas;
        this.productoId = productoId;
        this.usuarioId = usuarioId;
    }

    public Integer getCantidadProducida() {
        return cantidadProducida;
    }

    public void setCantidadProducida(Integer cantidadProducida) {
        this.cantidadProducida = cantidadProducida;
    }

    public Date getFechaProduccion() {
        return fechaProduccion;
    }

    public void setFechaProduccion(Date fechaProduccion) {
        this.fechaProduccion = fechaProduccion;
    }

    public BigDecimal getCostoProduccion() {
        return costoProduccion;
    }

    public void setCostoProduccion(BigDecimal costoProduccion) {
        this.costoProduccion = costoProduccion;
    }

    public Integer getCantidadDesperdicio() {
        return cantidadDesperdicio;
    }

    public void setCantidadDesperdicio(Integer cantidadDesperdicio) {
        this.cantidadDesperdicio = cantidadDesperdicio;
    }

    public BigDecimal getCostoDesperdicio() {
        return costoDesperdicio;
    }

    public void setCostoDesperdicio(BigDecimal costoDesperdicio) {
        this.costoDesperdicio = costoDesperdicio;
    }

    public BigDecimal getPorcentajeEficiencia() {
        return porcentajeEficiencia;
    }

    public void setPorcentajeEficiencia(BigDecimal porcentajeEficiencia) {
        this.porcentajeEficiencia = porcentajeEficiencia;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }


    public Integer getProductoId() {
        return productoId;
    }

    public void setProductoId(Integer productoId) {
        this.productoId = productoId;
    }

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }
}

