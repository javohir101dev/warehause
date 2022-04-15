package uz.warehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.warehouse.entity.Warehouse;

@Repository
public interface WarehouseRepo extends JpaRepository<Warehouse, Long> {
}
