package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import service.AppointmentService;

import java.util.Date;

// Christian Tavares || CS 320 Software Test and Automation || 4/12/24
// ------------------------------------------------------------------------------------------------
// This class contains all of the tests for the AppointmentService() class. This class will run
// JUnit functional tests on the createAppointment() and deleteAppointment() functions, as well as
// throw exceptions for duplicate Id values when creating an Appointment or an Id not being found
// when trying to delete an Appointment.
// ------------------------------------------------------------------------------------------------

public class AppointmentServiceTest {
	
	//Test Variables
	
	String id = "1234567890";
	long millis = System.currentTimeMillis();
	String description = "A generic appointment added for testing.";
	
	String badId = "1000000000000000";

	@Test
	void testCreateAppointment() { //Functional test for createAppointment()
		AppointmentService service = new AppointmentService();
		
		Date date = new Date(millis+ 1000); //Create Date object for 1000ms in the future
		service.Appointments.clear();//Clear Arraylist
		
		service.createAppointment(id, date, description); //Create Appointment object
		
		assertTrue(service.Appointments.get(0).getId().equals(id));
		assertTrue(service.Appointments.get(0).getDate().equals(date));
		assertTrue(service.Appointments.get(0).getDescription().equals(description)); //Check values are correct
	}
	
	@Test
	void testCreateAppointmentDuplicateId() { //Test for CreateAppointment() with a duplicate Id
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			AppointmentService service = new AppointmentService();
			
			service.Appointments.clear(); //Needs to be present since AppointmentService() starts with an Appointment element, weirdly
			Date date = new Date(millis + 1000); //Create Date object for 1000ms in the future
			
			service.createAppointment(id, date, description);
			service.createAppointment(id, date, description); //<-- Expected failure here
		});
	}
	
	@Test
	void testDeleteAppointment() { //Functional test for deleteAppointment
		AppointmentService service = new AppointmentService();
		
		service.Appointments.clear(); //Needs to be present since AppointmentService() starts with an Appointment element, weirdly
		Date date = new Date(millis + 1000); //Create Date object for 1000ms in the future
		
		service.createAppointment(id, date, description);
		service.deleteAppointment(id);
	}
	
	@Test
	void testDeleteAppointmentBadId() { // Test for DeleteAppointment() with an Id that doesn't match
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			AppointmentService service = new AppointmentService();
			
			service.Appointments.clear(); //Needs to be present since AppointmentService() starts with an Appointment element, weirdly
			Date date = new Date(millis + 1000); //Create Date object for 1000ms in the future
			
			service.createAppointment(id, date, description);
			service.deleteAppointment(badId); //<-- Expected failure here
		});
	}
}
