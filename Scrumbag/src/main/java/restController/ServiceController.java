package restController;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import projectHandler.ProjectHandler;
import projectHandlerService.Project;
import projectHandlerService.Task;
import projectHandlerService.Task.taskStatus;

@RestController
public class ServiceController {
	private ProjectHandler pH;
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

	@RequestMapping(value = "/edit-activity/{taskId}/{expectedTime}?{name}?{currentStatus}?{taskprio}?{responsiblePerson}", method = RequestMethod.GET)
	public void setAll(@PathVariable("task") Task task, @PathVariable("expectedTime")int expectedTime,@PathVariable("name") String name,@PathVariable("currentStatus") Object currentStatus,
			@PathVariable("taskprio") Object taskprio,@PathVariable("responsiblePerson") Object responsiblePerson,
			@PathVariable("actuallTime")Object actuallTime) {
			task.setAll(expectedTime, name, currentStatus, taskprio, responsiblePerson, actuallTime);
	}

	@RequestMapping(value= "/login/{userId}", method = RequestMethod.GET)
	public User login(@PathVariable("username")String username,@PathVariable("password") String password) {
		User u = null;
		u = db.checkUser;
		return u;
	}

	@RequestMapping(value= "/TaskActuallTime/{taskId}/{time}", method = RequestMethod.POST)
	public void setActuallTime(@PathVariable("time")int time,@PathVariable("Task") Task t) {
		t.setActuallTime(time);
	}

	@RequestMapping(value= "/createUser/{userId}/{name}/{adminOrNot}", method = RequestMethod.POST)
	public Object newUser(@PathVariable("user")User userAdmin,@PathVariable("name") String name,@PathVariable("adminOrNot") boolean adminOrNot) {
		User u = null;
		if (userAdmin.getaccess==true) {
			u = new User (name, false); //Vanlig användare 
		}
		return u;
	}

	@RequestMapping(value= "/setTaskStatus/{taskId}/{status}", method = RequestMethod.POST)
	public void setStatus(@PathVariable("Task")Task t,@PathVariable("status") int status) {
		t.setStatus(status); 
		// TODO Auto-generated method stub
	}

	@RequestMapping(value= "/getTaskStatus/{taskId}", method = RequestMethod.GET)
	public int getStatus(@PathVariable("Task")Task t) {
		return t.getStatus();
	}

	@RequestMapping(value= "/addTaskToBacklog/{taskId}", method = RequestMethod.POST)
	public void addTaskToBacklog(@PathVariable("Task")Task t) {
		bl.add(t);
		// TODO Auto-generated method stub
		
	}
	
	@RequestMapping(value= "/getTaskToBacklog/{taskId}", method = RequestMethod.GET)
	public Task getTaskFromBacklog(@PathVariable("Task")Task t) {
		
		return t.getTaskFromBacklog();
		
	}
	
	@RequestMapping(value= "/setTaskStatusBacklog/{taskId}/{status}", method = RequestMethod.POST)
	public Object setTaskStatusBacklog(@PathVariable("Task")Task t,@PathVariable("status") int status) {
	
		bl.setTaskStatusBacklog(t, status);
	}

	@RequestMapping(value= "/setPriorityForTask/{taskId}/{priority}", method = RequestMethod.POST)
	public void setPriorityTask(@PathVariable("Task")Task t,@PathVariable("priority") int priority) {
		
		t.setPriority(priority);
		// TODO Auto-generated method stub

	}

	@RequestMapping(value= "/getPriorityForTask/{taskId}", method = RequestMethod.GET)
	public int getPriorityTask(@PathVariable("Task")Task t) {
		
		return t.getPriority();
	}

	@RequestMapping(value= "/setPriorityForProject/{projectId}/{priority}", method = RequestMethod.POST)
	public void setPriorityProject(@PathVariable("project")Project project,@PathVariable("priority") int priority) {
		
		project.setPriority(priority);

	}
	
	@RequestMapping(value= "/getProjectPriority/{projectId}", method = RequestMethod.GET)
	public int getProjectPriority(@PathVariable("project")Project project) {
		// TODO Auto-generated method stub
		return project.getPriority();
	}

	@RequestMapping(value= "/setTaskTimeUser/{taskId}/{userId}/{time}", method = RequestMethod.POST)
	public void setTaskTimeUser(@PathVariable("time")int time,@PathVariable("user") User u,@PathVariable("task") Task t) {
		t.setTaskTime(time, u);

	}
	
	@RequestMapping(value= "/gettTaskTimeUser/{taskId}/{userId}", method = RequestMethod.GET)
	public int getTaskTimeUser(@PathVariable("task")Task t,@PathVariable("user") User u); {
		
		return t.getTaskTime(u);
	}
	
	@RequestMapping(value= "/addUsersToProject/{projectId}/{userId}", method = RequestMethod.POST)
	public void addToProject(@PathVariable("userAdmin")User admin,@PathVariable("user") User user,@PathVariable("project") Project project) {
		if (admin.getAcces() == true) {
	   project.addUsersToProject(user);
		}
	}
	
	@RequestMapping(value= "/deleteUserFromProject/{projectId}/{userId}", method = RequestMethod.DELETE)
	public void deletUserFromProject(@PathVariable("userAdmin")User admin,@PathVariable("use") User user,@PathVariable("project") Project project) {
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

	public int getTask(int taskID) {
		return pH.getTask(taskID);
	
	}
}
