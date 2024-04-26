
import java.util.ArrayList;
import java.util.List;

public class numeroControlador {
    private final  int[] numerosArray;
    private final  List<Integer> numerosArrayList;
   
    public numeroControlador() {
        numerosArray = new int[5];
        numerosArrayList = new ArrayList<>();
    }

    public boolean agregarArreglo(int nuevoNumero) {
        for (int i = 0; i < numerosArray.length; i++) {
            if (numerosArray[i] == 0) {
                numerosArray[i] = nuevoNumero;
                return true;
            }
        }
        return false; 
    }
    
        public int buscarArreglo(int numeroB) {
        for (int i = 0; i < numerosArray.length; i++) {
            if (numerosArray[i] == numeroB) {
                return i; 
            }
        }
        return -1; 
    }
 
   public boolean eliminarArreglo(int numeroEliminar) {
    boolean respuesta=false;
    for (int i = 0; i < numerosArray.length; i++) {
        if (numerosArray[i] == numeroEliminar) {
            numerosArray[i] = 0; 
            respuesta=true;
        }
    }
    return respuesta;
}
   
public String obtenerArreglo() {
    StringBuilder cadena = new StringBuilder();

  for (int i = 0; i < numerosArray.length; i++) {
      cadena.append("Elemento ").append(i).append(": ").append(numerosArray[i]);      
      if (i < numerosArray.length - 1) {
          cadena.append("\n"); 
      }
    }
    return cadena.toString();
}
  
public boolean agregarArrayList(int nuevoNumero) {
    if (numerosArrayList.contains(null)) {
        int index = numerosArrayList.indexOf(null);
        numerosArrayList.set(index, nuevoNumero);
        return true;
    } else if (numerosArrayList.size() < 5) {
        numerosArrayList.add(nuevoNumero);
        return true;
    } else {
        return false;
    }
}

 
public int buscarArrayList(int numeroBuscar) {
    int posicion = numerosArrayList.indexOf(numeroBuscar);
    return posicion; 
    }

  
public boolean eliminarArrayList(int numeroEliminar) {
    boolean respuesta = false;

    for (int i = 0; i < numerosArrayList.size(); i++) {
        if (numerosArrayList.get(i) == numeroEliminar) {
            numerosArrayList.set(i, null); 
            respuesta = true;
        }
    }

    return respuesta;
}

    
   public String obtenerArrayList() {
    String cadena = "";
        System.out.println("Números ingresados:");
        for (Integer num : numerosArrayList) {
            
            cadena = cadena + "numero " + num + "\n";
        
            }
        return cadena;

    
    
}
   
}


