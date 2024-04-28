package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import service.ContactService;

// Christian Tavares || CS 320 Software Test and Automation || 4/12/24
// ------------------------------------------------------------------------------------------------
// This class contains all of the JUnit tests for the ContactService.java class. It will test the
// functionality of all functions within, while also testing to throw exceptions under expected
// circumstances. By extension, this class also tests the setter/mutator functions of the 
// Contact.java class, since this is the only place you can access those functions
// ------------------------------------------------------------------------------------------------

class ContactServiceTest {
	
	//Test Variables
	
	String id = "1005684945";
	String firstName = "Chris";
	String lastName = "Cody";
	String number = "6032005000";
	String address = "25 Bird Street";
	
	String badId = "1000000000";
	String newFirstName = "Tyler";
	String newLastName = "Tavares";
	String newPhoneNumber = "0005002306";
	String newAddress = "10 Fox Avenue";

	@Test
	void testCreateContact() { //Functional test for createContact()
		ContactService ContactClass = new ContactService();
		
		ContactClass.contacts.clear(); //Needs to be present since ContactClass starts with a contact element, weirdly
		
		ContactClass.createContact(id, firstName, lastName, number, address);
		
		assertTrue(ContactClass.contacts.get(0).getId().equals(id));
		assertTrue(ContactClass.contacts.get(0).getFirstName().equals(firstName));
		assertTrue(ContactClass.contacts.get(0).getLastName().equals(lastName));
		assertTrue(ContactClass.contacts.get(0).getPhoneNumber().equals(number));
		assertTrue(ContactClass.contacts.get(0).getAddress().equals(address));
	}
	
	@Test
	void testCreateContactDuplicateId() { //Test for createContact using invalid id
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			ContactService ContactClass = new ContactService();
			ContactClass.contacts.clear(); //Needs to be present since ContactClass starts with a contact element, weirdly
			ContactClass.createContact(id, firstName, lastName, number, address);
			ContactClass.createContact(id, firstName, lastName, number, address);
		});
	}
	
	//This function simply will not work unless I update the Id field again, like the ContactService test
	//I don't know what that problem is but it doesn't load the array properly when calling ContactClass
	
	@Test
	void testDeleteContact() { //Functional test for deleteContact()
		ContactService ContactClass = new ContactService();
		ContactClass.contacts.clear(); //Needs to be present since ContactClass starts with a contact element, weirdly
		ContactClass.createContact(id, firstName, lastName, number, address);
		ContactClass.deleteContact(id);
		assertTrue(ContactClass.contacts.isEmpty());
	}
	
	@Test
	void testDeleteContactBadId() { //Test for deleteContact using invalid id
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			ContactService ContactClass = new ContactService();
			ContactClass.contacts.clear(); //Needs to be present since ContactClass starts with a contact element, weirdly
			ContactClass.createContact(id, firstName, lastName, number, address);
			assertNotNull(ContactClass.contacts);
			ContactClass.deleteContact(badId);
		});
	}
	
	@Test
	void testUpdateFirstName() { //Functional test for updateFirstName()
		ContactService ContactClass = new ContactService();
		ContactClass.contacts.clear(); //Needs to be present since ContactClass starts with a contact element, weirdly
		ContactClass.createContact(id, firstName, lastName, number, address);
		ContactClass.updateFirstName(id, newFirstName);
		assertNotNull(ContactClass.contacts);
		assertTrue(ContactClass.contacts.get(0).getFirstName().equals("Tyler"));
	}
	
	@Test
	void testUpdateFirstNameBadId() { //Test for updateFirstName() using invalid id
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			ContactService ContactClass = new ContactService();
			ContactClass.contacts.clear(); //Needs to be present since ContactClass starts with a contact element, weirdly
			ContactClass.createContact(id, firstName, lastName, number, address);
			assertNotNull(ContactClass.contacts);
			ContactClass.updateFirstName(badId, newFirstName);
		});
	}
	
	@Test
	void testUpdateLastName() { //Functional test for updateLastName()
		ContactService ContactClass = new ContactService();
		ContactClass.contacts.clear(); //Needs to be present since ContactClass starts with a contact element, weirdly
		ContactClass.createContact(id, firstName, lastName, number, address);
		ContactClass.updateLastName(id, newLastName);
		assertTrue(ContactClass.contacts.get(0).getLastName().equals(newLastName));
	}
	
	@Test
	void testUpdateLastNameBadId() { //Test for updateLastName() using invalid id
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			ContactService ContactClass = new ContactService();
			ContactClass.contacts.clear(); //Needs to be present since ContactClass starts with a contact element, weirdly
			ContactClass.createContact(id, firstName, lastName, number, address);
			assertNotNull(ContactClass.contacts);
			ContactClass.updateLastName(badId, newLastName);
		});
	}
	
	@Test
	void testUpdatePhoneNumber() { //Functional test for updatePhoneNumber()
		ContactService ContactClass = new ContactService();
		ContactClass.contacts.clear(); //Needs to be present since ContactClass starts with a contact element, weirdly
		ContactClass.createContact(id, firstName, lastName, number, address);
		ContactClass.updatePhoneNumber(id, newPhoneNumber);
		assertTrue(ContactClass.contacts.get(0).getPhoneNumber().equals(newPhoneNumber));
	}
	
	@Test
	void testUpdatePhoneNumberBadId() { //Test for updatePhoneNumber() using invalid id
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			ContactService ContactClass = new ContactService();
			ContactClass.contacts.clear(); //Needs to be present since ContactClass starts with a contact element, weirdly
			ContactClass.createContact(id, firstName, lastName, number, address);
			assertNotNull(ContactClass.contacts);
			ContactClass.updatePhoneNumber(badId, newPhoneNumber);
		});
	}
	
	@Test
	void testUpdateAddress() { //Functional test for updateAddress()
		ContactService ContactClass = new ContactService();
		ContactClass.contacts.clear(); //Needs to be present since ContactClass starts with a contact element, weirdly
		ContactClass.createContact(id, firstName, lastName, number, address);
		ContactClass.updateAddress(id, newAddress);
		assertTrue(ContactClass.contacts.get(0).getAddress().equals(newAddress));
	}
	
	@Test
	void testUpdateAddressBadId() { //Test for updateAddress() using invalid id
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			ContactService ContactClass = new ContactService();
			ContactClass.contacts.clear(); //Needs to be present since ContactClass starts with a contact element, weirdly
			ContactClass.createContact(id, firstName, lastName, number, address);
			assertNotNull(ContactClass.contacts);
			ContactClass.updateAddress(badId, newAddress);
		});
	}

}
