package se.psgbg.coffee.api;

/**
 *
 * @author Martin Andersson
 */
public interface Kitchen {

	Filter getFilter() throws NoFilterFoundException;

	CoffeeContainer getCoffeeContainer();

	Filter lookForFilterInCupboardAboveMicrowaveOven();

	void lookForCoffeeInThirdCupboardFromLeftUnderCounter();

	void activateCoffeeMakerTimer();
}
