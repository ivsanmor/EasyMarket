package net.javaguides.springboot.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Entity
@Table(name = "producto")
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nombre", nullable = false)
	private String nombre;

	@Column(name = "cantidad")
	private Integer cantidad;

	@Column(name = "precio")
	private Double precio;

	@Column(name = "descripcion")
	private String descripcion;

	@Column(name = "imagen")
	private String imagen;

	@Column(name = "activo")
	private boolean activo;

	@ManyToOne
	@JoinColumn(name = "categoria_id")
	private Categoria categoria;

	@ManyToOne
	@JoinColumn(name = "oferta_id")
	private Oferta oferta;

	@OneToMany(mappedBy = "producto", cascade = CascadeType.ALL)
	private Set<CestaProducto> productoCesta = new HashSet<>();

	
	
}
