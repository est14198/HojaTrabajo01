/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author FER ESTRADA & CHRISTOPHER SANDOVAL 13660
 * 
 */
public class RadioCool implements IRadio {
	
	private float emisora;
	private boolean encendido;
	private boolean frecuencia;
	private float[] emisorasFavoritas;
	
	public RadioCool(){
		encendido = false;
		frecuencia = false;
		emisora = 530.0F;
		emisorasFavoritas = new float[12];
	}

	@Override
	public void estado() {
		encendido = !encendido;
	}

	@Override
	public void frecuencia() {
		frecuencia = !frecuencia;
		if(!frecuencia){
			emisora = 530.0F;
		}else{
			emisora = 87.9F;
		}
	}

	@Override
	public void cambiar(boolean subir) {
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

	@Override
	public void guardar(int indx) {
		emisorasFavoritas[indx] = emisora;
	}

	@Override
	public void seleccionar(int indx) {
		emisora = emisorasFavoritas[indx];
	}

	@Override
	public boolean getEstado() {
		return encendido;
	}

	@Override
	public boolean getFrecuencia() {
		return frecuencia;
	}

	@Override
	public float getEmisora() {
		return emisora;
	}
    
}
