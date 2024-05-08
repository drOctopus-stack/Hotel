package com.api.hotel.hotel.repository;

import com.api.hotel.hotel.model.entity.TipoQuarto;
import com.api.hotel.hotel.util.TipoQuartoEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoQuartoRepository extends JpaRepository<TipoQuarto,Long> {

    TipoQuarto findByTipo(String tipo);
}
