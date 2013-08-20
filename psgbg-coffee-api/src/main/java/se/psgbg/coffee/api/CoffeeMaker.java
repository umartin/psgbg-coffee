package se.psgbg.coffee.api;

/**
 *
 * @author Martin Andersson
 */
public interface CoffeeMaker {

	int getWaterLevel();

	void addWater();

	void insertCoffeePot(CoffeePot coffeePot);

	FilterHolder getFilterHolder();

	void pullUpDripStop();

	void start();

	void insertFilterHolder(FilterHolder filterHolder);
}
