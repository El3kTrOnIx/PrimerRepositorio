package EjemplosExplicaciones;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Test_VcoloGround_3 {

	public static void main(String[] args) {
		Wind miObject= new Wind();
		miObject.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
class Wind extends JFrame{

	static LaLamina obj=new LaLamina();  //<------- AQUI QUERIA QUITAR EL STATIC Y VER ALGUNA FORMA DE QUE FUNCIONARA SIN ESO
	Wind(){


		setTitle("Prueba de ventana");
		setBounds(0,0,600,400);
		setLocationRelativeTo(null);


		//LaLamina obj =new LaLamina();
		add(obj);						//agregamos la lamina o panel a la ventana
		setVisible(true);
	}
}
class LaLamina extends JPanel {
	static JButton botonColor =new JButton("CYAN");

	LaLamina(){
		setBackground(Color.black);
		setLayout(null);				//quita el defaul de la posicion de los objetos en el panel, por lo que nos permite moverlo 
		botonColor.setBounds(160, 60, 80, 30);	//nos permite definir el tamaño y ubicacion del boton 
		add(botonColor);

		JLabel eti=new JLabel("<----- presionar",SwingConstants.LEFT);	//llamamos el constructor en el cual podemos definir lo que
		// dice la etiqueta y su alineacion, en este caso es a la izquierda
		eti.setBounds(250, 60, 150, 30);			//definimos tamaño y ubicacion de la etiqueta
		eti.setForeground(Color.WHITE);				//define color de letra de la etiqueta
		eti.setOpaque(true);						//habilita poder cambiar el fondo de la etiqueta	
		eti.setBackground(Color.DARK_GRAY);			//define el color de fondo de la etiqueta
		eti.setFont(new Font("chiller",3,21));		//define tipo de letra, letra, cursiva,negrita y tamaño
		add(eti);									//agregamos la etiqueta a la lamina

		ImageIcon img =new ImageIcon("guia2.png");	//la imagen esta en la carpeta del proyecto
		JLabel eti2= new JLabel();
		eti2.setBounds(310, 10, 250, 313);			//recordemos que desabilitamos el defaul de posicionamiento (setLayout(null)) 
		//por lo que hay que definir una nueva ubicacion para el icono

		//Icon myIcon= new ImageIcon(getClass().getResource("guia2.png")); //creamos un objeto de la clase Icon usando el constructor de ImageIcon, la imagen debe ir en la carpeta donde esta la clase		
		//eti2.setIcon(myIcon);											   //agragamos myIcon al metodo setIcon()
		eti2.setIcon(new ImageIcon(img.getImage().getScaledInstance(250, 313, Image.SCALE_SMOOTH)));
		add(eti2);

		Ejecuta act=new Ejecuta();
		botonColor.addActionListener(act);

	}

}

class Ejecuta implements ActionListener{

	boolean flag;
	//int cont=0;
	

	public void actionPerformed(ActionEvent e) {
		//Object botonPulsado=e.getSource();
		
		//if (botonPulsado==LaLamina.botonCyan && flag==true) {
		if(flag==false) {
			LaLamina.botonColor.setText("BLACK");
			Wind.obj.setBackground(Color.cyan);			//PONIENDO EL OBJETO STATIC DE LALAMINA PUEDO LLAMARLO AQUI
			flag=true;
		}else {
			LaLamina.botonColor.setText("CYAN");
			Wind.obj.setBackground(Color.black);
			flag=false;
		}
		//System.out.println("Presionaste el boton Cyan");

		//System.out.println(cont++);

		//}

		/*
		  if ((botonPulsado==LaLamina.botonCyan) && (flag=false)) {
			System.out.println("Presionaste el boton Black");
		Test_VcoloGround_3.main(new String[] {"a"});
		flag=true;
		}
		 */
	}

}
