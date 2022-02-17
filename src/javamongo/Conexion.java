package javamongo;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;

/**
 *
 * @author Jean_
 */
public class Conexion {
   DB BaseDatos;
   DBCollection coleccion;
   BasicDBObject document = new BasicDBObject();
   
   public Conexion(){
       try {
           Mongo mongo = new Mongo("localhost", 27017);
           BaseDatos = mongo.getDB("zapateria");
           coleccion = BaseDatos.getCollection("producto");
           System.out.println("Conexión establecida");
       } catch (Exception e) {
           e.printStackTrace();
       }
   }
   
   public boolean insertar(Double precio){
       document.put("precio" , precio);
       coleccion.insert(document);
       return true;
   }
   
   public void mostrar(){
       DBCursor cursor = coleccion.find();
       while(cursor.hasNext()){
           System.out.println(cursor.next());
       }
   }
   
   public boolean actualizar(Double precioViejo, Double precioNuevo){
       document.put("precio", precioViejo);
       BasicDBObject documentNuevo = new BasicDBObject();
       documentNuevo.put("precio", precioNuevo);
       coleccion.findAndModify(document, documentNuevo);
       return true;
   }
   
   public boolean eliminar(Double precio){
       document.put("precio" , precio);
       coleccion.remove(document);
       return true;
   }
}
