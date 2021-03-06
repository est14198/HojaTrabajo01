/**
 * iRadio.java
 * Universidad del Valle de Guatemala
 * @since 1/17/2017
 * @author FER ESTRADA 14198
 * Hoja de Trabajo 1. Algoritmos y Estructura de Datos
 * Interfaz de una radio
 */



public interface IRadio {
	
    /**
     * pre: verifica el estado inicial
     * post: cambia de estado entre apagado y encendido
     */
    public void estado() ;
    
    
    /**
     * pre: verifica la frecuencia actual
     * post: cambia de frecuencia entre AM o FM
     */
    public void frecuencia() ;
    
    
    /**
     * @param subir
     * pre: verifica la emisora y la frecuencia actuales
     * post: el numero de la emisora cambia (sube o baja) y tal numero depende si es AM o FM
     */
    public void cambiar(boolean subir) ;
    
    
    /**
     * @param indx
     * post: guarda la emisora actual en una lista, indx indica en cual posicion
     */
    public void guardar(int indx) ;
    
    
    /**
     * @param indx se le ingresa el numero de boton seleccionado
     * @return estacion seleccionada
     * post: va a la posicion indicada por indx y regresa la emisora guardada
     */
    public float seleccionar(int indx) ;
    
    
    /**
     * @return estado actual del radio
     * post: regresa el estado actual (si esta encendido o apagado)
     */
    public boolean getEstado() ;
    
    
    /**
     * @return frecuencia actual del radio
     * post: regresa la frecuencia actual (si es AM o FM)
     */
    public boolean getFrecuencia() ;
    
    
    /**
     * @return numero de emisora actual
     * post: regresa la emisora actual
     */
    public float getEmisora();
}
