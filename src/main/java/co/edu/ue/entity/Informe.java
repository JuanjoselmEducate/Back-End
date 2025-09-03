package co.edu.ue.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.Date;
import java.sql.Timestamp;


/**
 * The persistent class for the informes database table.
 * 
 */
@Entity
@Table(name="informes")
@NamedQuery(name="Informe.findAll", query="SELECT i FROM Informe i")
public class Informe implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private Timestamp creado;

	@Column(name="datos_json")
	private Object datosJson;

	@Temporal(TemporalType.DATE)
	@Column(name="fin_periodo")
	private Date finPeriodo;

	@Temporal(TemporalType.DATE)
	@Column(name="inicio_periodo")
	private Date inicioPeriodo;

	@Column(name="tipo_informe")
	private String tipoInforme;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	private Usuario usuario;

	public Informe() {
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

	public Object getDatosJson() {
		return this.datosJson;
	}

	public void setDatosJson(Object datosJson) {
		this.datosJson = datosJson;
	}

	public Date getFinPeriodo() {
		return this.finPeriodo;
	}

	public void setFinPeriodo(Date finPeriodo) {
		this.finPeriodo = finPeriodo;
	}

	public Date getInicioPeriodo() {
		return this.inicioPeriodo;
	}

	public void setInicioPeriodo(Date inicioPeriodo) {
		this.inicioPeriodo = inicioPeriodo;
	}

	public String getTipoInforme() {
		return this.tipoInforme;
	}

	public void setTipoInforme(String tipoInforme) {
		this.tipoInforme = tipoInforme;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}