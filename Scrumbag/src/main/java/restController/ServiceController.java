package restController;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import projectHandler.ProjectHandler;
import projectHandler.User;
import projectHandler.Backlog;
import projectHandler.Group;
import projectHandler.Project;
import projectHandler.Task;
import projectHandler.Task.PRIORITY;
import projectHandler.Task.STATUS;

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
			@PathVariable("currentStatus") STATUS currentStatus, @PathVariable("taskprio") PRIORITY taskprio,
			@PathVariable("responsiblePerson") String responsiblePerson) {
		Task t = new Task(expectedTime, responsiblePerson, responsiblePerson, expectedTime, null, currentStatus);
		if (t != null)
			return new String("The task have been successfully made");

		return new String("The task could not be made");
		
	}

	@RequestMapping(value = "/change-status/{taskID}?{status}", method = RequestMethod.GET)
	public Object changeStatus(@PathVariable("task") Task task, @PathVariable("status") STATUS status) {
		task.setTaskStatus(status);
		return new String("The status have been change");
	}

	@RequestMapping(value = "/delete-Task/{taskID}", method = RequestMethod.GET)
	public Object deleteTask(@PathVariable("task") Task t) {
		t = null;
		// TODO Auto-generated method stub
		return "Successfully deleted";
	}

	@RequestMapping(value = "/edit-activity/{taskId}/{expectedTime}?{name}?{currentStatus}?{taskprio}?{responsiblePerson}", method = RequestMethod.GET)
	public void setAll(@PathVariable("task") Task task, @PathVariable("expectedTime") int expectedTime,
			@PathVariable("name") String name, @PathVariable("currentStatus") Object currentStatus,
			@PathVariable("taskprio") Object taskprio, @PathVariable("responsiblePerson") Object responsiblePerson,
			@PathVariable("actuallTime") Object actuallTime) {
		task.setAll(expectedTime, name, currentStatus, taskprio, responsiblePerson, actuallTime);
	}

	@RequestMapping(value = "/login/{userId}", method = RequestMethod.GET)
	public boolean login(@PathVariable("username") String username, @PathVariable("password") String password) {
		return true;
	}

	// @RequestMapping(value= "/TaskActuallTime/{taskId}/{time}", method =
	// RequestMethod.POST)
	// public void setActuallTime(@PathVariable("time")int
	// time,@PathVariable("Task") Task t) {
	// t.setActuallTime(time);
	// }

	@RequestMapping(value = "/createUser/{userId}/{name}/{adminOrNot}", method = RequestMethod.POST)
	public boolean newUser(@PathVariable("user") User userAdmin, @PathVariable("name") String name,
			@PathVariable("password") String password, @PathVariable("adminOrNot") boolean adminOrNot) {
		User u = null;
		if (userAdmin.getAdminOrnot() == true) {
			u = new User(53492, name, password, false); // Vanlig användare
			return true;
		}
		return false;
	}

	@RequestMapping(value = "/setTaskStatus/{taskId}/{status}", method = RequestMethod.POST)
	public void setStatus(@PathVariable("Task") Task t, @PathVariable("status") STATUS status) {
		t.setTaskStatus(status);
		// TODO Auto-generated method stub
	}

	@RequestMapping(value = "/getTaskStatus/{taskId}", method = RequestMethod.GET)
	public STATUS getStatus(@PathVariable("Task") Task t) {
		return t.getTaskStatus();
	}

	@RequestMapping(value = "/addTaskToBacklog/{taskId}", method = RequestMethod.POST)
	public void addTaskToBacklog(@PathVariable("Task") Task t, Backlog bl) {
		bl.add(t);
		// TODO Auto-generated method stub

	}

	@RequestMapping(value = "/getTaskToBacklog/{taskId}/{BacklogID}", method = RequestMethod.GET)
	public Task getTaskFromBacklog(@PathVariable("Task") Task t, @PathVariable("Backlog")Backlog bl) {

		return bl.getTaskFromBacklog(t);

	}

	@RequestMapping(value = "/setTaskStatusBacklog/{taskId}/{status}/{Backlog}", method = RequestMethod.POST)
	public boolean setTaskStatusBacklog(@PathVariable("Task") Task t, @PathVariable("status") STATUS status, @PathVariable("Backlog")Backlog bl) {

		bl.setTaskStatusBacklog(t, status);
		return true;
	}

	@RequestMapping(value = "/setPriorityForTask/{taskId}/{priority}", method = RequestMethod.POST)
	public void setPriorityTask(@PathVariable("Task") Task t, @PathVariable("priority") PRIORITY priority) {

		t.setTaskPriority(priority);
		// TODO Auto-generated method stub

	}

	@RequestMapping(value = "/getPriorityForTask/{taskId}", method = RequestMethod.GET)
	public PRIORITY getPriorityTask(@PathVariable("Task") Task t) {

		return t.getTaskPriority();
	}

	@RequestMapping(value = "/setPriorityForProject/{projectId}/{priority}", method = RequestMethod.POST)
	public void setPriorityProject(@PathVariable("project") Project project, @PathVariable("priority") PRIORITY priority) {

		project.setPriority(priority);

	}

	@RequestMapping(value = "/setTaskTimeUser/{taskId}/{userId}/{time}", method = RequestMethod.POST)
	public void setTaskTimeUser(@PathVariable("time") int time, @PathVariable("user") User u,
			@PathVariable("task") Task t) {
		t.setTaskTime(time, u);

	}

	@RequestMapping(value = "/gettTaskTimeUser/{taskId}/{userId}", method = RequestMethod.GET)
	public int getTaskTimeUser(@PathVariable("task") Task t, @PathVariable("user") User u) {
		return t.getTaskTime(u);
	}

	@RequestMapping(value = "/addUsersToProject/{projectId}/{userId}", method = RequestMethod.POST)
	public void addUsersToProject(@PathVariable("userAdmin") User admin, @PathVariable("user") ArrayList<User> user,
			@PathVariable("project") Project project) {
		if (admin.getAdminOrnot() == true) {
			for(User u : user){
				project.addUsersToProject(u);
			}
		}
	}

	@RequestMapping(value = "/deleteUserFromProject/{projectId}/{userId}", method = RequestMethod.DELETE)
	public void deletUserFromProject(@PathVariable("userAdmin") User admin, @PathVariable("user") ArrayList <User> user,
			@PathVariable("project") Project project) {
		if (admin.getAdminOrnot() == true) {
			project.deletUserFromProject(user);
		}

	}

	// Har haft?
	public void addTaskToBacklog(boolean access, Group group, Project project) {
		// TODO Auto-generated method stub
		
	}

	// Har haf?
	@RequestMapping(value = "/deleteGroupFromProject/{projectId}", method = RequestMethod.DELETE)
	public void deletGroupFromProject(@PathVariable("access") boolean access,
			@PathVariable("userList") ArrayList<User> userList, @PathVariable("project") Project project) {
		// TODO Auto-generated method stub

	}

	@RequestMapping(value = "/getTask/{taskId}", method = RequestMethod.GET)
	public int getTask(@PathVariable("taskID") int taskID) {
		return pH.getTask(taskID);

	}

	@RequestMapping(value = "/logout/{userId}", method = RequestMethod.GET)
	public boolean logout(@PathVariable("username") String username, @PathVariable("password") String password) {
		// TODO Auto-generated method stub
		return true;
	}

	@RequestMapping(value = "/setExpectedTime/{taskId}", method = RequestMethod.POST)
	public void setExpectedTime(@PathVariable("time") int tempTime, @PathVariable("task") Task task) {
		task.setExpectedTime(tempTime);

	}

	@RequestMapping(value = "/getExpectedTime/{taskId}", method = RequestMethod.GET)
	public int getExpectedTime(@PathVariable("task") Task task) {

		return task.getExpectedTime();
	}

	@RequestMapping(value = "/addGroupToProject/{project}", method = RequestMethod.POST)
	public void addGroupToProject(@PathVariable("uadmin") User uadmin,
			@PathVariable("userList") ArrayList<User> userList, @PathVariable("project") Project project) {
			for(User u : userList){
				project.addUsersToProject(u);
			}
		}

	@RequestMapping(value = "/getProjectID/{projectId}", method = RequestMethod.GET)
	public int getProjectID(@PathVariable("projectID") int projectID) {

		return pH.getProjectID(projectID);
	}

	@RequestMapping(value = "/setResponsibleTask/{taskId}", method = RequestMethod.POST)
	public void setResponsibleTask(@PathVariable("task") Task task,
			@PathVariable("responsibleUser") User responsibleUser) {

		task.setResponsibleUser(responsibleUser);

	}


}
