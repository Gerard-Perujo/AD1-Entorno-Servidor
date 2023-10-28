package unir.Ad1.modelo.javabeans;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Usamos el lombok para crear la clase de esta manera no hace falta escribir los
 * constructores, los getters and setters, ni el metodo toString ni el hash and code
 * con esto en el caso de que cambiaramos algo de la clase no haria falta volver a 
 * reacer los constructores, getters, toString ya que se actualiza automaticamente
 * @author Gerard Perujo
 * @param @NoArgsConstructor: Nos crea un constructor sin argumentos
 * @param @AllArgsConstructor: Nos crea un constructor con todo
 * @param @Data: Nos crea los getters and setters, el toString, y el hash and code
 *
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Tipos implements Serializable{
	
	public static final long serialVersionUID = 1L;
	
	@EqualsAndHashCode.Include
	private int idTipo;
	private String nombre, descripcion;
}
