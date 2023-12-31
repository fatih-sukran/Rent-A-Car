package io.fatih.RentACar.service;

import io.fatih.RentACar.entities.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Long> {
    // check if brand name exists
    boolean existsByName(String name);
}
