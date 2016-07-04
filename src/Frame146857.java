import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.LinkedList;
/**
 *   class Frame Menu
 *   Este frame incluye un MenuBar , un scroll Bar , un JTextArea ,
 *   un menu de Acciones y sus 7 items
 *  al seleccionar uno de los items sale un JInput Dialog con el cual el usuario puede elegir que dato va a agregar , buscar , eliminar y desplegar
 * @author Sean Burger
 */

public class Frame146857 extends JFrame implements ActionListener  
{

//----------------------------------
//    Cualidades del frame
//----------------------------------

    /**
     * Ancho por default del frame
     */
     int Frame_Width    = 500;

    /**
     * Altura default del frame
     */
     int Frame_Height   = 250;

    /**
     * coordenada en el eje de las x del frame
     */
     int Frame_X_Origin = 150; 

    /**
     * coordenada en el eje de las y del frame
     */
     int FRAME_Y_ORIGIN = 250;

    /**
     * Al seleccionar se muestra texto como respuesta
     */
 //    private static String fileSeparator  = System.getProperty("file.separator");
     

    /**
     * Grupo de Archivo
     */
    private JMenu    AccionesMenu;
    private JTextArea  textArea;
    public ListaLigadaDoble146857 miLista;

//----------------------------------
//      metodo Main
//----------------------------------
    public static void main(String[] args) {
        Frame146857 frame = new Frame146857();
        frame.setVisible(true);
    //    ListaLigadaDoble = new ListaLigadaDoble ();
    }

//----------------------------------
//    Constructores
//----------------------------------

    /**
     * constructor default
     */
    public Frame146857()
    {
        Container contentPane; 
    //	String  entrada ;
    	//int tam;

        //usamos para ponerle las propiedades al frame.
        setTitle     ("FrameMenu1");
        setSize      (Frame_Width, Frame_Height);
        setResizable (false);
        setLocation  (Frame_X_Origin, FRAME_Y_ORIGIN);

// Nuevamente usamos contentPane para ponerle color al frame asi como su layout.
        contentPane = getContentPane( );
        contentPane.setLayout(null);
        contentPane.setBackground( Color.green ); 
        // creamos 2 menus con sus items menu
        //create two menus and their menu items
        crearAccionesMenu();
        
  
        //Los añadimos al menubar
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);  
        menuBar.add(AccionesMenu);
        
        //creamos , posicionamos y agregamos el JTEXTAREA.
        //tambien ponemos un Scroll para poder movernos atraves del JTextArea cuando este muy lleno
        textArea = new JTextArea();
        textArea.setBounds(5, 5, Frame_Width-15, Frame_Height-65);
        textArea.setBorder(BorderFactory.createLineBorder(Color.red));
        textArea.setEditable(false);
        JScrollPane scrollText= new JScrollPane(textArea);
        scrollText.setBounds (5, 5, Frame_Width-15, Frame_Height-65);
        scrollText.setBorder(BorderFactory.createLineBorder(Color.red));
        contentPane.add(scrollText);
     
        
       

        
// Con el siguiente metodo  va a salir del programa cuando se cierre el frame.
        setDefaultCloseOperation(EXIT_ON_CLOSE);

	//	entrada=JOptionPane.showInputDialog(null,"De qué tamaño va a ser el arreglo?");
		//tam=Integer.parseInt(entrada);
		miLista = new ListaLigadaDoble146857(); 
    }


//-------------------------------------------------
//     Metodos publicos
//
//          void    actionPerformed   (   ActionEvent        )
//
//------------------------------------------------

    /**
     * Standard method to respond the action event.
     *
     * @param event the ActionEvent object
     *
     */
    public void actionPerformed(ActionEvent event) {
        String  menuName, entrada;
        int d,pos = 0;
        
        
        menuName = event.getActionCommand();
// Al click en salir se sale del programa y cierra el frame
        if (menuName.equals("Salir")) {
           System.exit(0);
        } else { //Se abre el fileChooser y permite al usuario guardar el archivo y los cambios hechos.
        		
		        	if (menuName.equals("Agregar dato")) {
		        		entrada=JOptionPane.showInputDialog(null,"Dato que vas a agregar:"); //Llamo al metodo agredar  de mi lista al dar clic 
		        		d=Integer.parseInt(entrada);  //en agregar dato y aparece mi InputDialog que pregunta el dato a agergar y lo inserta
		        		if(miLista.agregar(d)==0)
		        			JOptionPane.showMessageDialog(null,"El dato no se pudo insertar."); 
		        		textArea.setText(miLista.desplegar()); 
		             } else { //Llamo al metodo eliminar y pregunto cual es el dato , tomando en cuenta que el dato puede no estar en la lista o estar vacia
		            	 if (menuName.equals("Eliminar dato")) {
		            		 	entrada=JOptionPane.showInputDialog(null,"Dato que vas a eliminar:");
		             			d=Integer.parseInt(entrada);
		             			pos = miLista.delete(d);  
		               		if(pos==0)
		            			JOptionPane.showMessageDialog(null,"La lista esta vacía.");
		               		else if(pos==-1)
		               			JOptionPane.showMessageDialog(null,"El dato no esta en la lista.");
		               		else textArea.setText(miLista.desplegar());
		                  } else {// aqui solo busco un dato funciona de manera similar a eliminar pero aqui el dato no es eliminado solo se muestra en JTextArea 
		                	  if (menuName.equals("Buscar")) { //indicando su posicion
		                		  entrada=JOptionPane.showInputDialog(null,"Dato que vas a buscar:");
		                   			d=Integer.parseInt(entrada); 
		                   			pos = miLista.buscar(d);
		                   			
			                   		if(pos == 0)
			                   		{
			                   			textArea.append("\n El dato que buscas no se encuentra."); //Muestro si el dato no esta
			                   		}
			                   		else{
			                   			textArea.append("\n El dato "+d+" se encuentra en la posición "+pos);   
		                	  // muestro el dato y la posicion en la que se encuentra              			
		                   		}
		                  }
		             }
		             }
        }
    }
    
		                   		
		                       
		             
		        	
    

//-------------------------------------------------
//      Metodos Privados
//
//          void   crearAccionesMenu   (           )
//          
//
//------------------------------------------------

    /**
     * Creamos el AccionesMenu y le añadimos sus items
     *
     */ 
    private void crearAccionesMenu( ) {
        JMenuItem    item; 
        JMenu       fileMenu = new JMenu();
        JMenuBar    menuBar  = new JMenuBar();

        AccionesMenu = new JMenu("Acciones");
        
        
        item = new JMenuItem("Agregar dato");        //Agregar dato
        item.addActionListener( this );
        AccionesMenu.add( item );

        item = new JMenuItem("Eliminar dato");    //Eliminar dato ...
        item.addActionListener( this );
        AccionesMenu.add( item );
        
       

        item = new JMenuItem("Desplegar");       //Desplegar 
        item.addActionListener( this );
        AccionesMenu.add( item );
    
        AccionesMenu.add( item );
        item = new JMenuItem("Buscar");
        item.addActionListener( this );
        AccionesMenu.add( item );

        AccionesMenu.addSeparator();           //añadimos una barra horizontal separadora

        item = new JMenuItem("Salir");       //Salir
        item.addActionListener( this );
        AccionesMenu.add( item );
       
        setJMenuBar(menuBar);
        menuBar.add(fileMenu);  //Añadimos el menubar a fileMenu.
    }
    }