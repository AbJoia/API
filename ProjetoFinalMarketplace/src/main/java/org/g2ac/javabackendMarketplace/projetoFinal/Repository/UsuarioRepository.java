package org.g2ac.javabackendMarketplace.projetoFinal.Repository;

import org.g2ac.javabackendMarketplace.projetoFinal.Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	
}
