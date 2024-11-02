package parcialdesarrollo.ADN.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import parcialdesarrollo.ADN.entities.Mutante;

import java.util.Optional;

@Repository
public interface MutanteRepository extends JpaRepository<Mutante, Long> {

   Optional<Mutante> findByDna (String dna);

   long countByIsMutante(boolean isMutante);
}
