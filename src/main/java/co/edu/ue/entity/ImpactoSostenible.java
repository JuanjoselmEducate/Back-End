package co.edu.ue.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the impacto_sostenible database table.
 * 
 */
@Entity
@Table(name="impacto_sostenible")
@NamedQuery(name="ImpactoSostenible.findAll", query="SELECT i FROM ImpactoSostenible i")
public class ImpactoSostenible implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="ahorro_energetico")
	private BigDecimal ahorroEnergetico;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;

	@Column(name="optimizacion_recursos")
	private BigDecimal optimizacionRecursos;

	@Column(name="reduccion_desperdicio")
	private BigDecimal reduccionDesperdicio;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="id_usuario")
	private Usuario usuario;

	public ImpactoSostenible() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BigDecimal getAhorroEnergetico() {
		return this.ahorroEnergetico;
	}

	public void setAhorroEnergetico(BigDecimal ahorroEnergetico) {
		this.ahorroEnergetico = ahorroEnergetico;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public BigDecimal getOptimizacionRecursos() {
		return this.optimizacionRecursos;
	}

	public void setOptimizacionRecursos(BigDecimal optimizacionRecursos) {
		this.optimizacionRecursos = optimizacionRecursos;
	}

	public BigDecimal getReduccionDesperdicio() {
		return this.reduccionDesperdicio;
	}

	public void setReduccionDesperdicio(BigDecimal reduccionDesperdicio) {
		this.reduccionDesperdicio = reduccionDesperdicio;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}