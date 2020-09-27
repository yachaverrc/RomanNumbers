import java.util.ArrayList;

public class Valid{

  public static String valido(String linea){

    int nSoluciones = 0;
    String letras = convertirALetras(linea);

    boolean[] disponibles = new boolean[10];
    for(int i=0; i<10; i++){
      disponibles[i] = true;
    }

    String[][] matriz = new String [letras.length()][2];

    for(int i=0;i<letras.length();i++){
      matriz[i][0] = String.valueOf(letras.charAt(i));
      matriz[i][1] = Integer.toString(i);
      disponibles[i] = false;
    }


    String[] entrada = linea.split("=");
    String[] valores = entrada[0].split("\\+");

    String num1 = valores[0];
    String num2 = valores[1];
    String resultado = entrada[1];

    boolean hayPermutaciones;
    do{
      int[] sumando1 = convertirAEntero(matriz, num1);
      int[] sumando2 = convertirAEntero(matriz, num2);
      int[] sumaTotal = convertirAEntero(matriz, resultado);

      if(validarSuma(sumando1, sumando2, sumaTotal)){
        nSoluciones++;
      }
      int numSimbolos = matriz.length;
      int numDigitos = 10;

      hayPermutaciones = false;
      int columnas = numSimbolos-1;

      while(!hayPermutaciones && columnas >= 0){

          int cambiar = Integer.parseInt((matriz[columnas][1]));

          disponibles [cambiar] = true;
          
          int nuevo = cambiar+1;

          while((nuevo < numDigitos) && (!disponibles[nuevo])){
            nuevo++;
          }
          if(nuevo < numDigitos){
            matriz[columnas][1] = String.valueOf(nuevo);
            disponibles[nuevo] = false;

            int c = columnas+1;
            while(c<numDigitos){
              int minimo = 0;
              while(!disponibles[minimo]){
                minimo++;
              }
              c++;
            }
          hayPermutaciones = true;
          }
          else columnas--;
        }

      
    }while(hayPermutaciones);

    if(nSoluciones == 1) return "valid";
    else if(nSoluciones > 1) return "ambiguous";
    else if(nSoluciones == 0) return "impossible";

    return "";
  }


public static String convertirALetras(String linea){
  String letras = new String();
  letras += linea.charAt(0);

  for(int i=1; i<linea.length(); i++){

    if(!(linea.charAt(i) == '+') && !(linea.charAt(i) == '=')){
      
         if(letras.indexOf(linea.charAt(i)) == -1){
           letras = letras + linea.charAt(i);
         }
    
      }
    }
  return letras;
}
  

public static int[] convertirAEntero(String matriz[][],String numero){
  
  int[] respuesta = new int[numero.length()];
  
  for(int i = numero.length()-1; i >= 0 ;i--){
    for(int j = 0; j < matriz.length; j++){
      if(numero.charAt(i) == matriz[j][0].charAt(0)){
        respuesta[i] = Integer.parseInt(matriz[j][1]);
      }
    }
  }
  
  return respuesta;
}


public static boolean validarSuma(int[] num1, int[] num2, int[] suma){
  
  boolean res = false;
  int n1 = 0;
  int n2 = 0;
  int s = 0;
  
  for(int i = 0; i<num1.length; i++){
    n1 += num1[i] * Math.pow(10, num1.length-i-1);
  }

  for(int i = 0; i<num2.length; i++){
    n2 += num2[i] * Math.pow(10, num2.length-i-1);
  }

  for(int i = 0; i<suma.length; i++){
    s += suma[i] * Math.pow(10, suma.length-i-1);
  }

  if((n1+n2) == s) {
    res = true;
    }

  return res;
}

/*
public static String[][] permutarArray(String matriz[][], boolean disponibles[]){
  int numSimbolos = matriz.length;
  int numDigitos = 10;

  boolean hayPermutaciones = false;
  int columnas = numSimbolos-1;

  while(!hayPermutaciones && columnas >= 0){

      int cambiar = Integer.parseInt((matriz[columnas][1]));

      disponibles [cambiar] = true;
      
      int nuevo = cambiar+1;

      while((nuevo < numDigitos) && (!disponibles[nuevo])){
        nuevo++;
      }
      if(nuevo < numDigitos){
        matriz[columnas][1] = String.valueOf(nuevo);
        disponibles[nuevo] = false;

        int c = columnas+1;
        while(c<numDigitos){
          int minimo = 0;
          while(!disponibles[minimo]){
            minimo++;
          }
          c++;
        }
       hayPermutaciones = true;
      }
      else columnas--;
    }
    
    return matriz;
    
  }*/
 

} 