package org.mlb.pruebaSalidaTD.controladores;

import java.util.List;
import java.util.Optional;

import org.mlb.pruebaSalidaTD.modelos.Employee;
import org.mlb.pruebaSalidaTD.modelos.Office;
import org.mlb.pruebaSalidaTD.repositorios.EmployeeRepository;
import org.mlb.pruebaSalidaTD.repositorios.OfficeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeRepository er;
	
	@Autowired
	OfficeRepository or;
	
	
    @RequestMapping(value = "/mostrarEmpleados", method = RequestMethod.GET)
    public ModelAndView mostrarEmpleados(Model model) {
    	//lista oficinas ordenadas alfabeticamente
        List<Office> listaOficinas = or.findAll((Sort.by(Direction.ASC, "city")));
        model.addAttribute("listaOficinas", listaOficinas);
    	
    	//Lista SM ordenados alfabeticamente
        List<Employee> listaSM = er.findAllByJobTitleLike("%Manager%",((Sort.by(Direction.ASC, "firstName","lastName"))));
        
        model.addAttribute("listaSM", listaSM);
        return new ModelAndView("home", "model", model);
    }
    
    @RequestMapping(value = "/buscar", method = RequestMethod.POST)
    public ModelAndView buscar(@RequestParam("officeCode") int officeCode, @RequestParam("employeeNumber") int employeeNumber) {
    	return new ModelAndView("redirect:/mostrarEmpleados/" + officeCode + "/" + employeeNumber);
    }
    
    @RequestMapping(value = "/mostrarEmpleados/{officeCode}/{employeeNumber}", method = RequestMethod.GET)
    public ModelAndView mostrarEmpleadosfiltrados(@PathVariable int officeCode, @PathVariable int employeeNumber, Model model) {
    	//lista oficinas ordenadas alfabeticamente
        List<Office> listaOficinas = or.findAll((Sort.by(Direction.ASC, "city")));
        model.addAttribute("listaOficinas", listaOficinas);
    	
    	//Lista SM ordenados alfabeticamente
        List<Employee> listaSM = er.findAllByJobTitleLike("%Manager%",((Sort.by(Direction.ASC, "firstName","lastName"))));
        model.addAttribute("listaSM", listaSM);
        
    	//Lista filtrada
        Optional<Office> office = or.findById(officeCode);
        System.out.println(office.get().getOfficeCode());
        Optional<Employee> manager = er.findById(employeeNumber);
        System.out.println(manager.get().getEmployeeNumber());
        List<Employee> empleados = er.findAllByOfficeAndManager(office.get(), manager.get());
        model.addAttribute("empleados", empleados);
        
        return new ModelAndView("home", "model", model);
    }
    
}
