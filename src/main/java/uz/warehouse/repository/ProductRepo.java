package uz.warehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.warehouse.entity.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {
}
