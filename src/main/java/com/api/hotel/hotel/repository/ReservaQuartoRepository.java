package com.api.hotel.hotel.repository;

import com.api.hotel.hotel.model.entity.ReservaQuarto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaQuartoRepository extends JpaRepository<ReservaQuarto,Long> {
}
