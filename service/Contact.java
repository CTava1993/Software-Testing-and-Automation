package service;

// Christian Tavares || CS 320 Software Test and Automation || 4/12/24
// ------------------------------------------------------------------------------------------------
// Used as an entity class that will be instantiated from the ContactService.java class whenever a
// contact is added to the ArrayList of that other class. This file contains all of the data fields
// of a contact object, complete with getter/setter functions. 
// ------------------------------------------------------------------------------------------------

public class Contact {
	
	//Instance variables
	
	private String id;
	private String firstName;
	private String lastName;
	private String phone;
	private String address;
	
	public Contact(String id, String first, String last, String number, String address) {
		
		if(id == null || id.length() > 10 ) {
			throw new IllegalArgumentException("Invalid id"); //Id must not be more than 10 characters or null
		}
		if(first == null || first.length() > 10 ) {
			throw new IllegalArgumentException("Invalid name"); //First name must not be more than 10 characters or null
		}
		if(last == null || last.length() > 10 ) {
			throw new IllegalArgumentException("Invalid name"); //Last name must not be more than 10 characters or null
		}
		if(number == null || number.length() != 10) {
			throw new IllegalArgumentException("Invalid phone number"); //Phone number must equal 10 characters and cannot be null
		}
		if(address == null || address.length() > 30 ) {
			throw new IllegalArgumentException("Invalid address"); //Address must not be more than 30 characters or null
		}
		
		this.id = id;
		this.firstName = first;
		this.lastName = last;
		this.phone = number;
		this.address = address; //Set variables
	}
	
	public String getId() { //Getter for Id (cannot be edited)
		return this.id;
	}
	
	public String getFirstName() { //Getter for First name
		return this.firstName;
	}
	
	//TODO Create an if-else branch to ensure First name isn't too long or null
	void setFirstName(String firstName) { //Setter for First name
		this.firstName = firstName;
	}
	
	public String getLastName() { //Getter for Last name
		return this.lastName;
	}
	
	//TODO Create an if-else branch to ensure Last name isn't too long or null
	void setLastName(String lastName) { //Setter for Last name
		this.lastName = lastName;
	}
	
	public String getPhoneNumber() { //Getter for Phone number
		return this.phone;
	}
	
	//TODO Create an if-else branch to ensure Phone number isn't too long or null
	void setPhoneNumber(String number) { //Setter for Phone number
		this.phone = number;
	}
	
	public String getAddress() { //Getter for Address
		return this.address;
	}
	
	//TODO Create an if-else branch to ensure Address isn't too long or null
	void setAddress(String address) { //Setter for Address
		this.address = address;
	}
}
