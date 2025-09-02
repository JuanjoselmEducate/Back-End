package co.edu.ue.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import java.math.BigDecimal;
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

	private String categoria;

	private String descripcion;

	@Column(name="nombre_producto")
	private String nombreProducto;

	@Column(name="precio_unitario")
	private BigDecimal precioUnitario;

	//bi-directional many-to-one association to Prediccione
	@OneToMany(mappedBy="producto")
	private List<Prediccione> predicciones;

	//bi-directional many-to-one association to Produccion
	@OneToMany(mappedBy="producto")
	private List<Produccion> produccions;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="id_usuario")
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

	public String getCategoria() {
		return this.categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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