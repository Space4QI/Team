package ru.zulvit.teamentropy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.zulvit.teamentropy.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
}
