package portfolio_backend;

import lombok.Data;
import jakarta.persistence.*;
import java.time.LocalDateTime;

// @Data = Lombok génère automatiquement tous les getters et setters
@Data

// @Entity = cette classe représente une table dans la base de données
@Entity

// @Table = le nom de la table dans PostgreSQL
@Table(name = "messages")

public class Message {

    // @Id = c'est la clé primaire (identifiant unique)
    @Id
    // @GeneratedValue = l'id est généré automatiquement (1, 2, 3...)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Chaque variable = une colonne dans la table
    private String nom;
    private String email;
    private String message;

    // La date d'envoi — générée automatiquement
    private LocalDateTime dateEnvoi;
}