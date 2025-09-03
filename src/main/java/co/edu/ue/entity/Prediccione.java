package co.edu.ue.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.sql.Timestamp;


/**
 * The persistent class for the predicciones database table.
 * 
 */
@Entity
@Table(name="predicciones")
@NamedQuery(name="Prediccione.findAll", query="SELECT p FROM Prediccione p")
public class Prediccione implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="algoritmo_usado")
	private String algoritmoUsado;

	private Timestamp creado;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_prediccion")
	private Date fechaPrediccion;

	@Column(name="nivel_confianza")
	private BigDecimal nivelConfianza;

	@Column(name="periodo_objetivo")
	private String periodoObjetivo;

	private BigDecimal tendencia;

	@Column(name="tipo_prediccion")
	private String tipoPrediccion;

	@Column(name="valor_predicho")
	private BigDecimal valorPredicho;

	//bi-directional many-to-one association to Producto
	@ManyToOne
	private Producto producto;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	private Usuario usuario;

	public Prediccione() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAlgoritmoUsado() {
		return this.algoritmoUsado;
	}

	public void setAlgoritmoUsado(String algoritmoUsado) {
		this.algoritmoUsado = algoritmoUsado;
	}

	public Timestamp getCreado() {
		return this.creado;
	}

	public void setCreado(Timestamp creado) {
		this.creado = creado;
	}

	public Date getFechaPrediccion() {
		return this.fechaPrediccion;
	}

	public void setFechaPrediccion(Date fechaPrediccion) {
		this.fechaPrediccion = fechaPrediccion;
	}

	public BigDecimal getNivelConfianza() {
		return this.nivelConfianza;
	}

	public void setNivelConfianza(BigDecimal nivelConfianza) {
		this.nivelConfianza = nivelConfianza;
	}

	public String getPeriodoObjetivo() {
		return this.periodoObjetivo;
	}

	public void setPeriodoObjetivo(String periodoObjetivo) {
		this.periodoObjetivo = periodoObjetivo;
	}

	public BigDecimal getTendencia() {
		return this.tendencia;
	}

	public void setTendencia(BigDecimal tendencia) {
		this.tendencia = tendencia;
	}

	public String getTipoPrediccion() {
		return this.tipoPrediccion;
	}

	public void setTipoPrediccion(String tipoPrediccion) {
		this.tipoPrediccion = tipoPrediccion;
	}

	public BigDecimal getValorPredicho() {
		return this.valorPredicho;
	}

	public void setValorPredicho(BigDecimal valorPredicho) {
		this.valorPredicho = valorPredicho;
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