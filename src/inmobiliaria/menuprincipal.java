package inmobiliaria;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class menuprincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menuprincipal frame = new menuprincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public menuprincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final visitas formvisitas = new visitas();
		final propietarios formpropietarios = new propietarios();
		final comerciales formcomercial = new comerciales();
		final vivienda formvivienda = new vivienda();
		final compradores formcompradores = new compradores();
		
		JButton btnvisitas = new JButton("visitas");
		btnvisitas.setBounds(111, 165, 63, 23);
		contentPane.add(btnvisitas);
		btnvisitas.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				formvisitas.setVisible(true);
			}
					
		});
		
		JButton btnpropietarios = new JButton("propietarios");
		btnpropietarios.setBounds(108, 118, 89, 23);
		contentPane.add(btnpropietarios);
		btnpropietarios.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				formpropietarios.setVisible(true);
			}
					
		});
		
		JButton btncomercial = new JButton("comercial");
		btncomercial.setBounds(108, 11, 77, 23);
		contentPane.add(btncomercial);
		btncomercial.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				formcomercial.setVisible(true);
			}
					
		});
		
		JButton btnviviendas = new JButton("viviendas");
		btnviviendas.setBounds(111, 214, 77, 23);
		contentPane.add(btnviviendas);
		btnviviendas.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				formvivienda.setVisible(true);
			}
					
		});
		
		
		JButton btncompradores = new JButton("compradores");
		btncompradores.setBounds(104, 64, 95, 23);
		contentPane.add(btncompradores);
		btncompradores.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				formcompradores.setVisible(true);
			}
					
		});
	}

}
