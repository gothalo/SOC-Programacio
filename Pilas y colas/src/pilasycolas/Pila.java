
package pilasycolas;

/**
 * Guarda Strings en una estructura de pila (LIFO).
 * @author llorenc
 */
public class Pila implements StorageInterface {
    
    // aqui guardaremos la informacion
    private String almacen [];
    private int primeraLibre;
    
    // tamaño por defecto de la matriz de almacenamiento
    // private final static int CAPACIDAD = 10;
    
    /**
     * Crea una pila capaz de almacenar un máximo de elementos indicados por la 
     * constante CAPACIDAD
     */
    public Pila () {
        // almacen = new String [CAPACIDAD];
        this (CAPACIDAD);
        
    }
    
    /**
     * Crea una pila capaz de almacenar un máximo de elementos igual al valor 
     * recibido como parámetro.
     * 
     * @param capacidadPersonalizada tamaño máximo de la cola.
     * 
     */
    public Pila (int capacidadPersonalizada) {
        // definimos la matriz
        almacen = new String [capacidadPersonalizada];
        
        // llenamos todos los elementos con cadenas vacias.
        for (int i = 0; i < almacen.length; i++) {
            almacen [i] = "";
        }
        
        // marcamos el primer elemento como la proxima posición disponible.
        primeraLibre = 0;
    }
    
    /**
     * recupera el primer elemento de la pila
     * @return 
     */
    @Override
    public String leer () throws StorageEmptyException {
        String elemento;
        int ultimo;
        
        // verificamos que la pila no este vacia
        if (primeraLibre == 0) {
            elemento = "--- Pila Vacia ---";
            throw new StorageEmptyException("Pila Vacia.");
            
        } else {
            ultimo = primeraLibre - 1;
            // recuperamos el elemento en la posicion pilaLibre
            elemento = almacen [ultimo];
            // borramos el elemento
            almacen [ultimo] = "";
            // retrocedemos el marcador de lectura en una posicion
            primeraLibre --;
            

        }
        return elemento;
    }
    
    /**
     * almacena una String en la pila de almacenamiento
     * @param elemento String a guardar 
     */
    @Override
    public boolean guardar (String elemento) {
        
        // verificamos que haya espacio en la pila
        if (primeraLibre < almacen.length) {
            // añadimos el nuevo elemento a la pila
            almacen [primeraLibre] = elemento;
            
            // marcamos la siguiente posición como primera libre
            primeraLibre++;
            
            return true;
        } else {
            System.out.println("Pila llena");
            return false;
        }
    
    }
    
    
}
