package uz.warehause.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.warehause.entity.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {
}
