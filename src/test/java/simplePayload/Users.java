package simplePayload;


public class Users {

	// Define data items
	String firstName;
	String lastName;
	int fideRating;
	int id;

	// Create a constructor for serialization
	public Users(String firstName, String lastName, int fideRating, int id) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.fideRating = fideRating;
		this.id = id;
	}
		
	// Create a default constructor for de-serialization
	Users(){
		
	}
	
	// Getter and Setter for all of the data items
	public String getfirstName() {
		return firstName;
	}
	 
	public void setfirstName(String firstName) {
		this.firstName = firstName;
	}
	 
	public String getlastName() {
		return lastName;
	}
	 
	public void setlastName(String lastName) {
		this.lastName = lastName;
	}
	 
	public Integer getfideRating() {
		return fideRating;
	}
	 
	public void setfideRating(Integer fideRating) {
		this.fideRating = fideRating;
	}
	 
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	// POJO output post de-serialization of JSON
	public String toString(){
    	return "The user's first name is " + this.firstName + 
    			" and last name is " + this.lastName + 
    			" and fide rating is " + this.fideRating +
    			" and id is " + this.id;
    }

}
