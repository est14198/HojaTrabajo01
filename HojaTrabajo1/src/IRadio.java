/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Universidad del Valle de Guatemala
 * @since 1/17/2017
 * @author FER ESTRADA
 * 
 */
public interface IRadio {
    public void estado() ;
    public void frecuencia() ;
    public void cambiar(boolean subir) ;
    public void guardar(int indx) ;
    public void seleccionar(int indx) ;
    public boolean getEstado() ;
    public boolean getFrecuencia() ;
    public float getEmisora();
}
