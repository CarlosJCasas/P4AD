package vista;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controller.MenuController;

public class ImportarProductosVista {
	private JFrame frame;
	private JTextField textFieldNombre;
	private JButton botonAceptar, botonAtras;
	private String nombreXml;

	public ImportarProductosVista() {
		crearImportarProductoVista();
	}

	public void crearImportarProductoVista() {
		frame = new JFrame();
		frame.setBounds(550, 350, 600, 400);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setTitle("Baja de producto");

		JLabel nombreArchivo = new JLabel("Nombre del archivo XML");
		nombreArchivo.setBounds(20, 30, 150, 20);
		frame.getContentPane().add(nombreArchivo);

		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(20, 60, 100, 20);
		frame.getContentPane().add(textFieldNombre);

		botonAceptar = new JButton("Aceptar");
		botonAceptar.setBounds(20, 90, 100, 20);
		botonAceptar.addMouseListener(new MouseListener() {

			public void mouseReleased(MouseEvent e) {
			}

			public void mousePressed(MouseEvent e) {
			}

			public void mouseExited(MouseEvent e) {
			}

			public void mouseEntered(MouseEvent e) {
			}

			public void mouseClicked(MouseEvent e) {
				File archivo = new File("src\\" + textFieldNombre.getText() + ".xml");
				if (archivo.exists()) {
					importarProductos(textFieldNombre.getText());
					JOptionPane.showMessageDialog(frame, "Productos importados.");
				} else {
					JOptionPane.showMessageDialog(frame, "El archivo indicado no existe.");

				}

			}
		});
		frame.getContentPane().add(botonAceptar);

		botonAtras = new JButton("Atrás");
		botonAtras.addMouseListener(new MouseListener() {

			public void mouseReleased(MouseEvent e) {
			}

			public void mousePressed(MouseEvent e) {
			}

			public void mouseExited(MouseEvent e) {
			}

			public void mouseEntered(MouseEvent e) {
			}

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

	protected void importarProductos(String nombreXml) {

	}
}
