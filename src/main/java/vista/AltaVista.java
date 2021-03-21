package vista;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import controller.MenuController;

public abstract class AltaVista {

	private JFrame frame;
	private JTextField nombreTf;
	private JTextField referenciaTf;
	private JTextField descripcionTf;
	private JTextField precioTf;
	private JTextField cantidadTf;
	private JButton botonGuardar;
	private JButton botonAtras;
	private String referencia;
	private String nombre;
	private String descripcion;
	private int cantidad;
	private double precio;
	private JLabel lblRef, lblNom, lblDesc, lblCant, lblPre;
	private boolean refOk, nomOk, descOk, cantOk, preOk = false;
	
	public AltaVista() {
		crearAltaVista();
	}
	
	private void crearAltaVista() {
		frame = new JFrame();
		frame.setBounds(600, 400, 400, 320);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Alta de producto");
		
		lblRef = new JLabel("Referencia");
		lblRef.setBounds(20, 20, 150, 20);
		frame.getContentPane().add(lblRef);
		
		lblNom = new JLabel("Nombre");
		lblNom.setBounds(20, 60, 150, 20);
		frame.getContentPane().add(lblNom);
		
		lblDesc = new JLabel("Descripción");
		lblDesc.setBounds(20, 100, 150, 20);
		frame.getContentPane().add(lblDesc);
		
		lblCant = new JLabel("Cantidad");
		lblCant.setBounds(20, 140, 150, 20);
		frame.getContentPane().add(lblCant);
		
		lblPre = new JLabel("Precio");
		lblPre.setBounds(20, 180, 150, 20);
		frame.getContentPane().add(lblPre);
		
		botonGuardar = new JButton("Añadir");
		
		//Referencia
		referenciaTf = new JTextField();
		referenciaTf.setBounds(20,40,100,20);
		referenciaTf.getDocument().addDocumentListener(new DocumentListener() {
			public void removeUpdate(DocumentEvent e) {
				bloqueo();
			}
			
			public void insertUpdate(DocumentEvent e) {
				bloqueo();
			}
			
			public void changedUpdate(DocumentEvent e) {
				bloqueo();
			}
			public void bloqueo() {
				if(referenciaTf.getText().length()>10) {
					refOk = false;
					JOptionPane.showMessageDialog(frame, "La referencia no puede superar los 10 caracteres.");
				}else {
					refOk = true;
					referencia = referenciaTf.getText();
				}
			}
		});
		frame.getContentPane().add(referenciaTf);
		
		//Nombre
		nombreTf = new JTextField();
		nombreTf.setBounds(20,80,100,20);
		nombreTf.getDocument().addDocumentListener(new DocumentListener() {
			
			public void removeUpdate(DocumentEvent e) {
				bloqueo();
			}
			
			public void insertUpdate(DocumentEvent e) {
				bloqueo();
			}
			
			public void changedUpdate(DocumentEvent e) {
				bloqueo();
			}
			public void bloqueo() {
				if(nombreTf.getText().length()>50) {
					nomOk = false;
					JOptionPane.showMessageDialog(frame, "El nombre no puede superar los 50 caracteres.");
				}else {
					nomOk = true;
					nombre = nombreTf.getText();
					
				}
			}
			
		});
		frame.getContentPane().add(nombreTf);
		
		//Descripcion
		descripcionTf = new JTextField();
		descripcionTf.setBounds(20,120,100,20);
		descripcionTf.getDocument().addDocumentListener(new DocumentListener() {
			
			public void removeUpdate(DocumentEvent e) {
				bloqueo();
			}
			
			public void insertUpdate(DocumentEvent e) {
				bloqueo();
			}
			
			public void changedUpdate(DocumentEvent e) {
				bloqueo();
			}
			public void bloqueo() {
				if(descripcionTf.getText().length()>50) {
					descOk = false;
					JOptionPane.showMessageDialog(frame, "La descripción no puede superar los 200 caracteres.");
				}else {
					descOk = true;
					descripcion = descripcionTf.getText();
					
				}
			}
		});
		frame.getContentPane().add(descripcionTf);
		
		//Cantidad
		cantidadTf = new JTextField();
		cantidadTf.setBounds(20,160,100,20);
		cantidadTf.getDocument().addDocumentListener(new DocumentListener() {
			
			public void removeUpdate(DocumentEvent e) {
				bloqueo();
			}
			
			public void insertUpdate(DocumentEvent e) {
				bloqueo();
			}
			
			public void changedUpdate(DocumentEvent e) {
				bloqueo();
			}
			public void bloqueo() {
				try {
					int cant = Integer.parseInt(cantidadTf.getText());
					if(cantidadTf.getText().length()>4 || cant == 0) {
						cantOk = false;
						JOptionPane.showMessageDialog(frame, "La cantidad no puede superar los 4 digitos ni ser 0.");
					}else {
						cantOk = true;
						cantidad = cant;
						
					}
				} catch (NumberFormatException e) {
					cantOk = false;
					JOptionPane.showMessageDialog(frame, "La cantidad ha de ser un número, máximo 4 dígitos.");
				}
								
				
			}
		});
		frame.getContentPane().add(cantidadTf);
		
		//Precio
		precioTf = new JTextField();
		precioTf.setBounds(20,200,100,20);
		precioTf.getDocument().addDocumentListener(new DocumentListener() {
			
			public void removeUpdate(DocumentEvent e) {
				bloqueo();
				
			}
			
			public void insertUpdate(DocumentEvent e) {
				bloqueo();
				
			}
			
			public void changedUpdate(DocumentEvent e) {
				bloqueo();
				
			}
			public void bloqueo() {
				try {
					double prec = Double.parseDouble(precioTf.getText());
					if(precioTf.getText().length()>6 | prec == 0) {
						cantOk = false;
						JOptionPane.showMessageDialog(frame, "La cantidad no puede superar los 6 digitos, ni ser 0,");
					}else {
						cantOk = true;
						precio = prec;
						if(refOk & nomOk & descOk & cantOk & preOk == true) {
							botonGuardar.setEnabled(true);
						}
					}
				} catch (NumberFormatException e) {
					cantOk = false;
					JOptionPane.showMessageDialog(frame, "La cantidad ha de ser un número, máximo 6 dígitos.");
				}
			}
		});
		frame.getContentPane().add(precioTf);
		botonGuardar.setBounds(20, 230, 100, 20);
		botonGuardar.addMouseListener(new MouseListener() {
			
			public void mouseReleased(MouseEvent e) {}
			
			public void mousePressed(MouseEvent e) {}
			
			public void mouseExited(MouseEvent e) {}
			
			public void mouseEntered(MouseEvent e) {}
			
			public void mouseClicked(MouseEvent e) {
				// TODO Recoger los datos de los ET
				addProducto(referencia, nombre, descripcion, cantidad, precio);	
				JOptionPane.showMessageDialog(frame, "Producto \""+ nombre+"\" añadido.");
			}
		});
		frame.getContentPane().add(botonGuardar);
		botonAtras = new JButton("Atrás");
		botonAtras.setBounds(150, 230, 100, 20);
		botonAtras.addMouseListener(new MouseListener() {
			
			public void mouseReleased(MouseEvent e) {}
			
			public void mousePressed(MouseEvent e) {}
			
			public void mouseExited(MouseEvent e) {}
			
			public void mouseEntered(MouseEvent e) {}
			
			public void mouseClicked(MouseEvent e) {
				//VOLVER AL MENU PRINCIPAL
				atrasMenu();
			}
		});
		frame.getContentPane().add(botonAtras);
	
		
	}
	public void setVisible() {
		frame.setVisible(true);
	}
	
	protected void addProducto(String ref, String nom, String desc, int cant, double prec) {
		//Envia la info al controlador
	}
	
	protected void atrasMenu() {
		frame.dispose();
	}
	
	class Lamina extends JPanel {
		public Lamina() {
			
		}
		@Override
		protected void paintComponent(Graphics g) {
			// TODO Auto-generated method stub
			super.paintComponent(g);

			g.drawString("Referencia", 20, 20);

			g.drawString("Nombre", 20, 60);

			g.drawString("Descripción", 20, 100);

			g.drawString("Cantidad", 20, 140);

			g.drawString("Precio", 20, 180);
	

		}

	}
}
