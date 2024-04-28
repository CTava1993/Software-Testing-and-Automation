package service;

// Christian Tavares || CS 320 Software Test and Automation || 4/12/24
// ------------------------------------------------------------------------------------------------
// This class contains all of the data for a task object, as well as getter/setter functions for
// all of the data that is capable of being edited. Id values will be unchangeable so there is
// only a getter function.
//
// No variables can be null when the object is instantiated. Id variables have a 10 character 
// limit, name has a 20 character limit, and the description will have a 50 character limit.
// ------------------------------------------------------------------------------------------------

public class Task {
	
	//Instance variables
	
	private String id;
	private String name;
	private String description;
	
	public Task(String id, String name, String description) { //Task object initialize
		
		if(id == null || id.length() > 10 ) {
			throw new IllegalArgumentException("Invalid id"); //Id cannot be longer than 10 characters or null
		}
		if(name == null || name.length() > 20 ) {
			throw new IllegalArgumentException("Invalid name"); //Name cannot be longer than 20 characters or null
		}
		if(description == null || description.length() > 50 ) {
			throw new IllegalArgumentException("Invalid description"); //Description cannot be longer than 50 characters or null
		}
		
		this.id = id;
		this.name = name;
		this.description = description; //Set variables
		
	}
	
	public String getId() { //Getter function for Id (cannot be edited)
		return this.id;
	}
	
	public String getName() { //Getter function for Name
		return this.name;
	}
	
	//TODO Create an if-else branch to ensure name isn't too long or null
	void setName(String name) { //Setter function for Name
		this.name = name;
	}
	
	public String getDescription() { //Getter function for Description
		return this.description;
	}
	
	//TODO Create an if-else branch to ensure description isn't too long or null
	void setDescription(String description) { //Setter function for Name
		this.description = description;
	}
	
}
