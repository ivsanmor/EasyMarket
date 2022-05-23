package net.javaguides.springboot.security.entity;

import javax.persistence.*;

import lombok.NonNull;
import net.javaguides.springboot.model.Cesta;
import net.javaguides.springboot.model.Producto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NonNull
	private String nombre;
	
	@NonNull
	@Column(unique = true)
	private String nombreUsuario;
	
	@NonNull
	private String email;
	
	@NonNull
	private String password;
	
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

	public Set<Rol> getRoles() {
		return roles;
	}

	public void setRoles(Set<Rol> roles) {
		this.roles = roles;
	}
}
