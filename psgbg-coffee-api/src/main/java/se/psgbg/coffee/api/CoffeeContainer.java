package se.psgbg.coffee.api;

/**
 *
 * @author Martin Andersson
 */
public interface CoffeeContainer {

	Coffee getScoopOfCoffee() throws CoffeeContainerEmptyException;

}
