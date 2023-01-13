package max.example.bankcardmanagementsystem.service;

import max.example.bankcardmanagementsystem.entity.Card;
import max.example.bankcardmanagementsystem.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardService {

    @Autowired
    private CardRepository cardRepository;

    public Card createCard(Card card) {
        // Логика создания карты
        return cardRepository.save(card);
    }

    public List<Card> getCardsByOwner(String owner, Pageable pageable) {
        return cardRepository.findByOwner(owner, pageable);
    }

    // Другие методы для блокировки, активации, удаления карт и перевода средств
}
