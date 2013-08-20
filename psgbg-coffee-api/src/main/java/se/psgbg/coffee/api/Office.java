package se.psgbg.coffee.api;

/**
 *
 * @author Martin Andersson
 */
public interface Office {

	Kitchen getKitchen();

	CoffeeMaker getCoffeeMaker();

	CoffeePot getCoffeePot();

	int getNumberOfPeopleInOffice();

	void panic();
}
