import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class GUI {

	private JFrame frame;
	private JButton button;

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
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 584, 244);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		
		JButton btnNewButton = new JButton("ON/OFF");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.setLayout(new BorderLayout(0, 0));
		panel.add(btnNewButton, BorderLayout.WEST);
		
		JButton btnAmfm = new JButton("AM/FM");
		panel.add(btnAmfm, BorderLayout.EAST);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.SOUTH);
		
		button = new JButton("1");
		panel_1.add(button);
		
		JButton button_1 = new JButton("2");
		panel_1.add(button_1);
		
		JButton button_2 = new JButton("3");
		panel_1.add(button_2);
		
		JButton button_3 = new JButton("4");
		panel_1.add(button_3);
		
		JButton button_4 = new JButton("5");
		panel_1.add(button_4);
		
		JButton button_5 = new JButton("6");
		panel_1.add(button_5);
		
		JButton button_6 = new JButton("7");
		panel_1.add(button_6);
		
		JButton button_7 = new JButton("8");
		panel_1.add(button_7);
		
		JButton button_8 = new JButton("9");
		panel_1.add(button_8);
		
		JButton button_9 = new JButton("10");
		panel_1.add(button_9);
		
		JButton button_10 = new JButton("11");
		panel_1.add(button_10);
		
		JButton button_11 = new JButton("12");
		panel_1.add(button_11);
		
		JPanel panel_2 = new JPanel();
		frame.getContentPane().add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JLabel lblMhz = new JLabel("100.0 MHz");
		lblMhz.setHorizontalAlignment(SwingConstants.CENTER);
		lblMhz.setFont(new Font("Courier New", Font.BOLD, 70));
		panel_2.add(lblMhz);
		
		JPanel panel_3 = new JPanel();
		frame.getContentPane().add(panel_3, BorderLayout.WEST);
		panel_3.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton button_12 = new JButton("\u2191");
		panel_3.add(button_12);
		
		JButton btnNewButton_1 = new JButton("\u2193");
		panel_3.add(btnNewButton_1);
	}

}
