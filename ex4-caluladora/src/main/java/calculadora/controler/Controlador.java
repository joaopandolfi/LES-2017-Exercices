package calculadora.controler;

import calculadora.model.AplCalcular;
import calculadora.model.AplTradutorNotacao;
import calculadora.view.ViewConsole;

public class Controlador {
	private AplCalcular aplCalcular = new AplCalcular();
	private ViewConsole view = new ViewConsole();
	
	public void start(){
		Integer resultado;
		String notacao;
		try{
			notacao = view.getValue();
			notacao = AplTradutorNotacao.ocidentalToPolonesa(notacao);
			resultado = aplCalcular.calcular(notacao);
			view.printResultado(resultado);
		}
		catch(Exception e){
			view.printError();
			e.printStackTrace();
		}
	}
}
