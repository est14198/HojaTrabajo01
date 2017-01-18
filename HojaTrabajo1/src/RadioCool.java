/**
 * RadioCool.java
 * Universidad del Valle de Guatemala
 * @since 1/17/2017
 * @author FER ESTRADA 14198 & CHRISTOPHER SANDOVAL 13660 
 * Hoja de Trabajo 1. Algoritmos y Estructura de Datos
 * Implementacion de la Interfaz Radio
 */



public class RadioCool implements iRadio {
	
	/**
	 * Atributos
	 */
	private float emisora;
	private boolean encendido;
	private boolean frecuencia;
	private float[] emisorasFavoritasAM;
	private float[] emisorasFavoritasFM;
	
	/**
	 * Constructor
	 */
	public RadioCool(){
		encendido = false;
		frecuencia = false;
		emisora = 530.0F;
		emisorasFavoritasAM = new float[12];
		emisorasFavoritasFM = new float[12];
	}

	@Override
	/**
	 * post: cambia el estado actual de encendido
	 */
	public void estado() {
		encendido = !encendido;
	}

	@Override
	/**
	 * pre: verifica el estado encendido
	 * post: cambia el valor de la emisora
	 */
	public void frecuencia() {
		if(encendido){
			frecuencia = !frecuencia;
			if(!frecuencia){
				emisora = 530.0F;
			}else{
				emisora = 87.9F;
			}
		}
	}

	@Override
	/**
	 * @param subir
	 * pre: verifica el estado encendido y el estado de la variable subir
	 * post: cambia el valor de la emisora
	 */
	public void cambiar(boolean subir) {
		if(encendido){
			if(subir){
				if(!frecuencia){
					emisora += 10.0F;
					if(emisora>1610.0F){
						emisora = 530.0F;
					}
				}else{
					emisora += 0.2F;
					if(emisora>107.9F){
						emisora = 87.9F;
					}
				}
			}else{
				if(!frecuencia){
					emisora -= 10.0F;
					if(emisora<530.0F){
						emisora = 1610.0F;
					}
				}else{
					emisora -= 0.2F;
					if(emisora<87.9F){
						emisora = 107.9F;
					}
				}
			}
		}
	}

	@Override
	/**
	 * @param indx
	 * pre: verifica el estado encendido y el estado de la frecuencia
	 * post: agrega la emisora actual a la lista de favoritos en el indx indicado
	 */
	public void guardar(int indx) {
		if(encendido){
			if(!frecuencia){
				emisorasFavoritasAM[indx] = emisora;
			}else{
				emisorasFavoritasFM[indx] = emisora;
			}
		}
	}

	@Override
	/**
	 * @param indx
	 * pre: verifica el estado encendido y el estado de la frecuencia
	 * post: asigna la emisora del indx a la emisora actual
	 */
	public void seleccionar(int indx) {
		if(encendido){
			if(!frecuencia){
				if(emisorasFavoritasAM[indx] != 0){
					emisora = emisorasFavoritasAM[indx];
				}
			}else{
				if(emisorasFavoritasFM[indx] != 0){
					emisora = emisorasFavoritasFM[indx];
				}
			}
		}
	}

	@Override
	/**
	 * post: regresar el valor actual de encendido
	 */
	public boolean getEstado() {
		return encendido;
	}

	@Override
	/**
	 * post: regresar el valor actual de frecuencia
	 */
	public boolean getFrecuencia() {
		return frecuencia;
	}

	@Override
	/**
	 * post: regresar el valor actual de emisora
	 */
	public float getEmisora() {
		return emisora;
	} 
}
