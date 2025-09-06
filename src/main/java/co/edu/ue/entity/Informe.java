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

	@Column(name="tipo_informe")
	private String tipoInforme;

	@Temporal(TemporalType.DATE)
	@Column(name="inicio_periodo")
	private Date inicioPeriodo;

	@Temporal(TemporalType.DATE)
	@Column(name="fin_periodo")
	private Date finPeriodo;

	@Column(name="datos_json")
	private String datosJson;

	@Column(name="crceado")
	private Timestamp creado;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	private Usuario usuario;

	public Informe() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipoInforme() {
		return tipoInforme;
	}

	public void setTipoInforme(String tipoInforme) {
		this.tipoInforme = tipoInforme;
	}

	public Date getInicioPeriodo() {
		return inicioPeriodo;
	}

	public void setInicioPeriodo(Date inicioPeriodo) {
		this.inicioPeriodo = inicioPeriodo;
	}

	public Date getFinPeriodo() {
		return finPeriodo;
	}

	public void setFinPeriodo(Date finPeriodo) {
		this.finPeriodo = finPeriodo;
	}

	public Object getDatosJson() {
		return datosJson;
	}

	public void setDatosJson(String datosJson) {
		this.datosJson = datosJson;
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