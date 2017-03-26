/**
 * 
 */
package java.effective.scrape;

/**
 * @author manu
 *
 */
public class ConstructorArgument {

	
	//Overloaded Constructors can have same signature with jumbled order
	// of the parameter in the argument list.
	
	//This creates confusion to the client using such API interface that which constructor does what.
	public ConstructorArgument(String name, Integer number) {
		// TODO Auto-generated constructor stub
	}

	public ConstructorArgument(Integer number, String name) {
		// TODO Auto-generated constructor stub
	}



}
