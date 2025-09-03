package co.edu.ue.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.sql.Timestamp;


/**
 * The persistent class for the metricas_sostenibilidad database table.
 * 
 */
@Entity
@Table(name="metricas_sostenibilidad")
@NamedQuery(name="MetricasSostenibilidad.findAll", query="SELECT m FROM MetricasSostenibilidad m")
public class MetricasSostenibilidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private Timestamp creado;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_medicion")
	private Date fechaMedicion;

	@Column(name="porcentaje_mejora")
	private BigDecimal porcentajeMejora;

	@Column(name="tipo_metrica")
	private String tipoMetrica;

	private String unidad;

	private BigDecimal valor;

	@Column(name="valor_objetivo")
	private BigDecimal valorObjetivo;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	private Usuario usuario;

	public MetricasSostenibilidad() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Timestamp getCreado() {
		return this.creado;
	}

	public void setCreado(Timestamp creado) {
		this.creado = creado;
	}

	public Date getFechaMedicion() {
		return this.fechaMedicion;
	}

	public void setFechaMedicion(Date fechaMedicion) {
		this.fechaMedicion = fechaMedicion;
	}

	public BigDecimal getPorcentajeMejora() {
		return this.porcentajeMejora;
	}

	public void setPorcentajeMejora(BigDecimal porcentajeMejora) {
		this.porcentajeMejora = porcentajeMejora;
	}

	public String getTipoMetrica() {
		return this.tipoMetrica;
	}

	public void setTipoMetrica(String tipoMetrica) {
		this.tipoMetrica = tipoMetrica;
	}

	public String getUnidad() {
		return this.unidad;
	}

	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}

	public BigDecimal getValor() {
		return this.valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public BigDecimal getValorObjetivo() {
		return this.valorObjetivo;
	}

	public void setValorObjetivo(BigDecimal valorObjetivo) {
		this.valorObjetivo = valorObjetivo;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}