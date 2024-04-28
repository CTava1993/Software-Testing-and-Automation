package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import service.Appointment;

import java.util.Date;

// Christian Tavares || CS 320 Software Test and Automation || 4/12/24
// ------------------------------------------------------------------------------------------------
// This class contains all of the tests for the Appointment class. This class will run functional
// JUnit tests on all of the "getter" functions, as well as the Appointment() function. It will
// also run tests to throw exceptions on any invalid values for Appointment() instantiation. 
// ------------------------------------------------------------------------------------------------

class AppointmentTest {

	//Test Variables
	
	String id = "1234567890";
	long millis = System.currentTimeMillis();
	String description = "A generic appointment added for testing.";
	
	String badId = "1000000000000000";
	String badDescription = "This generic appointment description is meant to exceed to 50 character limit and throw an error.";
	
	@Test
	void testAppointment() { //Functional test for Appointment()
		Date date = new Date(millis + 1000); //Done to make sure the time is AFTER instantiation
		Appointment appointment = new Appointment(id, date, description);
	}
	
	@Test
	void testAppointmentIdTooLong() { //Test for Appointment for when the Id exceeds 10 characters
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Date date = new Date(millis + 1000);
			Appointment appointment = new Appointment(badId, date, description);
		});
	}
	
	@Test
	void testAppointmentIdNull() { //Test for Appointment() for when the Id value is null
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Date date = new Date(millis + 1000);
			Appointment appointment = new Appointment(null, date, description);
		});
	}
	
	@Test
	void testAppointmentInvalidDate() { //Test for Appointment() for when Cate is EARLIER than instantiation
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Date date = new Date(millis);
			Appointment appointment = new Appointment(id, date, description);
		});
	}
	
	@Test
	void testAppointmentDateNull() { //Test for Appointment() for when the Date is null
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Date date = new Date(millis + 1000);
			Appointment appointment = new Appointment(id, null, description);
		});
	}
	
	@Test
	void testAppointmentDescriptionTooLong() { //Test for Appointment() for when the Description exceeds 50 characters
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Date date = new Date(millis + 1000);
			Appointment appointment = new Appointment(id, date, badDescription);
		});
	}
	
	@Test
	void testAppointmentDescriptionNull() { //Test for Appointment() for when the Description is null
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Date date = new Date(millis + 1000);
			Appointment appointment = new Appointment(id, date, null);
		});
	}
	
	@Test
	void getIdTest() { //Functional test for getId()
		Date date = new Date(millis + 1000);
		Appointment appointment = new Appointment(id, date, description);
		assertTrue(appointment.getId().equals(id));
	}
	
	@Test
	void getDateTest() { //Functional test for getDate()
		Date date = new Date(millis + 1000);
		Appointment appointment = new Appointment(id, date, description);
		assertTrue(appointment.getDate().equals(date));
	}
	
	@Test
	void getDescriptionTest() { //Functional test for getDescription()
		Date date = new Date(millis + 1000);
		Appointment appointment = new Appointment(id, date, description);
		assertTrue(appointment.getDescription().equals(description));
	}
}
