package net.javaguides.springboot.security.entity;

import javax.persistence.*;

import lombok.NonNull;
import net.javaguides.springboot.model.Cesta;
import net.javaguides.springboot.model.Producto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Entidad de usuario cuyos atributos serviran para almacenar
 * datos en la base de datos.
 * 
 * @author Ivan
 */
@Entity
@Table(name = "usuario")
public class Usuario {
	
	/** id autoincrementable de los usuario */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	/** nombre de los usuario */
	@NonNull
	private String nombre;
	
	/** nombre del usuario de los usuario */
	@NonNull
	@Column(unique = true)
	private String nombreUsuario;
	
	/** email de los usuario */
	@NonNull
	private String email;
	
	/** password de los usuario */
	@NonNull
	private String password;
	
	/** activo de los usuario */
	@Column(name = "activo")
	private boolean activo;
	
	

	@NonNull
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "usuario_rol", joinColumns = @JoinColumn(name = "usuario_id"), inverseJoinColumns = @JoinColumn(name = "rol_id"))
	private Set<Rol> roles = new HashSet<>();
	
	@OneToMany(mappedBy = "usuario")
	private List<Cesta> pedidos;

	public Usuario() {
	}

	public Usuario(@NonNull String nombre, @NonNull String nombreUsuario, @NonNull String email,
			@NonNull String password) {
		this.nombre = nombre;
		this.nombreUsuario = nombreUsuario;
		this.email = email;
		this.password = password;
		this.activo = true;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public Set<Rol> getRoles() {
		return roles;
	}

	public void setRoles(Set<Rol> roles) {
		this.roles = roles;
	}
}
