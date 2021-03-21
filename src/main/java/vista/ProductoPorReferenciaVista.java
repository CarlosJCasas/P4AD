package vista;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controller.MenuController;
import modelo.vo.ProductoVO;

public class ProductoPorReferenciaVista {
	
	private JFrame frame;
	private JTextField referenciaTf;
	private JButton botonAceptar, botonAtras;
	private String referencia;
	private JLabel lblRef, lblNom, lblDesc, lblCant, lblPre;
	
	
	
	public ProductoPorReferenciaVista() {
		crearProductoByRefVista();
	}

	public void crearProductoByRefVista() {
		frame = new JFrame();
		frame.setBounds(550, 350, 600, 400);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setTitle("Baja de producto");
		frame.setVisible(true);
		
		JLabel ref = new JLabel("Referencia");
		ref.setBounds(20,30, 100,20);
		frame.getContentPane().add(ref);
		
		referenciaTf = new JTextField();
		referenciaTf.setBounds(20,60,100,20);
		frame.getContentPane().add(referenciaTf);
		
		lblRef = new JLabel();
		lblRef.setBounds(160, 30, 150, 20);
		frame.getContentPane().add(lblRef);
		
		lblNom = new JLabel();
		lblNom.setBounds(160, 50, 150, 20);
		frame.getContentPane().add(lblNom);
		
		lblDesc = new JLabel();
		lblDesc.setBounds(160, 70, 150, 20);
		frame.getContentPane().add(lblDesc);
		
		lblCant = new JLabel();
		lblCant.setBounds(160, 90, 150, 20);
		frame.getContentPane().add(lblCant);
		
		lblPre = new JLabel();
		lblPre.setBounds(160, 110, 150, 20);
		frame.getContentPane().add(lblPre);
		
		botonAceptar = new JButton("Buscar");
		botonAceptar.setBounds(20, 90, 100, 20);
		botonAceptar.addMouseListener(new MouseListener() {
			
			public void mouseReleased(MouseEvent e) {}
			
			public void mousePressed(MouseEvent e) {}
			
			public void mouseExited(MouseEvent e) {}
			
			public void mouseEntered(MouseEvent e) {}
			
			public void mouseClicked(MouseEvent e) {
				
				referencia = referenciaTf.getText();
				ProductoVO productoVO = buscarPorRefencia(referencia);
				if(productoVO == null) {
					JOptionPane.showMessageDialog(frame, "La referencia no se corresponde con ninguno de nuestros productos");
				}else {
					lblRef.setText("Referencia: " + productoVO.getReferencia());
					lblNom.setText("Nombre: " + productoVO.getNombre());
					lblDesc.setText("Descripción: " + productoVO.getDescripcion());
					lblCant.setText("Cantidad: " + String.valueOf(productoVO.getCantidad()));
					lblPre.setText("Precio: " + String.valueOf(productoVO.getPrecio())+"€");
				}
			}
		});
		frame.getContentPane().add(botonAceptar);
		
		botonAtras = new JButton("Atrás");
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
	
	protected ProductoVO buscarPorRefencia(String referencia) {
		return null;
		
	}
}
