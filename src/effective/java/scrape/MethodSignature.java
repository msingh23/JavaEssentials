package effective.java.scrape;

public abstract class MethodSignature {

	
	public abstract int myMethod();
	
	
	//Method signature is just method name + paramener 
	//Doesn't include 
	//public abstract char myMethod();
	
	public abstract int myMethod(int param);
	
	//public abstract char myMethod(int param);
	
	
	
	//Method Signatute can have same parameter type in a different order
	// in the parameter list. This creates confusion to the client using 
	//such API interfaces.
	public abstract int myMethod(int param, String param2);
	
	public abstract int myMethod(String param2, int param);
	
	
}
