package net.javaguides.springboot.security.entity;

import javax.persistence.*;

import lombok.NonNull;
import net.javaguides.springboot.security.enums.RolNombre;

// TODO: Auto-generated Javadoc
/**
 * The Class Rol.
 */
@Entity
public class Rol {
	
	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	/** The rol nombre. */
	@NonNull
	@Enumerated(EnumType.STRING)
	private RolNombre rolNombre;

	/**
	 * Instantiates a new rol.
	 */
	public Rol() {
	}

	/**
	 * Instantiates a new rol.
	 *
	 * @param rolNombre the rol nombre
	 */
	public Rol(@NonNull RolNombre rolNombre) {
		this.rolNombre = rolNombre;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Gets the rol nombre.
	 *
	 * @return the rol nombre
	 */
	public RolNombre getRolNombre() {
		return rolNombre;
	}

	/**
	 * Sets the rol nombre.
	 *
	 * @param rolNombre the new rol nombre
	 */
	public void setRolNombre(RolNombre rolNombre) {
		this.rolNombre = rolNombre;
	}
}