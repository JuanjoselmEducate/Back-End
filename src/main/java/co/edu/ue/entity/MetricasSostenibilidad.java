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

	@Column(name="tipo_metrica")
	private String tipoMetrica;

	@Column(name="valor")
	private BigDecimal valor;

	@Column(name="unidad")
	private String unidad;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_medicion")
	private Date fechaMedicion;

	@Column(name="valor_objetivo")
	private BigDecimal valorObjetivo;

	@Column(name="porcentaje_mejora")
	private BigDecimal porcentajeMejora;

	@Column(name="creado")
	private Timestamp creado;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	private Usuario usuario;

	public MetricasSostenibilidad() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipoMetrica() {
		return tipoMetrica;
	}

	public void setTipoMetrica(String tipoMetrica) {
		this.tipoMetrica = tipoMetrica;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public String getUnidad() {
		return unidad;
	}

	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}

	public Date getFechaMedicion() {
		return fechaMedicion;
	}

	public void setFechaMedicion(Date fechaMedicion) {
		this.fechaMedicion = fechaMedicion;
	}

	public BigDecimal getValorObjetivo() {
		return valorObjetivo;
	}

	public void setValorObjetivo(BigDecimal valorObjetivo) {
		this.valorObjetivo = valorObjetivo;
	}

	public BigDecimal getPorcentajeMejora() {
		return porcentajeMejora;
	}

	public void setPorcentajeMejora(BigDecimal porcentajeMejora) {
		this.porcentajeMejora = porcentajeMejora;
	}

	public Timestamp getCreado() {
		return creado;
	}

	public void setCreado(Timestamp creado) {
		this.creado = creado;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
}