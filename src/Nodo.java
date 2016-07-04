
public class Nodo {
	int dato;
	Nodo next,prev;
	

	
	//Constructores
	public Nodo (int undato){
		dato=undato;
		prev=next=null;
		
	}
	 public Nodo(int d, Nodo n, Nodo p){
	    
	        dato = d;
	        next = n;
	        prev = p;
	    }
	    /* poner liga a siguiente nodo */
	    public void setLinkNext(Nodo n)
	    {
	        next = n;
	    }
	    /* poner liga a nodo previo */
	    public void setLinkPrev(Nodo p)
	    {
	        prev = p;
	    }    
	    /* obtener liga al siguiente nodo */
	    public Nodo getLinkNext()
	    {
	        return next;
	    }
	    /* Obtener liga a nodo anteriror */
	    public Nodo getLinkPrev()
	    {
	        return prev;
	    }
	    /* guardar dato a Nodo */
	    public void setDato(int d)
	    {
	        dato = d;
	    }
	    /* obtener dato de nodo */
	    public int getDato()
	    {
	        return dato;
	    }
	}

