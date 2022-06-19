package net.javaguides.springboot.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.javaguides.springboot.security.entity.Rol;
import net.javaguides.springboot.security.enums.RolNombre;
import net.javaguides.springboot.security.repository.RolRepository;

import java.util.Optional;

// TODO: Auto-generated Javadoc
/**
 * The Class RolService.
 */
@Service
@Transactional
public class RolService {

	/** The rol repository. */
	@Autowired
	RolRepository rolRepository;

	/**
	 * Gets the by rol nombre.
	 *
	 * @param rolNombre the rol nombre
	 * @return the by rol nombre
	 */
	public Optional<Rol> getByRolNombre(RolNombre rolNombre) {
		return rolRepository.findByRolNombre(rolNombre);
	}

	/**
	 * Save.
	 *
	 * @param rol the rol
	 */
	public void save(Rol rol) {
		rolRepository.save(rol);
	}
}