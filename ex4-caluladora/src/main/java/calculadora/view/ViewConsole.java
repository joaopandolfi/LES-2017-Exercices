package calculadora.view;

import java.util.Scanner;

public class ViewConsole implements View{
	private Scanner read = new Scanner(System.in);
	
	public String getValue(){
		String valorLido;
		System.out.print("Insira o calculo do saci para eu calcular :D => ");
		valorLido =read.nextLine(); 
		return valorLido;
	}
	
	public void printResultado(int resultado){
		System.out.println("Resultado: "+resultado);
	}
	
	public void printError(){
		System.out.println("DEU ZICA");
	}
}
