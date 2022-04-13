package uz.warehause.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.warehause.entity.Material;

@Repository
public interface MaterialRepo extends JpaRepository<Material, Long> {



}
