package org.mlb.pruebaSalidaTD.repositorios;

import org.mlb.pruebaSalidaTD.modelos.Office;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfficeRepository  extends JpaRepository<Office, Integer> {

}
