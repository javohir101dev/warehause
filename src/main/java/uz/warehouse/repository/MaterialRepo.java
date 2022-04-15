package uz.warehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.warehouse.entity.Material;

@Repository
public interface MaterialRepo extends JpaRepository<Material, Long> {



}
