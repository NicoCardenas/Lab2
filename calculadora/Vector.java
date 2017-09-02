
/**
 * @author ECI, 2017
 *
 */
public class Vector{

    public static final double MAXERROR = 0.00000000000001;
    
    private double longitud;
    private Angulo angulo;
    
    /**
     * Constructor del vector, en coordenadas polares
     * @param d longitud del vector
     * @param a angulo del vector
     */
    public Vector (double l, Angulo a) {
    }

    /**
     * Retorna la coordenada X del vector
     * @return coordenada X del vector
     */
    public double coordenadaX() {
        return 0.0;
    }

    /**
     * Retorna la coordenada Y del Vector
     * @return coordenada Y del vector
     */
    public double coordenadaY() {
        return 0.0;
    }


    /**
     * Retorna el angulo del vector
     * @return angulo del vector
     */
    public Angulo angulo () {
        return null;
    }


    /**
     * Retorna la longitud del vector
     * @return la longitud del origen al vector
     */
    public double longitud() {
        return 0.0;
    }
    
    /**
     * Retorna la distancia entre este vector y otro vector
     * @return distancia del origen al vector
     */
    public double distancia(Vector otro) {
        return 0.0;
    }
    
    /**
     * Compara este vector con otro. Serán iguales si la distancia entre ellos es menor que MAXERROR
     * @param v el vector a comparar con este
     */
    private boolean equals (Vector v) {
        return false;
    }

    /** 
     * Compara si este Vector es igual al parametro (debe ser tambien un vector)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    public boolean equals (Object o) {
            return this.equals ((Vector) o);
    }
    
    /**
     * Translada el vector, dados los desplazamientos en x, y
     *
     * @param dx Desplazamiento en el eje x
     * @param dy Desplazamiento en el eje Y
     */
    public void traslade (double dx, double dy) {
    }
    
    /**
     * Calcula el producto escalar
     * @param escalar El factor de multiplicación de la distancia respecto al centro.
     */
    public void productoEscalar(double escalar) {
    }

    /**
     * Rota el vector el angulo dado, con respecto al origen. 
     * Es decir que el angulo resultante, es la suma del angulo dado con el angulo inicial del vector, 
     * y la distancia es la misma.
     */
    public void rote(Angulo a) {
    }

    public  void  sume(Vector v){
    }
    
    public void reste(Vector v){
    }
    
    public void multiplique(Vector v){
    }
    
    
    /** 
     * Retorna una cadena que describe a este punto (en coordenadas cartesianas)
     */
    @Override
    public String toString () {
          String s = "";
          return s;
    }

}
