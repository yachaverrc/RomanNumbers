public class Correct{


  public static String correcto (String linea){
   
    String res = new String();
    String[] igual = linea.split("=");
    String[] sumas = igual[0].split("\\+");

    int resultado = convertir(igual[1]);
    int suma1 = convertir(sumas[0]);
    int suma2 = convertir(sumas[1]);
    int suma = suma1 + suma2;

    if(suma == resultado)
      res = "Correct";
    else res = "Incorrect";

    return res;
  }
   
  public static int convertir(String romano){
    
    int total=0;

    for(int i=0; i < romano.length(); i++){
      int actual = equivalencia(romano.charAt(i));

      if((i < romano.length() - 1) && 
         (equivalencia(romano.charAt(i+1)) > actual)){
        actual = actual*(-1);
      }
      
      total += actual;
    }
    return total;
  }
  
  public static int equivalencia(char caracter){
   
    int res=0;
    switch(caracter){
      case 'I':
        res = 1;
        break;
      case 'V':
        res = 5;
        break;
      case 'X':
        res = 10;
        break;
      case 'L':
        res = 50;
        break;
      case 'C':
        res = 100;
        break;
      case 'D':
        res = 500;
        break;
      case 'M':
        res = 1000;
      default:
      res = 0;
    }
    return res;
  }
}