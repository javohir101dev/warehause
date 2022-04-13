package uz.warehause.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.warehause.entity.Warehouse;

@Repository
public interface WarehouseRepo extends JpaRepository<Warehouse, Long> {
}
