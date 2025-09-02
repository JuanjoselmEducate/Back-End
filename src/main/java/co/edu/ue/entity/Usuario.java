package co.edu.ue.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the usuarios database table.
 * 
 */
@Entity
@Table(name="usuarios")
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	@Column(name = "contrasena")
	private String contrasena;

	@Column(name = "correo")
	private String correo;

	@Column(name = "nombre")
	private String nombre;

	//bi-directional many-to-one association to Gasto
	@OneToMany(mappedBy="usuario")
	private List<Gasto> gastos;

	//bi-directional many-to-one association to ImpactoSostenible
	@OneToMany(mappedBy="usuario")
	private List<ImpactoSostenible> impactoSostenibles;

	//bi-directional many-to-one association to Producto
	@OneToMany(mappedBy="usuario")
	private List<Producto> productos;

	//bi-directional many-to-one association to ReportesFinanciero
	@OneToMany(mappedBy="usuario")
	private List<ReportesFinanciero> reportesFinancieros;

	public Usuario() {
	}
	
	
	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getContrasena() {
		return contrasena;
	}



	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}



	public String getCorreo() {
		return correo;
	}



	public void setCorreo(String correo) {
		this.correo = correo;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public List<Gasto> getGastos() {
		return gastos;
	}



	public void setGastos(List<Gasto> gastos) {
		this.gastos = gastos;
	}



	public Gasto addGasto(Gasto gasto) {
		getGastos().add(gasto);
		gasto.setUsuario(this);

		return gasto;
	}

	public Gasto removeGasto(Gasto gasto) {
		getGastos().remove(gasto);
		gasto.setUsuario(null);

		return gasto;
	}

	public List<ImpactoSostenible> getImpactoSostenibles() {
		return this.impactoSostenibles;
	}

	public void setImpactoSostenibles(List<ImpactoSostenible> impactoSostenibles) {
		this.impactoSostenibles = impactoSostenibles;
	}

	public ImpactoSostenible addImpactoSostenible(ImpactoSostenible impactoSostenible) {
		getImpactoSostenibles().add(impactoSostenible);
		impactoSostenible.setUsuario(this);

		return impactoSostenible;
	}

	public ImpactoSostenible removeImpactoSostenible(ImpactoSostenible impactoSostenible) {
		getImpactoSostenibles().remove(impactoSostenible);
		impactoSostenible.setUsuario(null);

		return impactoSostenible;
	}

	public List<Producto> getProductos() {
		return this.productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	public Producto addProducto(Producto producto) {
		getProductos().add(producto);
		producto.setUsuario(this);

		return producto;
	}

	public Producto removeProducto(Producto producto) {
		getProductos().remove(producto);
		producto.setUsuario(null);

		return producto;
	}

	public List<ReportesFinanciero> getReportesFinancieros() {
		return this.reportesFinancieros;
	}

	public void setReportesFinancieros(List<ReportesFinanciero> reportesFinancieros) {
		this.reportesFinancieros = reportesFinancieros;
	}

	public ReportesFinanciero addReportesFinanciero(ReportesFinanciero reportesFinanciero) {
		getReportesFinancieros().add(reportesFinanciero);
		reportesFinanciero.setUsuario(this);

		return reportesFinanciero;
	}

	public ReportesFinanciero removeReportesFinanciero(ReportesFinanciero reportesFinanciero) {
		getReportesFinancieros().remove(reportesFinanciero);
		reportesFinanciero.setUsuario(null);

		return reportesFinanciero;
	}

}