package javamongo;

/**
 *
 * @author Jean_
 */
public class JavaMongo {

    public static void main(String[] args) {
        Conexion con = new Conexion();
        con.mostrar();
        con.eliminar(305.00);
        //con.actualizar(550.00, 305.00);
        //con.insertar(550.00);
        System.out.println("Mostrar");
        con.mostrar();
    }
    
}
