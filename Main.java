/*
  Parcial 1 EDA2: Fuerza Bruta y Backtracking
  - Juan Jose Aristizabal
  - Stiven Yepes
  - Yhilmar Chaverra
*/
import java.util.Scanner;
import java.util.ArrayList;


class Main {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    Correct c = new Correct();
    Valid v = new Valid();

    ArrayList<String> cadena = new ArrayList<String>();
    cadena.add(scan.nextLine());
    
    while(!(cadena.get(cadena.size()-1).equals("#"))){
      cadena.add(scan.nextLine());
    }


    for(int i=0; i<cadena.size()-1; i++){

      String linea = cadena.get(i);
      String correcto = c.correcto(linea);
      String valido = v.valido(linea);
      
      System.out.println(correcto + " "+ valido);
    }
  }


}
