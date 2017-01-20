package planets;

import java.util.*;
import java.io.*;

public class Orbit {
  private static Scanner reader;
  private static int numPlanets = 10;
  private static int info = 8;
  
  public static Planet[] planets = null;

  
public static void main (String [] args) throws IOException{

    
    String planetsR [][] = new String [numPlanets][info];
    String nameOfFile = "Planets.csv";
    
    
    planetsR = readFile(nameOfFile,planetsR);
    
    planets = implement(planetsR);
    
    
  }

  //Takes in from the file and gathers values
  public static String[][] readFile(String nameOfFile,String [][] planets)throws IOException{

    reader = new Scanner (new File(nameOfFile));
    reader.nextLine();

    for (int i =0; i < numPlanets; i++){
      String content1 = reader.nextLine();
      StringTokenizer st = new StringTokenizer(content1);
      for (int j =0; j < info; j++){
        planets[i][j] = st.nextToken(",");
      }
    }
    return planets;
 }
  
  
  //Makes the array of object

  public static Planet[] implement(String [][] planetsF){
	  
	  Planet[] planets = new Planet[numPlanets];
	  for (int i=0; i < numPlanets; i++ ){
		
		  planets[i] = new Planet(planetsF[i][0],Double.parseDouble(planetsF[i][1]),Double.parseDouble(planetsF[i][2]),Double.parseDouble(planetsF[i][3]),planetsF[i][4],Double.parseDouble(planetsF[i][5]),Double.parseDouble(planetsF[i][6]),Float.parseFloat(planetsF[i][7]));
		  
	  	}
	  return planets;
  }
  
  
}


