/**
 * Esta clase sirve para manejar angulos. 
 * La medida de los ángulos podrá especificarse en grados, radianes, o gradianes 
 * y podrá solicitarse en cualquiera de estas unidades, independientemente de con cual hayan sido creados.
 * Internamente se harán las conversiones que sean necesarias.
 * Lo trabajaremos mediante objetos inmutables, es decir, sin métodos modificadores. 
 * @author ECI, 
 */
public class Angulo {

    /** Constantes para indicar que el argumento está en radianes */
    public static final int RADIANES = 0;
    /** Constantes para indicar que el argumento está en grados */
    public static final int GRADOS = 1;
    /** Constantes para indicar que el argumento está en gradianes */
    public static final int GRADIANES = 2;
    
    private double valorA;
    private int tipoA;

    /** Constante para maximo error admitido al comparar dos angulos.  
     *  Recuerde que los cálculos en el computador con variables de plunto flotante
     *  tienen una precisión limitada, y se requiere un margen de tolerancia
     */
    public static final double MAXERROR = 0.00000000000001;
    public static final double PI = 3.14159265358979;

    /** Crea un angulo a partir del valor dado en grados o en radianes
     * @param valor el valor de medida del angulo
     * @param tipo Tipo de medida del angulo: puede ser GRADOS, RADIANES, GRADIANES
     */
    public Angulo (double valor, int tipo){
        if (-1 < tipo && tipo < 3){
            valorA = valor;
            tipoA = tipo;
        }
    }
    
    /**Valor del angulo en grados
     * @return el valor del angulo en grados, 0 <= result < 360
     */
    public double grados () {
        double grado = valorA;
        if (tipoA == 0){
            grado = (valorA*(57.295779513082320876798154814105));
        }else if(tipoA == 2){
            grado = (valorA*(0.9));       
        }
        while (grado >= 360){
            grado = grado-360;
        }
        while (0 > grado){
            grado = grado+360;
        }
        return grado;
    }
    
    /**Valor del angulo en radianes
     * @return el valor del angulo en radianes, 0 <= result < 2*PI
     */
    public double radianes () {
        double radian = valorA;
        if (tipoA == 1){
            radian = (valorA*(0.01745329251994329576923690768489));        
        }else if(tipoA == 2){
            radian = (valorA*(0.0157079632679489661923132169164));
        }
        while (radian >= (2*PI)){
            radian = radian-(2*PI);
        }
        while (0 > radian){
            radian = radian+(2*PI);
        }
        return radian;
    }
    
    /**Valor del angulo en gradianes
     * @return el valor del angulo en gradianes, 0 <= result < 400
     */
    public double gradianes () {
        double gradian = valorA;
        if (tipoA == 0){
            gradian = (valorA*(63.661977236758134307553505349006));            
        }else if(tipoA == 1){
            gradian = (valorA*(1.1111111111111111111111111111111));
        }
        while (gradian >= 400){
            gradian = gradian-400;
        }
        while (0 > gradian){
            gradian = gradian+400;
        }
        return gradian;
    }
    
    /**
     * Suma este angulo con otro. Retorna un nuevo angulo
     * @param a El angulo a sumar
     * @return this + a
     */
    public Angulo sume (Angulo ang) {
        Angulo newAngul = null;
        if (this.getTipo() == 0){
            newAngul = new Angulo(this.getValor() + ang.radianes(), this.getTipo());
        }else if (this.getTipo() == 1){
            newAngul = new Angulo(this.getValor() + ang.grados(), this.getTipo());
        }else if (this.getTipo() == 2){
            newAngul = new Angulo(this.getValor() + ang.gradianes(), this.getTipo());
        }
        return newAngul;
    }

    /**
     * Resta este angulo con otro. Retorna un nuevo angulo
     * @param a El angulo a sumar
     * @return this - a
     */
    public Angulo reste (Angulo a) {
        Angulo newAngul = null;
        if (this.getTipo() == 0){
            newAngul = new Angulo(this.getValor() - a.radianes(), this.getTipo());
        }else if (this.getTipo() == 1){
            newAngul = new Angulo(this.getValor() - a.grados(), this.getTipo());
        }else if (this.getTipo() == 2){
            newAngul = new Angulo(this.getValor() - a.gradianes(), this.getTipo());
        }
        return newAngul;
    }

    /**
     * Multiplica este angulo con otro. Retorna un nuevo angulo
     * @param a El angulo a multiplicar
     * @return this * a
     */
    public Angulo multiplique (Angulo ang) {
        Angulo newAngul = null;
        if (this.getTipo() == 0){
            newAngul = new Angulo(this.getValor() * ang.radianes(), this.getTipo());
        }else if (this.getTipo() == 1){
            newAngul = new Angulo(this.getValor() * ang.grados(), this.getTipo());
        }else if (this.getTipo() == 2){
            newAngul = new Angulo(this.getValor() * ang.gradianes(), this.getTipo());
        }
        return newAngul;
    }

    /**
     * Divide este angulo con otro. Retorna un nuevo angulo
     * @param a El angulo a dividir
     * @return this / a
     */
    public Angulo divida (Angulo a) {
        Angulo newAngul = null;
        if (this.equals(a)){
            newAngul = new Angulo (1, this.getTipo());
        }else{
            newAngul = new Angulo (this.getValor(), this.getTipo());
        }
        return newAngul;
    }
    
    
    /**
     * Multiplica esta angulo por un real
     * @param r real para hacer el producto 
     * @return r * this
     */
    public Angulo multiplique (double r) {
        return new Angulo(this.getValor() * r, this.getTipo());
    }
    
    /**
     * Compara a este angulo con otro, para ver si son iguales, 
     * teniendo en cuenta el margen de error MAXERROR, dado que se trabaja con punto flotante
     * @param a angulo para compararse
     * @return |this - a| < MAXERROR
     */
    public boolean equals (Angulo a) {
        boolean res = false; 
        double x = this.grados(), y = a.grados();
        if (x == y || x+MAXERROR == y || x-MAXERROR == y || x == y+MAXERROR || x == y-MAXERROR){
            return true;
        }
        return res;
    }
    
    /** overrides Object.equals()
     * @see java.lang.Object#equals(java.lang.Object)
     */
    public boolean equals (Object o) {
        Angulo a = (Angulo) o;
        return equals (a) ;
    }

    /**Calcula el seno
     * @return el seno de este angulo
     */
    public double seno () {
        return Math.sin(this.radianes());
    }

    /**Calcula el coseno
     * @return el coseno de este angulo
     */
    public double coseno () {
        return Math.cos(this.radianes());
    }

    /**
     * Retorna el valor del angulo en grados
     * @return the information of this object
     */
    public String toString() {
      String cadena = String.valueOf(valorA);
      return cadena;
    }
    
    public double getValor(){
        return valorA;
    }
    
    public int getTipo(){
        return tipoA;
    }
}
