package org.mlb.pruebaSalidaTD.restControladores;

import java.util.List;
import java.util.Optional;

import org.mlb.pruebaSalidaTD.modelos.Employee;
import org.mlb.pruebaSalidaTD.modelos.Office;
import org.mlb.pruebaSalidaTD.repositorios.EmployeeRepository;
import org.mlb.pruebaSalidaTD.repositorios.OfficeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeRestController {

	
	@Autowired
	EmployeeRepository er;
	
	@Autowired
	OfficeRepository or;
	
	@RequestMapping(value = "/vendedores/{officeCode}/{employeeNumber}", method = RequestMethod.GET, headers = "Accept=application/json")
    public List<Employee> listarEmpleados(@PathVariable int officeCode, @PathVariable int employeeNumber) {
        Optional<Office> office = or.findById(officeCode);
        System.out.println(office.get().getOfficeCode());
        Optional<Employee> manager = er.findById(employeeNumber);
        System.out.println(manager.get().getEmployeeNumber());
        List<Employee> empleados = er.findAllByOfficeAndManager(office.get(), manager.get());
        
        return empleados;
    }
}
