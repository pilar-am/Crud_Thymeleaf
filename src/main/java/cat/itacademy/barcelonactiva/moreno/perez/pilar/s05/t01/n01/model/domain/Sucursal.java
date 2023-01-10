package cat.itacademy.barcelonactiva.moreno.perez.pilar.s05.t01.n01.model.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "sucursals")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sucursal {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer pk_SucursalID;
	
	@Column(name = "nom_sucursal")
	private String nomSucursal;
	
	@Column(name = "pais_sucursal")
	private String paisSucursal;
}
