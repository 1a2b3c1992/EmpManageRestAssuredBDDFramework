package Endpoints;

public interface EmpEndPoints {

	final static String POST_EMPLOYEE ="/employees" ;
	
	final static String GET_SINGLE_EMPLOYEE = "/employees/{id}";
	
	final static String GET_ALL_EMPLOYEE ="/employees" ;
	
	// Capture Customer Information as per condition and by adding Query Parameter
	
	final static String GET_EMPLOYEE_ON_CONDITION ="/employees" ;
	
	final static String PUT_EMPLOYEE  = "/employees/{id}";

	final static String DELETE_EMPLOYEE  = "/employees/{id}";

}
