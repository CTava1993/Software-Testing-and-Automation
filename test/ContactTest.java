package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import service.Contact;

// Christian Tavares || CS 320 Software Test and Automation || 4/12/24
// ------------------------------------------------------------------------------------------------
// This class contains all of the JUnit tests for the Contact.java class. Tests will run for the
// functionality of all functions aside from the setter/mutator functions due to them being tested
// in the ContactServiceTest.java class. This class also tests all iterations of invalid throws
// for each data field in Contact.java
// ------------------------------------------------------------------------------------------------

class ContactTest {	
	
	//Test Variables
	
	String id = "1005684945";
	String firstName = "Chris";
	String lastName = "Cody";
	String number = "6032005000";
	String address = "25 Bird Street";
	
	String longId = "1005684945666666";
	String longFirstName = "ReallyLongFirstName";
	String longLastName = "ReallyLongLastName";
	String longPhoneNumber = "603200000500000";
	String shortPhoneNumber = "6" ;
	String longAddress = "ThisAddressIsSupposedToBeLongerThan30Characters";

	@Test
	void ContactTest() { //Functional test for Contact()
		Contact contact = new Contact(id, firstName, lastName, number, address);
	}
	
	@Test
	void testContactIdTooLong() { //Test for Contact() if id is too long
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Contact contact = new Contact(longId, firstName, lastName, number, address);
		});
	}
	
	@Test 
	void testContactNullId() { //Test for Contact() if id is null
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Contact contact = new Contact(null, firstName, lastName, number, address);
		});
	}
	
	@Test
	void testContactFirstNameTooLong() { //Test for Contact() if first name is too long
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Contact contact = new Contact(id, longFirstName, lastName, number, address);
		});
	}
	
	@Test 
	void testContactFirstNameNull() { //Test for Contact() if first name is null
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Contact contact = new Contact(id, null, lastName, number, address);
		});
	}
	
	@Test
	void testContactLastNameTooLong() { //Test for Contact() if last name is too long
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Contact contact = new Contact(id, firstName, longLastName, number, address);
		});
	}
	
	@Test 
	void testContactNullLastName() { //Test for Contact() if last name is null
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Contact contact = new Contact(id, firstName, null, number, address);
		});
	}
	
	@Test
	void testContactPhoneNumberTooLong() { //Test for Contact() if phone number is too long
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Contact contact = new Contact(id, firstName, lastName, longPhoneNumber, address);
		});
	}
	
	@Test
	void testContactPhoneNumberTooShort() { //Test for Contact() if phone number is too short
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Contact contact = new Contact(id, firstName, lastName, shortPhoneNumber, address);
		});
	}
	
	@Test 
	void testContactNullPhoneNumber() { //Test for Contact() if phone number is null
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Contact contact = new Contact(id, firstName, lastName, null, address);
		});
	}
	
	@Test
	void testContactAddressTooLong() {  //Test for Contact() if address is too long
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Contact contact = new Contact(id, firstName, lastName, number, longAddress);
			});
	}
	
	@Test 
	void testContactNullAddress() { //Test for Contact() if address is null
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Contact contact = new Contact(id, firstName, lastName, number, null);
		});
	}
	
	@Test
	void testGetId() { //Functional test for getId()
		Contact contact = new Contact(id, firstName, lastName, number, address);
		assertTrue(contact.getId().equals(id));
	}
	
	@Test
	void testGetFirstName() { //Functional test for getFirstName()
		Contact contact = new Contact(id, firstName, lastName, number, address);
		assertTrue(contact.getFirstName().equals(firstName));
	}
	
	@Test
	void testGetLastName() { //Functional test for getLastName()
		Contact contact = new Contact(id, firstName, lastName, number, address);
		assertTrue(contact.getLastName().equals(lastName));
	}
	
	@Test
	void testGetPhoneNumber() { //Functional test for getPhoneNumber()
		Contact contact = new Contact(id, firstName, lastName, number, address);
		assertTrue(contact.getPhoneNumber().equals(number));
	}
	
	@Test
	void testGetAddress() { //Functional test for getAddress()
		Contact contact = new Contact(id, firstName, lastName, number, address);
		assertTrue(contact.getAddress().equals(address));
	}

}
