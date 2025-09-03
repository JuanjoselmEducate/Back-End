package co.edu.ue.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import java.sql.Timestamp;
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
	private int id;

	private Timestamp actualizado;

	private String apellidos;

	@Column(name="contrasena_hash")
	private String contrasenaHash;

	private Timestamp creado;

	@Lob
	private String direccion;

	private String documento;

	private String email;

	private byte estado;

	@Column(name="nombre_empresa")
	private String nombreEmpresa;

	@Column(name="primer_nombre")
	private String primerNombre;

	@Column(name="segundo_nombre")
	private String segundoNombre;

	private String telefono;

	@Column(name="tipo_negocio")
	private String tipoNegocio;

	//bi-directional many-to-one association to Categoria
	@OneToMany(mappedBy="usuario")
	private List<Categoria> categorias;

	//bi-directional many-to-one association to Gasto
	@OneToMany(mappedBy="usuario")
	private List<Gasto> gastos;

	//bi-directional many-to-one association to Informe
	@OneToMany(mappedBy="usuario")
	private List<Informe> informes;

	//bi-directional many-to-one association to MetricasSostenibilidad
	@OneToMany(mappedBy="usuario")
	private List<MetricasSostenibilidad> metricasSostenibilidads;

	//bi-directional many-to-one association to Prediccione
	@OneToMany(mappedBy="usuario")
	private List<Prediccione> predicciones;

	//bi-directional many-to-one association to Produccion
	@OneToMany(mappedBy="usuario")
	private List<Produccion> produccions;

	//bi-directional many-to-one association to Producto
	@OneToMany(mappedBy="usuario")
	private List<Producto> productos;

	//bi-directional many-to-one association to Venta
	@OneToMany(mappedBy="usuario")
	private List<Venta> ventas;

	public Usuario() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Timestamp getActualizado() {
		return this.actualizado;
	}

	public void setActualizado(Timestamp actualizado) {
		this.actualizado = actualizado;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getContrasenaHash() {
		return this.contrasenaHash;
	}

	public void setContrasenaHash(String contrasenaHash) {
		this.contrasenaHash = contrasenaHash;
	}

	public Timestamp getCreado() {
		return this.creado;
	}

	public void setCreado(Timestamp creado) {
		this.creado = creado;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getDocumento() {
		return this.documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public byte getEstado() {
		return this.estado;
	}

	public void setEstado(byte estado) {
		this.estado = estado;
	}

	public String getNombreEmpresa() {
		return this.nombreEmpresa;
	}

	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}

	public String getPrimerNombre() {
		return this.primerNombre;
	}

	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}

	public String getSegundoNombre() {
		return this.segundoNombre;
	}

	public void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getTipoNegocio() {
		return this.tipoNegocio;
	}

	public void setTipoNegocio(String tipoNegocio) {
		this.tipoNegocio = tipoNegocio;
	}

	public List<Categoria> getCategorias() {
		return this.categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	public Categoria addCategoria(Categoria categoria) {
		getCategorias().add(categoria);
		categoria.setUsuario(this);

		return categoria;
	}

	public Categoria removeCategoria(Categoria categoria) {
		getCategorias().remove(categoria);
		categoria.setUsuario(null);

		return categoria;
	}

	public List<Gasto> getGastos() {
		return this.gastos;
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

	public List<Informe> getInformes() {
		return this.informes;
	}

	public void setInformes(List<Informe> informes) {
		this.informes = informes;
	}

	public Informe addInforme(Informe informe) {
		getInformes().add(informe);
		informe.setUsuario(this);

		return informe;
	}

	public Informe removeInforme(Informe informe) {
		getInformes().remove(informe);
		informe.setUsuario(null);

		return informe;
	}

	public List<MetricasSostenibilidad> getMetricasSostenibilidads() {
		return this.metricasSostenibilidads;
	}

	public void setMetricasSostenibilidads(List<MetricasSostenibilidad> metricasSostenibilidads) {
		this.metricasSostenibilidads = metricasSostenibilidads;
	}

	public MetricasSostenibilidad addMetricasSostenibilidad(MetricasSostenibilidad metricasSostenibilidad) {
		getMetricasSostenibilidads().add(metricasSostenibilidad);
		metricasSostenibilidad.setUsuario(this);

		return metricasSostenibilidad;
	}

	public MetricasSostenibilidad removeMetricasSostenibilidad(MetricasSostenibilidad metricasSostenibilidad) {
		getMetricasSostenibilidads().remove(metricasSostenibilidad);
		metricasSostenibilidad.setUsuario(null);

		return metricasSostenibilidad;
	}

	public List<Prediccione> getPredicciones() {
		return this.predicciones;
	}

	public void setPredicciones(List<Prediccione> predicciones) {
		this.predicciones = predicciones;
	}

	public Prediccione addPrediccione(Prediccione prediccione) {
		getPredicciones().add(prediccione);
		prediccione.setUsuario(this);

		return prediccione;
	}

	public Prediccione removePrediccione(Prediccione prediccione) {
		getPredicciones().remove(prediccione);
		prediccione.setUsuario(null);

		return prediccione;
	}

	public List<Produccion> getProduccions() {
		return this.produccions;
	}

	public void setProduccions(List<Produccion> produccions) {
		this.produccions = produccions;
	}

	public Produccion addProduccion(Produccion produccion) {
		getProduccions().add(produccion);
		produccion.setUsuario(this);

		return produccion;
	}

	public Produccion removeProduccion(Produccion produccion) {
		getProduccions().remove(produccion);
		produccion.setUsuario(null);

		return produccion;
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

	public List<Venta> getVentas() {
		return this.ventas;
	}

	public void setVentas(List<Venta> ventas) {
		this.ventas = ventas;
	}

	public Venta addVenta(Venta venta) {
		getVentas().add(venta);
		venta.setUsuario(this);

		return venta;
	}

	public Venta removeVenta(Venta venta) {
		getVentas().remove(venta);
		venta.setUsuario(null);

		return venta;
	}

}