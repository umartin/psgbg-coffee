package se.psgbg.coffee.javaimpl;

import org.junit.Test;

import se.psgbg.coffee.tck.TckRunner;

/**
 *
 * @author Martin Andersson
 */
public class MakeCoffeeTest {

	@Test
	public void testMakeCoffee() {
		TckRunner.runTck(new MakeCoffee());
	}
}
