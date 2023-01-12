package max.example.bankcardmanagementsystem.repository;

import max.example.bankcardmanagementsystem.entity.Card;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CardRepository extends JpaRepository<Card, Long> {
    List<Card> findByOwner(String owner, Pageable pageable);
    // Другие методы поиска и фильтрации
}
