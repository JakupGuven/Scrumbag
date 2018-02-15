package restController;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import projectHandlerService.Project;
import projectHandlerService.Task;


@RestController
public class ServiceController {
	
	
	/**
	 * Exempelmetod
	 * När en HTTP GET request görs till localhost:8080/hello-world/officiellt Spring Boot certifierad
	 * kommer "Hello World officiellt Spring Boot certifierad" returneras
	 */
	@RequestMapping(value = "/hello-world/{parameter}", method = RequestMethod.GET)
	public String helloWorld(@PathVariable("parameter") String parameter) {
		return new String("Hello World\n " + parameter);
	}

	public Object createTask(int expectedTime, String name, Object currentStatus, Object taskprio, Object actuallTime,
			Object responsiblePerson) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object changeStatus(Task t, int status) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object deleteTask(Task t) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object setAll(int expectedTime, String name, Object currentStatus, Object taskprio, Object responsiblePerson,
			Object actuallTime) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object createTask(int expectedTime, String name, Object currentStatus, Object taskprio,
			Object responsiblePerson) {
		// TODO Auto-generated method stub
		return null;
	}

	public User login(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object setActuallTime(int i) {
		// TODO Auto-generated method stub
		return null;
	}


	public Object newUser(boolean access, ArrayList arrayUser) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object setStatus(Task t, int status) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getStatus(Task t) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object addTaskToBacklog(Task t) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object setTaskStatusBacklog(Task t, int status) {
		// TODO Auto-generated method stub
		return null;
	}

	public void setPriorityTask(Task t, int temp1) {
		// TODO Auto-generated method stub
		
	}

	public Object getPriorityTask(Task t) {
		// TODO Auto-generated method stub
		return null;
	}

	public void setPriorityProject(Project project, int temp) {
		// TODO Auto-generated method stub
		
	}

	public Object getProjectPriority() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setTaskTime(int time, User user) {
		// TODO Auto-generated method stub
		
	}

	public void addToProject(boolean access, User user, Project project) {
		// TODO Auto-generated method stub
		
	}

	public void deletUserFromProject(boolean access, User user, Project project) {
		// TODO Auto-generated method stub
		
	}

	public void addTaskToBacklog(boolean access, Group group Project project) {
		// TODO Auto-generated method stub
		
	}

	public void deletGroupFromProject(boolean access, Group group, Project project) {
		// TODO Auto-generated method stub
		
	}}
