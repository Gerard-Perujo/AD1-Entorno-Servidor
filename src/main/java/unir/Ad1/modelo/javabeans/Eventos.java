package unir.Ad1.modelo.javabeans;

import java.io.Serializable;


import java.util.Date;
import java.util.Objects;

import lombok.AllArgsConstructor;
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
 * @param NoArgsConstructor: Nos crea un constructor sin argumentos
 * @param AllArgsConstructor: Nos crea un constructor con todo
 * @param Getter: Nos crea todos los Getters
 * @param Setter: Nos crea todos los Setters
 * @param ToString: Nos crea el metodo toString
 * @param EqualsAndHashCode: nos crea el hash and code pero tenemos que definir 
 * cual variable queremos que utilize por eso utilizamos el include encima de 
 * idEvento para decirle que nos coga esa variable.
 *
 */

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded= true)
public class Eventos implements Serializable{
	
	public static final long serialVersionUID = 1L;
	
	
	@EqualsAndHashCode.Include
	private int idEvento;
	private int duracion, aforoMax, maxAsistencia;
	private String nombre, descripcion, direccion, estado, destacado;
	private Date fechaInicio;
	private double precio;
	private Tipos tipo;
	
}
	
		