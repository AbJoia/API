package org.g2ac.javabackendMarketplace.projetoFinal.Repository;

import org.g2ac.javabackendMarketplace.projetoFinal.Entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

}
