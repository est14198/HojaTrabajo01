/**
 * GUI.java
 * Universidad del Valle de Guatemala
 * @since 1/17/2017
 * @author CHRISTOPHER SANDOVAL 13660
 * Hoja de Trabajo 1. Algoritmos y Estructura de Datos
 * Interfaz grafica
 */



/**
 * Importaciones
 */
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JToggleButton;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;


public class GUI {
	
	/**
	 * Botones
	 */
	private JFrame frame;
	private JButton bF1;
	private JButton bF2;
	private JButton bF3;
	private JButton bF4;
	private JButton bF5;
	private JButton bF6;
	private JButton bF7;
	private JButton bF8;
	private JButton bF9;
	private JButton bF10;
	private JButton bF11;
	private JButton bF12;
	private JButton bSubir;
	private JButton bBajar;
	private JButton bEncendido;
	private JButton bFrecuencia;
	private JLabel lblEmisora;
	private JToggleButton tglbtnGuardar;
	
	/**
	 * Atributo de la interfaz radio
	 */
	private IRadio radio;
	
	/**
	 * Atributo para guardar emisora
	 */
	private boolean guardar;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
		guardar = false;
		radio = new RadioCool();
		/**
		 * Verifica que el boton encendido este TRUE para mostrar el lbl.
		 */
		if(!radio.getEstado()){
			lblEmisora.setText("");
		}else{
			if(!radio.getFrecuencia()){
				lblEmisora.setText("AM: " + radio.getEmisora()+"kHz");
			}else{
				lblEmisora.setText("FM: " + radio.getEmisora()+"MHz");
			}
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 778, 244);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		
		/**
		 * Se crean ActionListeners para todos los botones
		 */
		
		bEncendido = new JButton("ON/OFF");
		bEncendido.addActionListener(new ButtonListener());
		panel.setLayout(new BorderLayout(0, 0));
		panel.add(bEncendido, BorderLayout.WEST);
		
