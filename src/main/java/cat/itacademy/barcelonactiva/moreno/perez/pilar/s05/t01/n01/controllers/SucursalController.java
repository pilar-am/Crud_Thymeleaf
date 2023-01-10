package cat.itacademy.barcelonactiva.moreno.perez.pilar.s05.t01.n01.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import cat.itacademy.barcelonactiva.moreno.perez.pilar.s05.t01.n01.model.dto.SucursalDTO;
import cat.itacademy.barcelonactiva.moreno.perez.pilar.s05.t01.n01.model.service.SucursalService;

@Controller
public class SucursalController {

	@Autowired
	private SucursalService sucursalService;
	
    //Dos rutas, raíz y /sucursal/getAll
    @GetMapping(value = {"/sucursal/getAll", "/"})
    public String llistarSucursals(Model model) {
	  	List<SucursalDTO> sucursals = sucursalService.getAllSucursalsDTO();
	  
	  	String tipusSucursal;
			for(SucursalDTO s : sucursals) {
				tipusSucursal = s.esUE(s.getPaisSucursal());
				s.setTipusSucursal(tipusSucursal);
			}
	  	
	    model.addAttribute("listSucursals", sucursals);
	    return "index";
	}
    
    @GetMapping("/sucursal/getOne/{id}")
    public String sucursal(@PathVariable(value = "id") int id,Model model) {
    	SucursalDTO sucursalDTO = sucursalService.getSucursalDTOById(id);
    	String tipusSucursal;
    	tipusSucursal = sucursalDTO.esUE(sucursalDTO.getPaisSucursal());
    	sucursalDTO.setTipusSucursal(tipusSucursal);
    	model.addAttribute("sucursal", sucursalDTO);
    	return "sucursal";
    }
    
    
	@GetMapping("/sucursal/add")
    public String formCrearSucursal(Model model) {
		SucursalDTO sucursal = new SucursalDTO();
	    model.addAttribute("sucursal", sucursal);
	    return "formcrear";
	}
		  
	@PostMapping("/add")
	public String saveSucursalDTO(@ModelAttribute("sucursal") SucursalDTO sucursal) {
		sucursalService.saveSucursalDTO(sucursal);
		return "redirect:/sucursal/getAll";
	}  
	
	@PostMapping("/update")
	public String updateSucursalDTO(@ModelAttribute("sucursal") SucursalDTO sucursal) {
		sucursalService.updateSucursalDTO(sucursal, sucursal.getPk_SucursalID());
		return "redirect:/sucursal/getAll";
	} 
	  
    @GetMapping("/sucursal/update/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") int id, Model model) {
      
    	SucursalDTO sucursal = sucursalService.getSucursalDTOById(id);
        model.addAttribute("sucursal", sucursal);
        return "update_sucursal";
    }
  
  	
	@GetMapping("/deleteSucursal/{id}")
	public String deleteEmployee(@PathVariable(value = "id") int id) {

	    this.sucursalService.deleteSucursalById(id);
	    return "redirect:/sucursal/getAll";
	}
	
}
