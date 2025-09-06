package co.edu.ue.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.sql.Timestamp;


/**
 * The persistent class for the produccion database table.
 * 
 */
@Entity
@NamedQuery(name="Produccion.findAll", query="SELECT p FROM Produccion p")
public class Produccion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="cantidad_producida")
	private int cantidadProducida;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_produccion")
	private Date fechaProduccion;

	@Column(name="costo_produccion")
	private BigDecimal costoProduccion;

	@Column(name="cantidad_desperdicio")
	private int cantidadDesperdicio;

	@Column(name="costo_desperdicio")
	private BigDecimal costoDesperdicio;

	@Column(name="porcentaje_eficiencia")
	private BigDecimal porcentajeEficiencia;

	@Column(name="notas")
	@Lob
	private String notas;

	@Column(name="creado")
	private Timestamp creado;

	//bi-directional many-to-one association to Producto
	@ManyToOne
	private Producto producto;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	private Usuario usuario;

	public Produccion() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCantidadProducida() {
		return cantidadProducida;
	}

	public void setCantidadProducida(int cantidadProducida) {
		this.cantidadProducida = cantidadProducida;
	}

	public int getCantidadDesperdicio() {
		return cantidadDesperdicio;
	}

	public void setCantidadDesperdicio(int cantidadDesperdicio) {
		this.cantidadDesperdicio = cantidadDesperdicio;
	}

	public BigDecimal getCostoDesperdicio() {
		return this.costoDesperdicio;
	}

	public void setCostoDesperdicio(BigDecimal costoDesperdicio) {
		this.costoDesperdicio = costoDesperdicio;
	}

	public BigDecimal getCostoProduccion() {
		return this.costoProduccion;
	}

	public void setCostoProduccion(BigDecimal costoProduccion) {
		this.costoProduccion = costoProduccion;
	}

	public Timestamp getCreado() {
		return this.creado;
	}

	public void setCreado(Timestamp creado) {
		this.creado = creado;
	}

	public Date getFechaProduccion() {
		return this.fechaProduccion;
	}

	public void setFechaProduccion(Date fechaProduccion) {
		this.fechaProduccion = fechaProduccion;
	}

	public String getNotas() {
		return this.notas;
	}

	public void setNotas(String notas) {
		this.notas = notas;
	}

	public BigDecimal getPorcentajeEficiencia() {
		return this.porcentajeEficiencia;
	}

	public void setPorcentajeEficiencia(BigDecimal porcentajeEficiencia) {
		this.porcentajeEficiencia = porcentajeEficiencia;
	}

	public Producto getProducto() {
		return this.producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}