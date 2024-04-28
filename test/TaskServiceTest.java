package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import service.TaskService;

// Christian Tavares || CS 320 Software Test and Automation || 4/12/24
// ------------------------------------------------------------------------------------------------
// This class contains all of the JUnit tests for the TaskService.java class. This class will run
// a functional test for each function, then test for other expected exceptions for id mismatch.
// See TastTest.java to see every failure scenario like character limits and null variables.
// ------------------------------------------------------------------------------------------------

class TaskServiceTest {

	//Test Variables
	
	String id = "1234567890";
	String name = "Generic Task";
	String description = "A generic task added into the system for testing.";
	
	String badId = "1000000000";
	String newName = "New Task";
	String newDescription = "A new task description for the system.";
	
	@Test
	void testCreateTask() { //Functional test for createTask()
		TaskService service = new TaskService();
		
		service.tasks.clear(); //Needs to be present since TaskService starts with a task element, weirdly
		
		service.createTask(id, name, description); //Create Task
		
		assertTrue(service.tasks.get(0).getId().equals(id));
		assertTrue(service.tasks.get(0).getName().equals(name));
		assertTrue(service.tasks.get(0).getDescription().equals(description)); //Make sure all fields match
	}
	
	@Test
	void testCreateTaskDuplicateId() { //Test for createTask() with a duplicate Id
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			TaskService ContactClass = new TaskService();
			ContactClass.tasks.clear(); //Needs to be present since TaskService starts with a task element, weirdly
			ContactClass.createTask(id, name, description);
			ContactClass.createTask(id, name, description); //<-- Expected failure here
		});
	}
	
	@Test
	void testDeleteTask() { //Functional test for deleteTask()
		TaskService service = new TaskService();
		service.tasks.clear(); //Needs to be present since TaskService starts with a task element, weirdly
		service.createTask(id, name, description);
		service.deleteTask(id); //Delete task
	}
	
	@Test
	void testDeleteTaskBadId() { //Test for deleteTask() with a duplicate Id
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			TaskService service = new TaskService();
			service.tasks.clear(); //Needs to be present since TaskService starts with a task element, weirdly
			service.createTask(id, name, description);
			service.deleteTask(badId); //<-- Expected failure here
		});
	}
	
	@Test
	void testUpdateName() { //Functional test for updateName()
		TaskService service = new TaskService();
		service.tasks.clear(); //Needs to be present since TaskService starts with a task element, weirdly
		service.createTask(id, name, description);
		service.updateName(id, newName); //Update name
		assertTrue(service.tasks.get(0).getName().equals(newName));
	}
	
	@Test
	void testUpdateNameBadId() { //Test for updateName() with a duplicate Id
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			TaskService service = new TaskService();
			service.tasks.clear(); //Needs to be present since TaskService starts with a task element, weirdly
			service.createTask(id, name, description);
			service.updateName(badId, newName); //<-- Expected failure here
		});
	}
	
	@Test
	void testUpdatedescription() { //Functional test for updateDescription()
		TaskService service = new TaskService();
		service.tasks.clear(); //Needs to be present since TaskService starts with a task element, weirdly
		service.createTask(id, name, description);
		service.updateDescription(id, newDescription); //Update description
		assertTrue(service.tasks.get(0).getDescription().equals(newDescription));
	}
	
	@Test
	void testUpdateDescriptionBadId() { //Test for updateDescription() with a duplicate Id
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			TaskService service = new TaskService();
			service.tasks.clear();//Needs to be present since TaskService starts with a task element, weirdly
			service.createTask(id, name, description);
			service.updateDescription(badId, newDescription); //<-- Expected failure here
		});
	}
}
