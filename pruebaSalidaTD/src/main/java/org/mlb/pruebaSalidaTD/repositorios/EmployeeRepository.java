package org.mlb.pruebaSalidaTD.repositorios;

import java.util.List;

import org.mlb.pruebaSalidaTD.modelos.Employee;
import org.mlb.pruebaSalidaTD.modelos.Office;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>  {
	List<Employee> findAllByOfficeAndManager(Office office, Employee manager);
	List<Employee> findAllByJobTitleLike(String jobtitle, Sort sort);
}
