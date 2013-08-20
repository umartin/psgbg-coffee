package se.psgbg.coffee.tck;

import org.junit.Test;
import se.psgbg.coffee.api.Office;

/**
 *
 * @author Erik Larkö <erik.larko@purplescout.se>
 */
public class InvokeUtilTest {
	
	@Test(expected = AssertionError.class)
	public void testNoMethod() throws Exception {
		Office o = null;
		InvokeUtil.invokeMakeCoffeMethod(NoMethod.class, o);
	}
	
	@Test(expected = AssertionError.class)
	public void testWrongMethodName() throws Exception {
		Office o = null;
		InvokeUtil.invokeMakeCoffeMethod(WrongMethodName.class, o);
	}
	
	@Test(expected = AssertionError.class)
	public void testWrongMethodModifier() throws Exception {
		Office o = null;
		InvokeUtil.invokeMakeCoffeMethod(WrongMethodModifier.class, o);
	}
	
	@Test(expected = AssertionError.class)
	public void testWrongReturnType() throws Exception {
		Office o = null;
		InvokeUtil.invokeMakeCoffeMethod(WrongReturnType.class, o);
	}
	
	@Test
	public void testOk() throws Exception {
		Office o = null;
		InvokeUtil.invokeMakeCoffeMethod(AllOk.class, o);
	}
	
	private static interface NoMethod {
		
	}
	
	private static interface WrongMethodName {
		public void hej(Office o);
	}
	
	private static class WrongMethodModifier {
		private void makeCoffee(Office o) {
			
		}
	}
	
	private static interface WrongReturnType {
		public Object makeCoffee(Office o);
	}
	
	public static class AllOk {
		public void makeCoffee(Office o) {
			
		}
	}
}