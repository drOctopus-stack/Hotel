package com.api.hotel.hotel.repository;

import com.api.hotel.hotel.model.entity.NumeroQuarto;
import com.api.hotel.hotel.util.TipoQuartoEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NumeroQuartoRepository extends JpaRepository<NumeroQuarto,Long> {

    NumeroQuarto findFirstByTipoQuartoAndOcupacao(String tipoQuarto,String ocupacao);
}