		bFrecuencia = new JButton("AM/FM");
		bFrecuencia.addActionListener(new ButtonListener());
		panel.add(bFrecuencia, BorderLayout.EAST);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.SOUTH);
		
		bF1 = new JButton("1");
		bF1.addActionListener(new ButtonListener());
		
		tglbtnGuardar = new JToggleButton("GUARDAR");
		tglbtnGuardar.addActionListener(new ButtonListener());
		panel_1.add(tglbtnGuardar);
		panel_1.add(bF1);
		
		bF2 = new JButton("2");
		bF2.addActionListener(new ButtonListener());
		panel_1.add(bF2);
		
		bF3 = new JButton("3");
		bF3.addActionListener(new ButtonListener());
		panel_1.add(bF3);
		
		bF4 = new JButton("4");
		bF4.addActionListener(new ButtonListener());
		panel_1.add(bF4);
		
		bF5 = new JButton("5");
		bF5.addActionListener(new ButtonListener());
		panel_1.add(bF5);
		
		bF6 = new JButton("6");
		bF6.addActionListener(new ButtonListener());
		panel_1.add(bF6);
		
		bF7 = new JButton("7");
		bF7.addActionListener(new ButtonListener());
		panel_1.add(bF7);
		
		bF8 = new JButton("8");
		bF8.addActionListener(new ButtonListener());
		panel_1.add(bF8);
		
		bF9 = new JButton("9");
		bF9.addActionListener(new ButtonListener());
		panel_1.add(bF9);
		
		bF10 = new JButton("10");
		bF10.addActionListener(new ButtonListener());
		panel_1.add(bF10);
		
		bF11 = new JButton("11");
		bF11.addActionListener(new ButtonListener());
		panel_1.add(bF11);
		
		bF12 = new JButton("12");
		bF12.addActionListener(new ButtonListener());
		panel_1.add(bF12);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "RADIOS COOLeros\u2122", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		frame.getContentPane().add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		lblEmisora = new JLabel("530.0 kHz");
		lblEmisora.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmisora.setFont(new Font("Courier New", Font.BOLD, 70));
		panel_2.add(lblEmisora);
		
		JPanel panel_3 = new JPanel();
		frame.getContentPane().add(panel_3, BorderLayout.WEST);
		panel_3.setLayout(new GridLayout(0, 1, 0, 0));
		
		bSubir = new JButton("\u25B2");
		bSubir.addActionListener(new ButtonListener());
		panel_3.add(bSubir);
		
		bBajar = new JButton("\u25BC");
		bBajar.addActionListener(new ButtonListener());
		panel_3.add(bBajar);
	}
	
	/**
	 * Implementando ActionListener.
	 */
	private class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			/**
			 * Busca el source del boton y realiza la operacion indicada
			 */
			if(e.getSource() == bEncendido){
				radio.estado();
				if(!radio.getEstado()){
					lblEmisora.setText("");
				}else{
					mostrarDisplay();
				}
			}else if(e.getSource() == bFrecuencia){
				radio.frecuencia();
				mostrarDisplay();
			}else if(e.getSource() == bSubir){
				radio.cambiar(true);
				mostrarDisplay();
			}else if(e.getSource() == bBajar){
				radio.cambiar(false);
				mostrarDisplay();
			}else if(e.getSource() == tglbtnGuardar){
				guardar=!guardar;
			}else if(e.getSource() == bF1){
				if(guardar){
					radio.guardar(0);
					tglbtnGuardar.setSelected(false);
					guardar = !guardar;
				}else{
					radio.seleccionar(0);
					mostrarDisplay();
				}
			}else if(e.getSource() == bF2){
				if(guardar){
					radio.guardar(1);
					tglbtnGuardar.setSelected(false);
					guardar = !guardar;
				}else{
					radio.seleccionar(1);
					mostrarDisplay();
				}
			}else if(e.getSource() == bF3){
				if(guardar){
					radio.guardar(2);
					tglbtnGuardar.setSelected(false);
					guardar = !guardar;
				}else{
					radio.seleccionar(2);
					mostrarDisplay();
				}
			}else if(e.getSource() == bF4){
				if(guardar){
					radio.guardar(3);
					tglbtnGuardar.setSelected(false);
					guardar = !guardar;
				}else{
					radio.seleccionar(3);
					mostrarDisplay();
				}
			}else if(e.getSource() == bF5){
				if(guardar){
					radio.guardar(4);
					tglbtnGuardar.setSelected(false);
					guardar = !guardar;
				}else{
					radio.seleccionar(4);
					mostrarDisplay();
				}
			}else if(e.getSource() == bF6){
				if(guardar){
					radio.guardar(5);
					tglbtnGuardar.setSelected(false);
					guardar = !guardar;
				}else{
					radio.seleccionar(5);
					mostrarDisplay();
				}
			}else if(e.getSource() == bF7){
				if(guardar){
					radio.guardar(6);
					tglbtnGuardar.setSelected(false);
					guardar = !guardar;
				}else{
					radio.seleccionar(6);
					mostrarDisplay();
				}
			}else if(e.getSource() == bF8){
				if(guardar){
					radio.guardar(7);
					tglbtnGuardar.setSelected(false);
					guardar = !guardar;
				}else{
					radio.seleccionar(7);
					mostrarDisplay();
				}
			}else if(e.getSource() == bF9){
				if(guardar){
					radio.guardar(8);
					tglbtnGuardar.setSelected(false);
					guardar = !guardar;
				}else{
					radio.seleccionar(8);
					mostrarDisplay();
				}
			}else if(e.getSource() == bF10){
				if(guardar){
					radio.guardar(9);
					tglbtnGuardar.setSelected(false);
					guardar = !guardar;
				}else{
					radio.seleccionar(9);
					mostrarDisplay();
				}
			}else if(e.getSource() == bF11){
				if(guardar){
					radio.guardar(10);
					tglbtnGuardar.setSelected(false);
					guardar = !guardar;
				}else{
					radio.seleccionar(10);
					mostrarDisplay();
				}
			}else if(e.getSource() == bF12){
				if(guardar){
					radio.guardar(11);
					tglbtnGuardar.setSelected(false);
					guardar = !guardar;
				}else{
					radio.seleccionar(11);
					mostrarDisplay();
				}
			}
		}
	}
	
	/**
	 * Metodo para mostrar la emisora actual en el lbl. Si el boton esta OFF, no realiza ninguna operacion.
	 */
	private void mostrarDisplay(){
		DecimalFormat df = new DecimalFormat("#.#");
		if(radio.getEstado()){
			if(!radio.getFrecuencia()){
				lblEmisora.setText("AM: " + df.format(radio.getEmisora())+"kHz");
			}else{
				lblEmisora.setText("FM: " + df.format(radio.getEmisora())+"MHz");
			}
		}
	}

}
