package se.psgbg.coffee.javaimpl;

import se.psgbg.coffee.api.Coffee;
import se.psgbg.coffee.api.CoffeeContainerEmptyException;
import se.psgbg.coffee.api.CoffeeMaker;
import se.psgbg.coffee.api.CoffeePot;
import se.psgbg.coffee.api.Filter;
import se.psgbg.coffee.api.FilterHolder;
import se.psgbg.coffee.api.Kitchen;
import se.psgbg.coffee.api.NoFilterFoundException;
import se.psgbg.coffee.api.Office;
import se.psgbg.coffee.api.UnknownCoffeeException;

/**
 *
 * @author Martin Andersson
 */
public class MakeCoffee {

	public void makeCoffee(Office office) {
		try {
			CoffeeMaker coffeeMaker = office.getCoffeeMaker();
			CoffeePot coffeePot = office.getCoffeePot();
			FilterHolder filterHolder = coffeeMaker.getFilterHolder();
			Kitchen kitchen = office.getKitchen();

			coffeePot.emptyAndRinse();

			int antalKoppar = Math.min(office.getNumberOfPeopleInOffice() * 3, 11);

			while (coffeeMaker.getWaterLevel() < antalKoppar) {
				coffeeMaker.addWater();
			}

			coffeePot.addLidWithPipe();
			coffeeMaker.insertCoffeePot(coffeePot);

			filterHolder.emptyAndRinse();
			coffeeMaker.insertFilterHolder(filterHolder);

			Filter filter;
			try {
				filter = kitchen.getFilter();
			} catch (NoFilterFoundException ex) {
				filter = kitchen.lookForFilterInCupboardAboveMicrowaveOven();
			}
			filterHolder.insertFilter(filter);

			for (int i = 0; i < antalKoppar; i++) {
				try {
					Coffee scoopOfCoffee = kitchen.getCoffeeContainer().getScoopOfCoffee();
					filter.addScoopOfCoffee(scoopOfCoffee);
				} catch (CoffeeContainerEmptyException ex) {
					kitchen.lookForCoffeeInThirdCupboardFromLeftUnderCounter();
					i--;
				}
			}

			coffeeMaker.pullUpDripStop();

			kitchen.activateCoffeeMakerTimer();
			coffeeMaker.start();

		} catch (UnknownCoffeeException exc) {
			office.panic();
		}
	}
}
