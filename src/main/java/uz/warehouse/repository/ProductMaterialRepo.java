package uz.warehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.warehouse.entity.Product;
import uz.warehouse.entity.ProductMaterials;

import java.util.List;

@Repository
public interface ProductMaterialRepo extends JpaRepository<ProductMaterials, Long> {

    public List<ProductMaterials> getAllByProduct(Product product);

}
