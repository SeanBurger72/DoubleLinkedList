import javax.swing.JOptionPane;


public class ListaLigadaDoble146857 {
	//declaro mis variables
	     Nodo head;
	    Nodo end ;
	    int size;
	
	    /* Constructor */
	    public ListaLigadaDoble146857()
	    {
	        head = null;
	        end = null;
	        size = 0;
	    }//fin del constructor
	    /* Revisamos si la lista esta vacia */
	    public boolean isEmpty()
	    {
	        return head == null;
	    }
	    /* obtenemos el tamaño de la lista */
	    public int getSize()
	    {
	        return size;
	    }
	   
	    //Metodo para agregar
	    public int agregar(int d) {
	        int insertado=0 ;
	    	
	    	if (head == null) {
	            head = new Nodo(d);
	           insertado = 1;
	           size++;
	        }
	    	else {
	        if (head.dato > d) {
	            Nodo holder = head;
	            Nodo nuevoNodo = new Nodo(d);
	            head = nuevoNodo;
	            head.next = holder;
	            holder.prev = nuevoNodo;
	            insertado = 1;
	            size++;
	        } else {

	        Nodo tmpNode = head;

	        while (tmpNode.next != null && tmpNode.next.dato < d) {
	            tmpNode = tmpNode.next;
	        }

	        Nodo prevTmp = tmpNode;         
	        Nodo insertedNode = new Nodo(d);

	        if (tmpNode.next != null) {
	            Nodo nextTmp = tmpNode.next;
	            insertedNode.next = nextTmp;
	            nextTmp.prev = insertedNode;
	        } 
	        prevTmp.next = insertedNode;
	        insertedNode.prev = prevTmp;
	        insertado = 1;
	        size++;
	        }
	    	}
	        
	        return insertado;
	    }

	    
	    
	    
	    /* Eliminamos el dato  */
	    public int delete(int d) {
	    	int eliminado  =-1;
	        if (head == null) {
	           
	            eliminado = 0;
	        }else {

	        if (head.dato == d) {
	            head = head.next;
	            if (head != null) {
	                head.prev = null;
	            }
	           eliminado=1;
	           size--;
	        } else {

		        Nodo tmpNodo = head;
	
		        while (tmpNodo != null && tmpNodo.dato < d) {
		            tmpNodo = tmpNodo.next;
		        }
	
		        if (tmpNodo == null) {
		           
		          eliminado = -1;
		        } else {
	
			        if (tmpNodo.dato == d) {
			            tmpNodo.prev.next = tmpNodo.next;
			            if (tmpNodo.next != null) {
			                tmpNodo.next.prev = tmpNodo.prev;
			            }
			            eliminado =1;
				           size--;
			        }
		        }
	        }
	        }
	return eliminado ;
	    }

	    //Busco el dato
	    
	    public int buscar(int dato)
	    {      
	        int encontrado=0;
	        
	        if (size == 0) 
	        {
	            JOptionPane.showMessageDialog(null,"vacio\n");
	            
	        } else {
	        
		        Nodo ptr = head;
		        encontrado=1;
		        while (ptr != null && dato > ptr.getDato())
		        {
		            ptr = ptr.getLinkNext();
		            encontrado ++;
		        }
		        if (ptr == null || dato != ptr.getDato()) {
		           
		            encontrado = 0;
		        }   
		        }
	        return encontrado;
	    }    
	    
	    /* despliego la lista */
	    public String desplegar()
	    { String salida="";
	       
	        if (size == 0) 
	        {
	            JOptionPane.showMessageDialog(null,"empty\n");
	            
	        } else {
	        if (head.getLinkNext() == null) 
	        {
	            salida = ""+head.getDato();
	            System.out.print(head.getDato());
	        } else {
		        Nodo ptr = head;
		        System.out.print(ptr.getDato()+ " <-> ");
		        salida = salida + ptr.getDato()+ " <-> ";
		        ptr = head.getLinkNext();
		        
		        while (ptr.getLinkNext() != null)
		        {
		            System.out.print(ptr.getDato()+ " <-> ");
		            salida = salida + ptr.getDato()+ " <-> ";
		            ptr = ptr.getLinkNext();
		        }
		        System.out.print(ptr.getDato()+ "\n");
		        salida = salida + ptr.getDato()+ "\n";
	        }
	        }
	        return salida; 

	    }
	    
	}


