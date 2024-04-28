package service;

import java.util.Date;

// Christian Tavares || CS 320 Software Test and Automation || 4/12/24
// ------------------------------------------------------------------------------------------------
// This class contains all of the data for a Appointment object. There are only "getter" functions
// in this class, versus previous iterations of this assignment. That is because the requirements
// defined this to me. It is assumed that if there are errors with an Appointment being created, to
// simply delete the entire object and create another one.
//
// Exceptions will be thrown if any values are null upon instantiation, if the Id exceeds 10 chars,
// if the date is earlier than the current time on instantiation, or if the description exceeds 50
// characters in length. There are no "setter" functions, so no to-do comments exist to allow for
// validation when updating a field.
//------------------------------------------------------------------------------------------------

public class Appointment {
	
	// instance variables
	
	private String id;
	private Date date;
	private String description;
	
	public Appointment(String id, Date date, String description) { //Appointment object initialize
		Date currentDate = new Date();
		
		if(id == null || id.length() > 10 ) {
			throw new IllegalArgumentException("Invalid id");
		}
		if(date == null || date.before(currentDate)) { //Date cannot be set to any time earlier than instantiation
			throw new IllegalArgumentException("Invalid date");
		}
		if(description == null || description.length() > 50 ) {
			throw new IllegalArgumentException("Invalid description");
		}
		
		this.id = id;
		this.date = date;
		this.description = description;
		
	}
	
	public String getId() { //Getter function for Id (cannot be edited)
		return this.id;
	}
	
	public Date getDate() { //Getter function for Date
		return this.date;
	}
	
	public String getDescription() { //Getter function for Description
		return this.description;
	}
}
