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

/**
 * @author CHRISTOPHER SANDOVAL 13660 
 * 
 *
 */
public class GUI {

	private JFrame frame;
	private JButton button;
	private JButton button_1;
	private JButton button_2;
	private JButton button_3;
	private JButton button_4;
	private JButton button_5;
	private JButton button_6;
	private JButton button_7;
	private JButton button_8;
	private JButton button_9;
	private JButton button_10;
	private JButton button_11;
	private JButton button_12;
	private JButton button_13;
	private JButton btnONOFF;
	private JButton btnAmfm;
	private JLabel lblMhz;
	
	private IRadio radio;
	

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
		radio = new RadioCool();
		if(!radio.getEstado()){
			lblMhz.setText("");
		}else{
			if(!radio.getFrecuencia()){
				lblMhz.setText("AM: " + radio.getEmisora()+"kHz");
			}else{
				lblMhz.setText("FM: " + radio.getEmisora()+"MHz");
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
		
		btnONOFF = new JButton("ON/OFF");
		btnONOFF.addActionListener(new ButtonListener());
		panel.setLayout(new BorderLayout(0, 0));
		panel.add(btnONOFF, BorderLayout.WEST);
		
		btnAmfm = new JButton("AM/FM");
		btnAmfm.addActionListener(new ButtonListener());
		panel.add(btnAmfm, BorderLayout.EAST);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.SOUTH);
		
		button = new JButton("1");
		button.addActionListener(new ButtonListener());
		panel_1.add(button);
		
		button_1 = new JButton("2");
		button_1.addActionListener(new ButtonListener());
		panel_1.add(button_1);
		
		button_2 = new JButton("3");
		button_2.addActionListener(new ButtonListener());
		panel_1.add(button_2);
		
		button_3 = new JButton("4");
		button_3.addActionListener(new ButtonListener());
		panel_1.add(button_3);
		
		button_4 = new JButton("5");
		button_4.addActionListener(new ButtonListener());
		panel_1.add(button_4);
		
		button_5 = new JButton("6");
		button_5.addActionListener(new ButtonListener());
		panel_1.add(button_5);
		
		button_6 = new JButton("7");
		button_6.addActionListener(new ButtonListener());
		panel_1.add(button_6);
		
		button_7 = new JButton("8");
		button_7.addActionListener(new ButtonListener());
		panel_1.add(button_7);
		
		button_8 = new JButton("9");
		button_8.addActionListener(new ButtonListener());
		panel_1.add(button_8);
		
		button_9 = new JButton("10");
		button_9.addActionListener(new ButtonListener());
		panel_1.add(button_9);
		
		button_10 = new JButton("11");
		button_10.addActionListener(new ButtonListener());
		panel_1.add(button_10);
		
		button_11 = new JButton("12");
		button_11.addActionListener(new ButtonListener());
		panel_1.add(button_11);
		
		JPanel panel_2 = new JPanel();
		frame.getContentPane().add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		lblMhz = new JLabel("530.0 kHz");
		lblMhz.setHorizontalAlignment(SwingConstants.CENTER);
		lblMhz.setFont(new Font("Courier New", Font.BOLD, 70));
		panel_2.add(lblMhz);
		
		JPanel panel_3 = new JPanel();
		frame.getContentPane().add(panel_3, BorderLayout.WEST);
		panel_3.setLayout(new GridLayout(0, 1, 0, 0));
		
		button_12 = new JButton("\u2191");
		button_12.addActionListener(new ButtonListener());
		panel_3.add(button_12);
		
		button_13 = new JButton("\u2193");
		button_13.addActionListener(new ButtonListener());
		panel_3.add(button_13);
	}
	
	private class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == btnONOFF){
				radio.estado();
				if(!radio.getEstado()){
					lblMhz.setText("");
				}else{
					mostrarDisplay();
				}
			}else if(e.getSource() == btnAmfm){
				radio.frecuencia();
				mostrarDisplay();
			}else if(e.getSource() == button_12){
				radio.cambiar(true);
				mostrarDisplay();
			}else if(e.getSource() == button_13){
				radio.cambiar(false);
				mostrarDisplay();
			}
		}
	}
	
	private void mostrarDisplay(){
		DecimalFormat df = new DecimalFormat("#.#");
		if(radio.getEstado()){
			if(!radio.getFrecuencia()){
				lblMhz.setText("AM: " + df.format(radio.getEmisora())+"kHz");
			}else{
				lblMhz.setText("FM: " + df.format(radio.getEmisora())+"MHz");
			}
		}
	}

}
