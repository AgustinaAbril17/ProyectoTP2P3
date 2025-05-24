package Front;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.openstreetmap.gui.jmapviewer.Coordinate;
import org.openstreetmap.gui.jmapviewer.JMapViewer;
import org.openstreetmap.gui.jmapviewer.MapMarkerDot;
import org.openstreetmap.gui.jmapviewer.MapPolygonImpl;

import javax.swing.JButton;


public class VentanaPrincipal {

	private JFrame frame;
	private JMapViewer mapa;
	private JPanel panelControles;
	private ArrayList<Coordinate> lasCoordenadas;
	private MapPolygonImpl sendero;
	private JButton btnDibujarSendero ;
	private JButton btnEliminar;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal window = new VentanaPrincipal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public VentanaPrincipal() {
		initialize();
	}

	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 725, 506);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panelMapa = new JPanel();
		panelMapa.setBounds(10, 11, 437, 446);
		frame.getContentPane().add(panelMapa);
		
		
		panelControles = new JPanel();
		panelControles.setBounds(457, 11, 242, 446);
		frame.getContentPane().add(panelControles);		
		panelControles.setLayout(null);
		
		mapa = new JMapViewer();
		mapa.setZoomControlsVisible(false);
		mapa.setDisplayPosition(new Coordinate(-34.5785, -58.417), 16);
		
		panelMapa.add(mapa);
		
		detectarCoordenadas();
		dibujarSendero();
		eliminarSendero();		
	}
	
	private void detectarCoordenadas() 
	{
		lasCoordenadas = new ArrayList<Coordinate>();
				
		mapa.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
			if (e.getButton() == MouseEvent.BUTTON1)
			{
				Coordinate markeradd = (Coordinate)
				mapa.getPosition(e.getPoint());
				lasCoordenadas.add(markeradd);
				String nombre = JOptionPane.showInputDialog("Nombre: ");
				mapa.addMapMarker(new MapMarkerDot(nombre, markeradd));
			}}
		});
	}

	private void dibujarSendero() 
	{
		btnDibujarSendero = new JButton("Dibujar sendero");
		btnDibujarSendero.setBounds(10, 11, 195, 23);
		btnDibujarSendero.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				sendero = new MapPolygonImpl(lasCoordenadas);
				mapa.addMapPolygon(sendero);
			}
		});
	}

	private void eliminarSendero() 
	{
		btnEliminar = new JButton("Eliminar sendero");
		btnEliminar.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				 mapa.removeMapPolygon(sendero);
			}
		});
		btnEliminar.setBounds(10, 64, 195, 23);
		panelControles.add(btnEliminar);
		panelControles.add(btnDibujarSendero);
	}	

}
