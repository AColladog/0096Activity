import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Random;
import java.util.Iterator;
/**
 * The responder class represents a response generator object.
 * It is used to generate an automatic response to an input string.
 * 
 * @author     Michael KÃ¶lling and David J. Barnes
 * @version    0.1 (2011.07.31)
 */
public class Responder
{   
    private HashMap<HashSet<String>, String> hm;
    private Random aleatorio;
    private ArrayList<String> respuestas;
    private HashSet<String> hs10;
    private HashSet<String> hs11;
    private HashSet<String> hs12;
    private HashSet<String> hs20;
    private HashSet<String> hs21;
    private HashSet<String> hs22;
    /**
     * Construct a Responder - nothing to do
     */
    public Responder()
    {
        hs10 = new HashSet<>();
        hs10.add("averia"); 

        hs11 = new HashSet<>();
        hs11.add("conexion");
  

        hs20 = new HashSet<>();
        hs20.add("error");

        hs21 = new HashSet<>();
        hs21.add("factura");


        hm = new HashMap <>();
        hm.put(hs10,"Nos pondremos a trabajar en su averia");
        hm.put(hs11, "Arreglaremos esa conexion");
        hm.put(hs20, "Reinicie el equipo, para ver si remite el error");
        hm.put(hs21, "Revisaremos su factura");

        aleatorio = new Random();
        respuestas = new ArrayList<>();
        respuestas.add("Me parece serio");
        respuestas.add("Nos pondremos con ello");
        respuestas.add("Reinicie el equipo");
        respuestas.add("Problemas en el pago");
        respuestas.add("Me gustaría poder ayudarle");
        respuestas.add("No se enfade");
    }

    /**
     * Generate a response.
     * @return   A string that should be displayed as the response
     */
    public HashSet<String> generateResponse(HashSet<String> entrada){
        HashSet<String> respuestaDevuelta = new HashSet<>(); 

        for(HashSet<String> key: hm.keySet()){            
            Iterator<String> it = key.iterator();            
            while(it.hasNext()){
                if(entrada.contains(it.next())){
                    respuestaDevuelta.add(hm.get(key));
                }                
            }            
        }
        if(respuestaDevuelta.isEmpty()){
            respuestaDevuelta.add( respuestas.get( aleatorio.nextInt(respuestas.size()) ) );
        }
        return respuestaDevuelta;
    }

    /** String respuesta = "";        
     *  if(hm.containsKey(entrada) ){
     *      respuesta = hm.get(entrada);    
     *  }else{
     *      int numeroObtenido = aleatorio.nextInt(respuestas.size());
     *      respuesta = respuestas.get(numeroObtenido); 
     *  }
     *  return respuesta;

     * for(String key: hm.keySet()){
     *      if(entrada.contains(key)){ 
     *           return hm.get(key);
     *      }
     * }
     *  return "That sounds interesting. Tell me more...";
     */
}

