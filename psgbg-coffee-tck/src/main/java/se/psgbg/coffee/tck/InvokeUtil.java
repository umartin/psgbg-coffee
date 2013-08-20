package se.psgbg.coffee.tck;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import org.junit.Assert;
import se.psgbg.coffee.api.Office;

/**
 *
 * @author Erik Larkö <erik.larko@purplescout.se>
 */
public class InvokeUtil {

	public static void invokeMakeCoffeMethod(Class<?> clazz, Office officeMock) throws Exception {
		Method m = getAndVerifyMakeCoffeMethod(clazz);
		Object instance = clazz.newInstance();
		
		m.invoke(instance, officeMock);
	}

	private static Method getAndVerifyMakeCoffeMethod(Class<?> clazz) throws SecurityException {
		for (Method m : clazz.getDeclaredMethods()) {
			if (m.getName().equals("makeCoffee")) {

				Assert.assertTrue(Modifier.isPublic(m.getModifiers()));
				Assert.assertEquals(m.getReturnType(), Void.TYPE);
				Assert.assertArrayEquals(m.getParameterTypes(), new Class<?>[] {Office.class});
				return m;
			}
		}
		Assert.fail("No method named makeCoffe found");
		return null;
	}
}
