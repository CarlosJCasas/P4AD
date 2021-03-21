package vista;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.MenuController;


public class ListaProductosVista {
		private JFrame frame;
		private JButton botonAtras;
		private DefaultTableModel model;
		public ListaProductosVista() {
			crearListaProductosVista();
		}
		
		public void crearListaProductosVista(){
			frame = new JFrame();
			frame.setBounds(515, 315, 700, 500);
			frame.setResizable(false);
			frame.getContentPane().setLayout(null);
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			frame.setTitle("Listado de productos");
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(20,20, 660, 400);
			frame.getContentPane().add(scrollPane);
			model = listaProductos();
			
			
			JTable table = new JTable();
			table.setModel(model);
			//Referencia
			table.getColumnModel().getColumn(0).setPreferredWidth(80);
			table.getColumnModel().getColumn(0).setMaxWidth(80);
			table.getColumnModel().getColumn(0).setMinWidth(80);
			//NOmbre
			table.getColumnModel().getColumn(1).setPreferredWidth(100);
			table.getColumnModel().getColumn(1).setMaxWidth(100);
			table.getColumnModel().getColumn(1).setMinWidth(100);
			//Descripcion
			table.getColumnModel().getColumn(2).setPreferredWidth(370);
			table.getColumnModel().getColumn(2).setMaxWidth(370);
			table.getColumnModel().getColumn(2).setMinWidth(370);
			//Cantidad
			table.getColumnModel().getColumn(3).setPreferredWidth(50);
			table.getColumnModel().getColumn(3).setMaxWidth(50);
			table.getColumnModel().getColumn(3).setMinWidth(50);
			//Precio
			table.getColumnModel().getColumn(4).setPreferredWidth(60);
			table.getColumnModel().getColumn(4).setMaxWidth(60);
			table.getColumnModel().getColumn(4).setMinWidth(60);
			
			table.setRowHeight(30);
			scrollPane.setViewportView(table);
			
			
			botonAtras = new JButton("Atrás");
			botonAtras.setBounds(100, 430, 100, 20);
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
		
		protected DefaultTableModel listaProductos() {
			return null;
		}
		
		protected void atrasMenu() {
			frame.dispose();
		}
}
