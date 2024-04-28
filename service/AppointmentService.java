package service;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

// Christian Tavares || CS 320 Software Test and Automation || 4/12/24
// ------------------------------------------------------------------------------------------------
// This class contains all of the functions to create and delete Appointment objects. There is no
// functionality with this assignment to change the values within an Appointment object, so it is
// assumed to just delete the old objects and replace them entirely if there is a mistake.
//
// Exceptions will be thrown with duplicate Id values on Appointment creation, or if there is now
// matching Id when searching the ArrayList to delete an Appointment.
//------------------------------------------------------------------------------------------------

public class AppointmentService {
	
	public static List<Appointment> Appointments = new ArrayList<Appointment>(); //ArrayList of appointments
	
	public void createAppointment(String id, Date date, String description) {
		
		Appointment appointment = new Appointment(id, date, description);
		
		if(Appointments.isEmpty() == true) { //If list empty, add appointment to ArrayList
			Appointments.add(appointment);
		}
		else { //TODO make this bit of code into it's own function called findAppointment()
			
			for(int i = 0; i < Appointments.size(); i++) { //Else, check if id exists in ArrayList
				if(Appointments.get(i).getId() == appointment.getId()) {
					throw new IllegalArgumentException("Invalid id");
				}
				else {
					Appointments.add(appointment); //Add if id is unique
				}
			}
			
		}
	}
	
	public void deleteAppointment(String id) { //Delete appointment from ArrayList by id
		for(int i = 0; i < Appointments.size(); i++) {
			if(Appointments.get(i).getId() == id) {
				Appointments.remove(i);
			}
			else {
				throw new IllegalArgumentException("Appointment not found"); //Id doesn't exist
			}
		}
	}
}
