package portfolio_backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;

// @RestController = dit à Spring que c'est un controller qui gère les routes
@RestController

// @RequestMapping = toutes les routes commencent par /api/messages
@RequestMapping("/api/messages")

// @CrossOrigin = autorise le frontend (votre portfolio) à appeler ce backend
@CrossOrigin(origins = "*")

public class MessageController {

    // @Autowired = Spring injecte automatiquement le repository
    @Autowired
    private MessageRepository messageRepository;

    // @PostMapping = route POST pour recevoir un nouveau message
    // Appelée quand le formulaire est soumis
    @PostMapping
    public Message envoyerMessage(@RequestBody Message message) {
        // On ajoute la date d'envoi automatiquement
        message.setDateEnvoi(LocalDateTime.now());
        // On sauvegarde dans la base de données et on retourne le résultat
        return messageRepository.save(message);
    }

    // @GetMapping = route GET pour récupérer tous les messages
    // Utile pour voir tous les messages reçus
    @GetMapping
    public List<Message> tousLesMessages() {
        return messageRepository.findAll();
    }
    // @DeleteMapping = route DELETE pour supprimer un message par son id
@DeleteMapping("/{id}")
public void supprimerMessage(@PathVariable Long id) {
    messageRepository.deleteById(id);
}
}