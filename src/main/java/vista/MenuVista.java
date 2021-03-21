package vista;

import javax.swing.*;

import controller.AltaController;
import controller.BajaController;
import controller.ListaProductosController;
import controller.ProductoPorReferenciaController;

import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public abstract class MenuVista {
	private JFrame frame;
	private JTextField numEdit;
	private JButton botonguardar;
	
	private JLabel alta, baja, byref, lista, importar, exportar, salir;

	public MenuVista() {
		crearMenu();
	}

	public void crearMenu() {

		frame = new JFrame();
		frame.setBounds(500, 300, 700, 500);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Menú");
		final String hint = "Introduce el número.";
		numEdit = new JTextField();
		numEdit.setBounds(20, 290, 100, 20);
		frame.getContentPane().add(numEdit);
		
		alta = new JLabel("1. Alta producto");
		alta.setBounds(20, 20 , 250, 20);
		frame.getContentPane().add(alta);
		
		baja = new JLabel("2. Baja producto");
		baja.setBounds(20, 60 , 250, 20);
		frame.getContentPane().add(baja);
		
		byref = new JLabel("3. Obtener producto por referencia");
		byref.setBounds(20, 100 , 300, 20);
		frame.getContentPane().add(byref);
		
		lista = new JLabel("4. Listar productos");
		lista.setBounds(20, 140 , 250, 20);
		frame.getContentPane().add(lista);
		
		importar = new JLabel("5. Importar productos desde XML");
		importar.setBounds(20, 180 , 250, 20);
		frame.getContentPane().add(importar);
		
		exportar = new JLabel("6. Exportar productos a XML");
		exportar.setBounds(20, 220 , 250, 20);
		frame.getContentPane().add(exportar);
		
		salir = new JLabel("7. Salir");
		salir.setBounds(20, 260 , 250, 20);
		frame.getContentPane().add(salir);
		
		botonguardar = new JButton("Aceptar");
		botonguardar.setBounds(130, 290, 100, 20);
		botonguardar.addMouseListener(new MouseListener() {

			public void mouseReleased(MouseEvent e) {}

			public void mousePressed(MouseEvent e) {}

			public void mouseExited(MouseEvent e) {}

			public void mouseEntered(MouseEvent e) {}

			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				String opcion= "";

				try {
					opcion = numEdit.getText();
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					System.out.println("El valor no es un número.");
					e1.printStackTrace();
				}

				switch (opcion) {
				case "1":
					//Abrir el panel de Alta de producto
					AltaController altaController = new AltaController();
					altaController.setVisible();
					break;
				case "2":
					//Abrir el panel de Baja de producto
					BajaController bajaController = new BajaController();
					bajaController.setVisible();
					break;
				case "3":
					//Abrir el panel de Producto por referencia
					ProductoPorReferenciaController porReferenciaController = new ProductoPorReferenciaController();
					porReferenciaController.setVisible();
					break;
				case "4":
					//Abrir el panel de Lista de productos
					ListaProductosController listaControllere = new ListaProductosController();
					listaControllere.setVisible();
					break;
				case "5":
					//Abrir el panel de Importar de XML
					ImportarProductosVista importar = new ImportarProductosVista();
					importar.setVisible();
					break;
				case "6":
					//Abrir el panel de Exportar a XML
					ExportarProductosVista exportar = new ExportarProductosVista();
					exportar.setVisible();
					break;
				case "7":
					//SALIR
					System.exit(0);
					break;

				default:
					JOptionPane.showMessageDialog(frame, "El valor ha de ser del 1 al 7.");
					break;
				}

			}
		});
		
		frame.getContentPane().add(botonguardar);
		

	}
	
	public void setVisible() {
		frame.setVisible(true);
	}

	class Lamina extends JPanel {
		public Lamina() {
			
		}
		@Override
		protected void paintComponent(Graphics g) {
			// TODO Auto-generated method stub
			super.paintComponent(g);

			g.drawString("1. Alta producto", 20, 20);

			g.drawString("2. Baja producto", 20, 60);

			g.drawString("3. Obtener producto por referencia", 20, 100);

			g.drawString("4. Listar productos", 20, 140);

			g.drawString("5. Importar productos desde XML", 20, 180);

			g.drawString("6. Exporta productos a XML", 20, 220);

			g.drawString("7. Salir", 20, 260);
			
			

		}

	}

}
