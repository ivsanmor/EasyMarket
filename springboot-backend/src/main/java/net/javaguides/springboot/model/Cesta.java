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
import net.javaguides.springboot.security.entity.Usuario;

@Data
@Entity
@Table(name = "cesta")
public class Cesta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "precio_total")
	private Double precioTotal;

	@Column(name = "observaciones")
	private String observaciones;

	@Column(name = "cancelar")
	private boolean cancelar;
	
	@Column(name = "activo")
	private boolean activo;

	@ManyToOne
	@JoinColumn(name = "usuario_id")
	Usuario usuario;

	@OneToMany(mappedBy = "cesta", cascade = CascadeType.ALL)
	private Set<CestaProducto> cestaProducto = new HashSet<>();


	
}
