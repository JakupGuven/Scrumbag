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
	public Object setAll(@PathVariable("task") Task task, @PathVariable("expectedTime")int expectedTime,@PathVariable("name") String name,@PathVariable("currentStatus") Object currentStatus,
			@PathVariable("taskprio") Object taskprio,@PathVariable("responsiblePerson") Object responsiblePerson,
			@PathVariable("actuallTime")Object actuallTime) {
			task.setAll(expectedTime, name, currentStatus, taskprio, responsiblePerson, actuallTime);
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

	}
}
