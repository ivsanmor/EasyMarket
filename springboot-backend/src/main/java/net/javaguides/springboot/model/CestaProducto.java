package net.javaguides.springboot.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "cesta_producto")
public class CestaProducto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "cesta_id")
	private Cesta cesta;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "producto_id")
	private Producto producto;

	@Column(name = "cantidad")
	private Integer cantidad;


	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof CestaProducto))
			return false;
		CestaProducto that = (CestaProducto) o;
		return Objects.equals(cesta.getId(), that.cesta.getId())
				&& Objects.equals(producto.getNombre(), that.producto.getNombre())
				&& Objects.equals(cantidad, that.cantidad);
	}

	@Override
	public int hashCode() {
		return Objects.hash(cesta.getId(), producto.getNombre(), cantidad);
	}
}
