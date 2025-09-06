package co.edu.ue.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.sql.Timestamp;


/**
 * The persistent class for the gastos database table.
 * 
 */
@Entity
@Table(name="gastos")
@NamedQuery(name="Gasto.findAll", query="SELECT g FROM Gasto g")
public class Gasto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="desccripcion")
	private String descripcion;

	@Column(name="monto")
	private BigDecimal monto;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_gasto")
	private Date fechaGasto;

	@Column(name="tipo_gasto")
	private String tipoGasto;
	
	@Column(name="notas")
	@Lob
	private String notas;

	@Column(name="creado")
	private Timestamp creado;

	//bi-directional many-to-one association to Categoria
	@ManyToOne
	private Categoria categoria;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	private Usuario usuario;

	public Gasto() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public BigDecimal getMonto() {
		return monto;
	}

	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}

	public Date getFechaGasto() {
		return fechaGasto;
	}

	public void setFechaGasto(Date fechaGasto) {
		this.fechaGasto = fechaGasto;
	}

	public String getTipoGasto() {
		return tipoGasto;
	}

	public void setTipoGasto(String tipoGasto) {
		this.tipoGasto = tipoGasto;
	}

	public String getNotas() {
		return notas;
	}

	public void setNotas(String notas) {
		this.notas = notas;
	}

	public Timestamp getCreado() {
		return creado;
	}

	public void setCreado(Timestamp creado) {
		this.creado = creado;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}