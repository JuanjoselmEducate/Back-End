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

	@Column(name="tipo_prediccion")
	private String tipoPrediccion;

	@Column(name="valor_predicho")
	private BigDecimal valorPredicho;

	@Column(name="nivel_confianza")
	private BigDecimal nivelConfianza;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_prediccion")
	private Date fechaPrediccion;

	@Column(name="periodo_objetivo")
	private String periodoObjetivo;

	@Column(name="algoritmo_usado")
	private String algoritmoUsado;

	@Column(name="tendenccia")
	private BigDecimal tendencia;

	@Column(name="creado")
	private Timestamp creado;

	//bi-directional many-to-one association to Producto
	@ManyToOne
	private Producto producto;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	private Usuario usuario;

	public Prediccione() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipoPrediccion() {
		return tipoPrediccion;
	}

	public void setTipoPrediccion(String tipoPrediccion) {
		this.tipoPrediccion = tipoPrediccion;
	}

	public BigDecimal getValorPredicho() {
		return valorPredicho;
	}

	public void setValorPredicho(BigDecimal valorPredicho) {
		this.valorPredicho = valorPredicho;
	}

	public BigDecimal getNivelConfianza() {
		return nivelConfianza;
	}

	public void setNivelConfianza(BigDecimal nivelConfianza) {
		this.nivelConfianza = nivelConfianza;
	}

	public Date getFechaPrediccion() {
		return fechaPrediccion;
	}

	public void setFechaPrediccion(Date fechaPrediccion) {
		this.fechaPrediccion = fechaPrediccion;
	}

	public String getPeriodoObjetivo() {
		return periodoObjetivo;
	}

	public void setPeriodoObjetivo(String periodoObjetivo) {
		this.periodoObjetivo = periodoObjetivo;
	}

	public String getAlgoritmoUsado() {
		return algoritmoUsado;
	}

	public void setAlgoritmoUsado(String algoritmoUsado) {
		this.algoritmoUsado = algoritmoUsado;
	}

	public BigDecimal getTendencia() {
		return tendencia;
	}

	public void setTendencia(BigDecimal tendencia) {
		this.tendencia = tendencia;
	}

	public Timestamp getCreado() {
		return creado;
	}

	public void setCreado(Timestamp creado) {
		this.creado = creado;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
}