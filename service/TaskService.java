package service;

import java.util.ArrayList;
import java.util.List;

// Christian Tavares || CS 320 Software Test and Automation || 4/12/24
// ------------------------------------------------------------------------------------------------
// This class contains all of the functions to create task objects, delete task objects, or edit
// them as needed within an ArrayList of other task objects with unique Ids. This class will
// iterate through the ArrayList on any function that requires finding an existing task object
// by Id and will throw an exception depending on the outcome and function.
// ------------------------------------------------------------------------------------------------

public class TaskService {
	
	public static List<Task> tasks = new ArrayList<Task>(); //ArrayList of contacts
	
	public void createTask(String id, String name, String description) {
		
		Task task = new Task(id, name, description);
		
		if(tasks.isEmpty() == true) { //If list empty, add contact to ArrayList
			tasks.add(task);
		}
		else { //TODO make this bit of code into it's own function called findTask()
			
			for(int i = 0; i < tasks.size(); i++) { //Else, check if id exists in ArrayList
				if(tasks.get(i).getId() == task.getId()) {
					throw new IllegalArgumentException("Invalid id");
				}
				else {
					tasks.add(task); //Add if id is unique
				}
			}
			
		}
	}
	
	public void deleteTask(String id) { //Delete contact from ArrayList by id
		
		for(int i = 0; i < tasks.size(); i++) {
			if(tasks.get(i).getId() == id) {
				tasks.remove(i);
			}
			else {
				throw new IllegalArgumentException("Task not found"); //Id doesn't exist
			}
		}
		
	}
	
	public void updateName(String id, String name) { //Update task name by id
		
		for(int i = 0; i < tasks.size(); i++) {
			if(tasks.get(i).getId() == id) {
				tasks.get(i).setName(name);
			}
			else {
				throw new IllegalArgumentException("Task not found"); //Id doesn't exist
			}
		}
		
	}
	
	public void updateDescription(String id, String description) { //Update task description by id
		
		for(int i = 0; i < tasks.size(); i++) {
			if(tasks.get(i).getId() == id) {
				tasks.get(i).setDescription(description);
			}
			else {
				throw new IllegalArgumentException("Task not found"); //Id doesn't exist
			}
		}
		
	}
}
