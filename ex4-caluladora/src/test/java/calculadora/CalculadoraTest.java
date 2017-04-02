package calculadora;

import calculadora.model.AplCalcular;	
import calculadora.model.AplTradutorNotacao;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class CalculadoraTest {
	AplCalcular calcular;
	AplTradutorNotacao tradutor;

	@Before
	public void before(){
		calcular = new AplCalcular();
		tradutor = new AplTradutorNotacao();
	}
	
	@Test
	public void calcularSintaxe1(){
		int resultado = 0;
		try {
			resultado = calcular.calcular("2 3 + ");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertEquals(5, resultado);
	}
		
	@Test
	public void calcularSintaxe2(){
		int resultado = 0;
		try {
			resultado = calcular.calcular("2 3 + 4 - 1 +");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertEquals(2, resultado);
	}
		
	@Test
	public void testaProcessaNotacao1(){
		String resultado;
		resultado = tradutor.processaNotacao("3+2*2");
		Assert.assertEquals("3 2 2 * + ", resultado);
	}
	
	@Test
	public void testaProcessaNotacao2(){
		String resultado;
		resultado = tradutor.processaNotacao("1+2-3*4+2");
		Assert.assertEquals("1 2 + 3 4 * - 2 + ", resultado);
	}
	
	@Test
	public void testaOcidentalToPolonesa1(){
		String resultado;
		resultado = tradutor.ocidentalToPolonesa("(3+4)*2+1");
		Assert.assertEquals("3 4 + 2 * 1 + ", resultado);
	}
	
	@Test
	public void testaOcidentalToPolonesa2(){
		String resultado;
		resultado = tradutor.ocidentalToPolonesa("(3+4)*(2+1)");
		Assert.assertEquals("3 4 + 2 1 + * ", resultado);
	}
	
	@Test
	public void testaGeral(){
		
	}
}
