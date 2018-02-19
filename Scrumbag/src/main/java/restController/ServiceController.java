package restController;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import projectHandlerService.Project;
import projectHandlerService.Task;
import projectHandlerService.Task.taskStatus;

@RestController
public class ServiceController {

	/**
	 * Exempelmetod När en HTTP GET request görs till
	 * localhost:8080/hello-world/officiellt Spring Boot certifierad kommer
	 * "Hello World officiellt Spring Boot certifierad" returneras
	 */
	@RequestMapping(value = "/hello-world/{parameter}", method = RequestMethod.GET)
	public String helloWorld(@PathVariable("parameter") String parameter) {
		return new String("Hello World\n " + parameter);
	}

	@RequestMapping(value = "/create-task/{expectedTime}?{name}?{currentStatus}?{taskprio}/{responsiblePerson}", method = RequestMethod.GET)
	public Object createTask(@PathVariable("expectedTime") int expectedTime, @PathVariable("name") String name,
			@PathVariable("currentStatus") Object currentStatus, @PathVariable("taskprio") Object taskprio,
			@PathVariable("responsiblePerson") Object responsiblePerson) {
		Task t = new Task(expectedTime, name, currentStatus, taskprio, responsiblePerson);
		if (t != null)return new String("The task have been successfully made");

		return new String("The task could not be made");
	}

	@RequestMapping(value = "/change-status/{taskID}?{status}", method = RequestMethod.GET)
	public Object changeStatus(@PathVariable("task") Task task,@PathVariable("status") taskStatus status) {
		task.setCurrentStatus(status);
		return new String("The status have been change");
	}
	
	@RequestMapping(value = "/delete-Task/{taskID}", method = RequestMethod.GET)
	public Object deleteTask(@PathVariable("task")Task t) {
		t = null;
		// TODO Auto-generated method stub
		return "Successfully deleted";
	}

	@RequestMapping(value = "/edit-activity/taskId/{expectedTime}?{name}?{currentStatus}?{taskprio}?{responsiblePerson}", method = RequestMethod.GET)
	public void setAll(@PathVariable("task") Task task, @PathVariable("expectedTime")int expectedTime,@PathVariable("name") String name,@PathVariable("currentStatus") Object currentStatus,
			@PathVariable("taskprio") Object taskprio,@PathVariable("responsiblePerson") Object responsiblePerson,
			@PathVariable("actuallTime")Object actuallTime) {
			task.setAll(expectedTime, name, currentStatus, taskprio, responsiblePerson, actuallTime);
	}

	public User login(String username, String password) {
		User u = null;
		u = db.checkUser;
		return u;
	}

	public void setActuallTime(int i, Task t) {
		t.setActuallTime(i);
	}

	public Object newUser(User userAdmin, String name, boolean adminOrNot) {
		User u = null;
		if (userAdmin.getaccess==true) {
			u = new User (name, false); //Vanlig användare 
		}
		return u;
	}

	public void setStatus(Task t, int status) {
		t.setStatus(status); 
		// TODO Auto-generated method stub
	}

	public int getStatus(Task t) {
		return t.getStatus();
	}

	public void addTaskToBacklog(Task t) {
		bl.add(t);
		// TODO Auto-generated method stub
		
	}
	
	public Task getTaskFromBacklog(Task t) {
		
		return t.getTaskFromBacklog();
		
	}

	public Object setTaskStatusBacklog(Task t, int status) {
	
		bl.setTaskStatusBacklog(t, status);
	}

	public void setPriorityTask(Task t, int temp1) {
		
		t.setPriority(temp1);
		// TODO Auto-generated method stub

	}

	public int getPriorityTask(Task t) {
		
		return t.getPriority();
	}

	public void setPriorityProject(Project project, int temp) {
		
		project.setPriority(temp);

	}

	public int getProjectPriority(Project project) {
		// TODO Auto-generated method stub
		return project.getPriority();
	}

	public void setTaskTimeUser(int time, User u, Task t) {
		t.setTaskTime(time, u);

	}
	
	public int getTaskTimeUser(Task t, User u); {
		
		return t.getTaskTime(u);
	}

	public void addToProject(User admin, User user, Project project) {
		if (admin.getAcces() == true) {
	   project.addUsersToProject(user);
		}
	}

	public void deletUserFromProject(User admin, User user, Project project) {
		if (admin.getAccess()==true) {
			project.deletUserFromProject(user);
		}

	}
//Har haft?
	public void addTaskToBacklog(boolean access, Group group Project project) {
		// TODO Auto-generated method stub
		
	}
//Har haf?
	public void deletGroupFromProject(boolean access, Group group, Project project) {
		// TODO Auto-generated method stub

	}
}
