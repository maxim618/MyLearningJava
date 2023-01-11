package max.example.bankcardmanagementsystem.controllers;

import max.example.bankcardmanagementsystem.entity.Card;
import max.example.bankcardmanagementsystem.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cards")
public class CardController {

    @Autowired
    private CardService cardService;

    @PostMapping
    public ResponseEntity<Card> createCard(@RequestBody Card card) {
        return ResponseEntity.ok(cardService.createCard(card));
    }

    @GetMapping
    public ResponseEntity<List<Card>> getCards(@RequestParam String owner, Pageable pageable) {
        return ResponseEntity.ok(cardService.getCardsByOwner(owner, pageable));
    }

    // Другие эндпоинты для CRUD операций
}
