package co.edu.ue.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


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

	private BigDecimal confianza;

	@Column(name="demanda_esperada")
	private int demandaEsperada;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	private String periodo;

	private BigDecimal tendencia;

	//bi-directional many-to-one association to Producto
	@ManyToOne
	@JoinColumn(name="id_producto")
	private Producto producto;

	public Prediccione() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BigDecimal getConfianza() {
		return this.confianza;
	}

	public void setConfianza(BigDecimal confianza) {
		this.confianza = confianza;
	}

	public int getDemandaEsperada() {
		return this.demandaEsperada;
	}

	public void setDemandaEsperada(int demandaEsperada) {
		this.demandaEsperada = demandaEsperada;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getPeriodo() {
		return this.periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public BigDecimal getTendencia() {
		return this.tendencia;
	}

	public void setTendencia(BigDecimal tendencia) {
		this.tendencia = tendencia;
	}

	public Producto getProducto() {
		return this.producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

}