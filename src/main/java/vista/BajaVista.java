package vista;


import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class BajaVista {
	private JFrame frame;
	private JTextField referenciaTf;
	private JButton botonAceptar, botonAtras;
	private String referencia;
	
	public BajaVista() {
		crearBajaVista();
	}


	//Crear la vista con un textview editt y boton eliminar y volver
	public void crearBajaVista() {
		frame = new JFrame();
		frame.setBounds(500, 300, 400, 320);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setTitle("Baja de producto");
	
		
		JLabel ref = new JLabel("Referencia");
		ref.setBounds(20,30, 100,20);
		frame.getContentPane().add(ref);
		referenciaTf = new JTextField();
		referenciaTf.setBounds(20,50,100,20);
		frame.getContentPane().add(referenciaTf);
		
		botonAceptar = new JButton("Aceptar");
		botonAceptar.setBounds(20, 90, 100, 20);
		botonAceptar.addMouseListener(new MouseListener() {
			
			public void mouseReleased(MouseEvent e) {}
			
			public void mousePressed(MouseEvent e) {}
			
			public void mouseExited(MouseEvent e) {}
			
			public void mouseEntered(MouseEvent e) {}
			
			public void mouseClicked(MouseEvent e) {
				//Check si referencia 
				referencia = referenciaTf.getText();
				//Eliminar referencia si existe en la base de datos
				if(!deleteProducto(referencia)) {
					JOptionPane.showMessageDialog(frame, "La referencia no se corresponde con ninguno de nuestros productos");
				}else {
					JOptionPane.showMessageDialog(frame, "Producto eliminado");
				}
			}
		});
		frame.getContentPane().add(botonAceptar);
		
		botonAtras = new JButton("Atrás");
		botonAtras.setBounds(140, 90, 100, 20);
		botonAtras.addMouseListener(new MouseListener() {
			
			public void mouseReleased(MouseEvent e) {}
			
			public void mousePressed(MouseEvent e) {}
			
			public void mouseExited(MouseEvent e) {}
			
			public void mouseEntered(MouseEvent e) {}
			
			public void mouseClicked(MouseEvent e) {
				atrasMenu();
			}
		});
		frame.getContentPane().add(botonAtras);
	}
	
	
	public void setVisible() {
		frame.setVisible(true);
	}
	
	protected void atrasMenu() {
		frame.dispose();
	}
	
	protected boolean deleteProducto(String referencia) {
		return false;
	}
}
