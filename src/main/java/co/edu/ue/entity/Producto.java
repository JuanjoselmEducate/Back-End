package co.edu.ue.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the productos database table.
 * 
 */
@Entity
@Table(name="productos")
@NamedQuery(name="Producto.findAll", query="SELECT p FROM Producto p")
public class Producto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private Timestamp actualizado;

	@Column(name="costo_por_unidad")
	private BigDecimal costoPorUnidad;

	private Timestamp creado;

	@Lob
	private String descripcion;

	private byte estado;

	@Column(name="nombre_producto")
	private String nombreProducto;

	@Column(name="precio_unitario")
	private BigDecimal precioUnitario;

	private String sku;

	//bi-directional many-to-one association to Prediccione
	@OneToMany(mappedBy="producto")
	private List<Prediccione> predicciones;

	//bi-directional many-to-one association to Produccion
	@OneToMany(mappedBy="producto")
	private List<Produccion> produccions;

	//bi-directional many-to-one association to Categoria
	@ManyToOne
	private Categoria categoria;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	private Usuario usuario;

	//bi-directional many-to-one association to Venta
	@OneToMany(mappedBy="producto")
	private List<Venta> ventas;

	public Producto() {
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

	public BigDecimal getCostoPorUnidad() {
		return this.costoPorUnidad;
	}

	public void setCostoPorUnidad(BigDecimal costoPorUnidad) {
		this.costoPorUnidad = costoPorUnidad;
	}

	public Timestamp getCreado() {
		return this.creado;
	}

	public void setCreado(Timestamp creado) {
		this.creado = creado;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public byte getEstado() {
		return this.estado;
	}

	public void setEstado(byte estado) {
		this.estado = estado;
	}

	public String getNombreProducto() {
		return this.nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public BigDecimal getPrecioUnitario() {
		return this.precioUnitario;
	}

	public void setPrecioUnitario(BigDecimal precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public String getSku() {
		return this.sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public List<Prediccione> getPredicciones() {
		return this.predicciones;
	}

	public void setPredicciones(List<Prediccione> predicciones) {
		this.predicciones = predicciones;
	}

	public Prediccione addPrediccione(Prediccione prediccione) {
		getPredicciones().add(prediccione);
		prediccione.setProducto(this);

		return prediccione;
	}

	public Prediccione removePrediccione(Prediccione prediccione) {
		getPredicciones().remove(prediccione);
		prediccione.setProducto(null);

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
		produccion.setProducto(this);

		return produccion;
	}

	public Produccion removeProduccion(Produccion produccion) {
		getProduccions().remove(produccion);
		produccion.setProducto(null);

		return produccion;
	}

	public Categoria getCategoria() {
		return this.categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Venta> getVentas() {
		return this.ventas;
	}

	public void setVentas(List<Venta> ventas) {
		this.ventas = ventas;
	}

	public Venta addVenta(Venta venta) {
		getVentas().add(venta);
		venta.setProducto(this);

		return venta;
	}

	public Venta removeVenta(Venta venta) {
		getVentas().remove(venta);
		venta.setProducto(null);

		return venta;
	}

}