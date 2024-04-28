package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import service.Task;

// Christian Tavares || CS 320 Software Test and Automation || 4/12/24
// ------------------------------------------------------------------------------------------------
// This class contains all of the JUnit tests for the Task.java class. This will include basic
// functionality tests to ensure the functions work, as well as a test for null variables, or
// character limits being broken on creation of a task object.
// ------------------------------------------------------------------------------------------------

class TaskTest {	
	
	//Test Variables
	
	String id = "1234567890";
	String name = "Generic Task";
	String description = "A generic task added into the system for testing.";
	
	String longId = "12345678901155948484624";
	String longName = "ReallyLongNameToTriggerException";
	String longDescription = "ThisDescriptionIsSoLongThatIDontKnowHowToTypeEverythingOutInOrderForItToBeLongerThan50Characters";

	@Test
	void TaskTest() { //Functional test for Task()
		Task task = new Task(id, name, description);
	}
	
	@Test
	void testIdTooLong() { //Test for Task() if id is too long
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Task task = new Task(longId, name, description);
		});
	}
	
	@Test 
	void testTaskIdNull() { //Test for Task() if id is null
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Task task = new Task(null, name, description);
		});
	}
	
	@Test
	void testTaskNameTooLong() { //Test for Task() if name is too long
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Task task = new Task(id, longName, description);
		});
	}
	
	@Test 
	void testTaskNameNull() { //Test for Task() if name is null
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Task task = new Task(id, null, description);
		});
	}
	
	@Test
	void testTaskDescriptionTooLong() { //Test for Task() if description is too long
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Task task = new Task(id, name, longDescription);
		});
	}
	
	@Test 
	void testTaskDescriptionNull() { //Test for Task() if description is null
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Task task = new Task(id, name, null);
		});
	}
	
	@Test
	void testGetId() { //Functional test for getId()
		Task task = new Task(id, name, description);
		assertTrue(task.getId().equals(id));
	}
	
	@Test
	void testGetName() { //Functional test for getName()
		Task task = new Task(id, name, description);
		assertTrue(task.getName().equals(name));
	}
	
	@Test
	void testGetDescription() { //Functional test for getDescription()
		Task task = new Task(id, name, description);
		assertTrue(task.getDescription().equals(description));
	}
}