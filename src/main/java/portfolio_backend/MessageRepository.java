package portfolio_backend;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// @Repository = dit à Spring que c'est une classe qui gère la base de données
@Repository

// JpaRepository donne automatiquement toutes les opérations de base :
// save(), findAll(), findById(), delete()...
// On précise : JpaRepository<NomEntité, TypeDeLId>
public interface MessageRepository extends JpaRepository<Message, Long> {
    // Rien à écrire ici — JPA génère tout automatiquement !
}