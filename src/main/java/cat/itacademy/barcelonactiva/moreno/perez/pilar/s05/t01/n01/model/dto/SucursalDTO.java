package cat.itacademy.barcelonactiva.moreno.perez.pilar.s05.t01.n01.model.dto;

import java.util.Arrays;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SucursalDTO {

	private Integer pk_SucursalID;
	private String nomSucursal;
	private String paisSucursal;
	private String tipusSucursal;
	private List<String> paises = Arrays.asList("Alemania", "Bélgica", "Croacia", "Dinamarca", "España", 
									"Francia", "Irlanda", "Letonia", "Luxemburgo", "Países Bajos", "Suecia","Bulgaria", 
									"Eslovaquia", "Estonia", "Grecia", "Malta", "Polonia", "República Checa", "Austria",
									"Chipre", "Eslovenia", "Finlandia","Hungría", "Italia", "Lituania", "Portugal", 
									"Rumanía");
	
	
	public String esUE(String pais) {
		String esUEString = null;
		boolean trobat = false;
		for(String p: paises) {
			if(p.equalsIgnoreCase(pais)) {
				trobat = true;
			}
		}
		if(trobat) {
			esUEString = "UE";
		}else {
			esUEString = "Fora UE";
		}
		return esUEString;
	}
	
}
