package ru.learnUp.learnupjava23.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.learnUp.learnupjava23.dao.entity.BooksOrder;

@Repository
public interface BooksOrderRepository extends JpaRepository<BooksOrder, Long> {
}
