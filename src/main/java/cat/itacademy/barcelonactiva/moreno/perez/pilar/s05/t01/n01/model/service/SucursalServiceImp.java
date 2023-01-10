package cat.itacademy.barcelonactiva.moreno.perez.pilar.s05.t01.n01.model.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cat.itacademy.barcelonactiva.moreno.perez.pilar.s05.t01.n01.model.domain.Sucursal;
import cat.itacademy.barcelonactiva.moreno.perez.pilar.s05.t01.n01.model.dto.SucursalDTO;
import cat.itacademy.barcelonactiva.moreno.perez.pilar.s05.t01.n01.model.repository.SucursalRepository;

@Service
public class SucursalServiceImp implements SucursalService{

	@Autowired
	private SucursalRepository sucursalRepository;

	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public List<SucursalDTO> getAllSucursalsDTO() {
		return  sucursalRepository.findAll()
        		.stream()
        		.map(this::convertEntityToDto)
        		.collect(Collectors.toList());
	}

	@Override
	public void saveSucursalDTO(SucursalDTO sucursalDTO) {
		Sucursal sucursal = new Sucursal();
		
		sucursal.setNomSucursal(sucursalDTO.getNomSucursal());
		sucursal.setPaisSucursal(sucursalDTO.getPaisSucursal());
		
		sucursalRepository.save(sucursal);
	}
	
	@Override
	public void updateSucursalDTO(SucursalDTO sucursalDTO, int id) {
		Sucursal sucursal = sucursalRepository.findById(id).orElseThrow();
		
		
		sucursal.setNomSucursal(sucursalDTO.getNomSucursal());
		sucursal.setPaisSucursal(sucursalDTO.getPaisSucursal());
		
		sucursalRepository.save(sucursal);
		
	}
	
	@Override
	public SucursalDTO getSucursalDTOById(int id) {
		Optional < Sucursal > optional = sucursalRepository.findById(id);
		Sucursal sucursal = null;
		SucursalDTO sucursalDTO = null;
        if (optional.isPresent()) {
        	sucursal = optional.get();
        	sucursalDTO = modelMapper.map(sucursal, SucursalDTO.class);
        } else {
            throw new RuntimeException(" Sucursal no encontrada :: " + id);
        }
		return sucursalDTO;
	}
	

	
	@Override
	public void deleteSucursalById(int id) {
		this.sucursalRepository.deleteById(id);
		
	}

	//De Entity a DTO
	private SucursalDTO convertEntityToDto(Sucursal sucursal) {
		SucursalDTO sucursalDTO = modelMapper.map(sucursal, SucursalDTO.class);
		return sucursalDTO;
	}

}
