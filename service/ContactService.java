package service;

import java.util.ArrayList;
import java.util.List;
	
// Christian Tavares || CS 320 Software Test and Automation || 4/12/24
// ------------------------------------------------------------------------------------------------
// This file has all of the principle functions for creating an instance of the Contact.java class
// and modifying all of the fields within it. createContact will make a contact to add into an
// ArrayList from the Contact class, so long as the id is unique from what exists in the list.
// ------------------------------------------------------------------------------------------------

public class ContactService {
	
	public static List<Contact> contacts = new ArrayList<Contact>(); //ArrayList of contacts
	
	public void createContact(String id, String first, String last, String number, String address) {
		
		Contact contact = new Contact(id, first, last, number, address);
		
		if(contacts.isEmpty() == true) { //If list empty, add contact to ArrayList
			contacts.add(contact);
		}
		else { //TODO Make this bit of code into its own function called findContact()
			
			for(int i = 0; i < contacts.size(); i++) { //Else, check if Id exists in ArrayList
				if(contacts.get(i).getId() == contact.getId()) {
					throw new IllegalArgumentException("Invalid id");
				}
				else {
					contacts.add(contact); //Add if Id is unique
				}
			}
			
		}
	}
	
	public void deleteContact(String id) { //Delete contact from ArrayList by Id
		
		for(int i = 0; i < contacts.size(); i++) {
			if(contacts.get(i).getId() == id) {
				contacts.remove(i);
			}
			else {
				throw new IllegalArgumentException("Contact not found"); //Id doesn't exist
			}
		}
		
	}
	
	public void updateFirstName(String id, String name) { //Update contact First name by Id
		
		for(int i = 0; i < contacts.size(); i++) {
			if(contacts.get(i).getId() == id) {
				contacts.get(i).setFirstName(name);
			}
			else {
				throw new IllegalArgumentException("Contact not found"); //Id doesn't exist
			}
		}
		
	}
	
	public void updateLastName(String id, String name) { //Update contact last name by Id
		
		for(int i = 0; i < contacts.size(); i++) {
			if(contacts.get(i).getId() == id) {
				contacts.get(i).setLastName(name);
			}
			else {
				throw new IllegalArgumentException("Contact not found"); //Id doesn't exist
			}
		}
		
	}
	
	public void updatePhoneNumber(String id, String number) { //Update contact Phone number by Id
		
		for(int i = 0; i < contacts.size(); i++) {
			if(contacts.get(i).getId() == id) {
				contacts.get(i).setPhoneNumber(number);
			}
			else {
				throw new IllegalArgumentException("Contact not found"); //Id doesn't exist
			}
		}
		
	}
	
	public void updateAddress(String id, String address) { //Update address by Id
		
		for(int i = 0; i < contacts.size(); i++) {
			if(contacts.get(i).getId() == id) {
				contacts.get(i).setAddress(address);
			}
			else {
				throw new IllegalArgumentException("Contact not found"); //Id doesn't exist
			}
		}
		
	}
}
