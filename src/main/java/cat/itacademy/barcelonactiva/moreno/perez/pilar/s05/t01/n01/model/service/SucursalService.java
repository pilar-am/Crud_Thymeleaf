package cat.itacademy.barcelonactiva.moreno.perez.pilar.s05.t01.n01.model.service;

import java.util.List;

import cat.itacademy.barcelonactiva.moreno.perez.pilar.s05.t01.n01.model.domain.Sucursal;
import cat.itacademy.barcelonactiva.moreno.perez.pilar.s05.t01.n01.model.dto.SucursalDTO;


public interface SucursalService {

    List < SucursalDTO > getAllSucursalsDTO();
    
    void saveSucursalDTO(SucursalDTO sucursalDTO);
    
    SucursalDTO getSucursalDTOById(int id);
    
    void updateSucursalDTO(SucursalDTO sucursalDTO, int id);
    
    void deleteSucursalById(int id);
}

