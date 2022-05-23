package net.javaguides.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.springboot.model.Cesta;

public interface CestaRepository extends JpaRepository<Cesta, Long>{

}
