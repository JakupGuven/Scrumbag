package restController;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import projectHandler.*;
import projectHandler.Task.PRIORITY;
import projectHandler.Task.STATUS;
import restController.ServiceController;

public class test {

	private ServiceController c;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		c = new ServiceController();

	}

	@After
	public void tearDown() throws Exception {
	}

	// Test case = create task
	@Test
	public void tc1() {
		int taskID = 4123;
		c.createTask(4123, "First task", STATUS.FOR_TEST, PRIORITY.MEDIUM, "Lars");
		assertEquals(taskID, c.getTask(taskID));
	}

	// Test case = change task status
	@Test
	public void tc2() {
		STATUS taskStatus = STATUS.UNPLANNED;
		Task task = new Task(0, "Make a sandwich", "Kalle", 3, PRIORITY.LOW, taskStatus);
		c.changeStatus(task, taskStatus);
		assertEquals(taskStatus, c.getStatus(task));

	}

	// 3. Test case = remove task

	@Test
	public void tc3() {
		int taskID = 1;
		Task task = new Task(taskID, "Drive to the store", "Ann-marie", 3, PRIORITY.HIGH, STATUS.DONE);
		c.deleteTask(task);
		assertEquals(null, c.getTask(taskID));
	}

	// 4. Test case = edit task
	@Test
	public void tc4() {
		Task task = new Task(134, "Call the police", "Johan", 2, PRIORITY.LOW, STATUS.FOR_TEST);
		c.setAll(task, 123, "Call the FBI", "Bert", PRIORITY.MEDIUM, STATUS.IMPEDIMENTS, 15);
		assertEquals(task.getTaskName(), "Call the police");

	}

	// 5. Test case = login
	@Test
	public void tc5() {
		String userName = "kisseKatten96";
		String password = "123abc";
		User user = new User(46283, userName, password, false);

		assertTrue(c.login(userName, password)); // logiskt att just denna
													// returnerar en true?
	}

	// 6. Test case = logout
	@Test
	public void tc6() {
		String userName = "kisseKatten96";
		String password = "123abc";
		User user = new User(46283, userName, password, false);
		c.login(userName, password);
		assertTrue(c.logout(userName, password));
	}

	// 7. Test case = set Task Time Expected
	@Test
	public void tc7() {
		int projectID = 5;
		String taskName = "Scrum Meeting";
		String responsibleUser = "kisseKatten96";
		int expectedTime = 10;

		Task task = new Task(projectID, taskName, responsibleUser, expectedTime, PRIORITY.LOW, STATUS.FOR_TEST); // Fixa
																													// rätt
																													// parametrar
		int tempTime = 10;
		// c.setActuallTime(temp, t);
		c.setExpectedTime(tempTime, task);
		assertEquals(c.getExpectedTime(task), tempTime); // byt namn till
															// getExpectedTime
	}

	// 8. Test case = set responsible task
	@Test
	public void tc8() {
		String userName = "kisseKatten96";
		String password = "123abc";
		User user = new User(5928, userName, password, false);
		Task task = new Task(2342, "Cook food", "Nadia", 30, PRIORITY.LOW, STATUS.STARTED);// Fixa
																							// rätt
																							// parametrar

		c.setResponsibleTask(task, user); // och sätt userTemp.getName/id som
											// responsible person
		assertEquals(userName, task.getResponsibleUser());
	}

	// 9. Test case = set task time spent
	@Test
	public void tc9() {
		int time = 30;
		Task task = new Task(1320, "Scrum Meeting", "Dina", 15, PRIORITY.MEDIUM, STATUS.DONE);
		User user = new User(123215, "Dina", "kelf121", false);
		c.setTaskTimeUser(time, user, task);
		assertEquals(time, task.getElapsedTime());
	}

	// 10. Test case = Admin create new user account
	@Test
	public void tc10() {
		String userName = "Janne93";
		String password = "Andersson12";
		int userID = 45;
		boolean AdminOrNot = false;
		User user = new User(userID, userName, password, AdminOrNot);
		User userAdmin = new User(12, "Anna", "hej123", true);

		c.newUser(userAdmin, userName, password, false);
		assertEquals(userName, user.getUserName(userName));
		// Alternativt
		// assertEquals(c.newUser(userAdmin, arrayUser), true);
	}

	// 11. Test case = Admin add users to project
	@Test
	public void tc11() {
		User uAdmin = new User(12, "Anna", "hej123", true);
		User userToPut = new User(18, "Linda", "lalal12", false);
		int userID = 18;
		ArrayList<User> userList = new ArrayList<User>();
		Project project = new Project("The crew", 200, userList);
		userList.add(userToPut);

		c.addGroupToProject(uAdmin, userList, project);

		assertEquals(userID, project.getUserID(userID)); // Osäker på denna om
															// man ska lägga in
															// en user i
															// userList

		// Alternativt
		// assertEquals(c.newUser(userAdmin, userTest, project), true);
	}

	// 12. Test case = Admin delete users from a project
	@Test
	public void tc12() {
		User admin = new User(12, "Anna", "hej123", true);
		User userToPut = new User(18, "Linda", "lalal12", false);
		int userID = 18;
		ArrayList<User> userList = new ArrayList<User>();
		userList.add(userToPut);
		Project project = new Project("The crew", 200, userList);

		c.deletUserFromProject(admin, userList, project); // Osäker på denna om
															// man ska ta bort
															// en user från en
															// userList
		assertEquals(userID, null);
	}

	// 13. Test case = Admin add group to a project
	@Test
	public void tc13() {
		User userToPut = new User(18234, "Anna", "lalal12", false);
		User userToPutTwo = new User(13218, "Linda", "kasd33", false);
		User uadmin = new User(12, "Anna", "hej123", true);
		ArrayList<User> userList = new ArrayList<User>();
		Project project = new Project("Going to the mall", 21214, userList);
		userList.add(userToPut);
		userList.add(userToPutTwo);
		c.addGroupToProject(uadmin, userList, project);
		assertEquals(userList, project.getUserList(project.getProjektID()));
	}

	// 14. Test case = Admin delete group from a project
	@Test
	public void tc14() {
		User uadmin = new User(11232, "Anna", "hej123", true);
		User userOne = new User(1122, "Erik", "hej123", false);
		User userTwo = new User(14352, "Carl-Fredrik", "hej123", false);
		ArrayList<User> userList = new ArrayList<User>();
		userList.add(userOne);
		userList.add(userTwo);
		Project project = new Project("projektet", 124123, userList);

		c.deletGroupFromProject(uadmin.getAdminOrnot(), userList, project);
		assertNull(project.getUserList(project.getProjektID()));
	}

	// 15. Test case = user can see registered tasks in a datastructure
	@Test
	public void tc15() {
		User u = new User(11232, "Anna", "hej123", false);
		Task task = new Task(1320, "Scrum Meeting", "Dina", 15, PRIORITY.MEDIUM, STATUS.DONE);
		task.setResponsibleUser(u);
		ArrayList<User> userList = new ArrayList<User>();
		userList.add(u);
		Project project = new Project("projektet", 124123, userList);
		assertEquals(u, project.getUserID(u.getUserID()));
	}

	// 16. Test case = return responsible person for task
	@Test
	public void tc16() {
		User u = new User(11232, "Anna", "hej123", false);
		Task task = new Task(1320, "Scrum Meeting", "Dina", 15, PRIORITY.MEDIUM, STATUS.DONE);
		task.setResponsibleUser(u);
		assertEquals(u, task.getResponsibleUser());
	}

	// 17. Test case = return expected time for activities
	@Test
	public void tc17() {
		Task task = new Task(1320, "Scrum Meeting", "Dina", 15, PRIORITY.MEDIUM, STATUS.DONE);
		task.setElapsedTime(10);
		assertEquals(10, task.getElapsedTime());
	}

	// 18. Test case = return activities time half day
	@Test
	public void tc18() {
		Task task = new Task(1320, "Scrum Meeting", "Dina", 15, PRIORITY.MEDIUM, STATUS.DONE);
		task.setElapsedTime(12);
		assertEquals(3, task.getElapsedTimeHalfDays());
	}

	// 21. Test case = set activity status
	@Test
	public void tc21() {
		Task task = new Task(1320, "Scrum Meeting", "Dina", 15, PRIORITY.MEDIUM, STATUS.DONE);
		task.setTaskStatus(STATUS.FOR_TEST);
		assertEquals(STATUS.FOR_TEST, task.getTaskStatus());
	}

	// 22. Test case = control not started status
	@Test
	public void tc22() {
		Task task = new Task(1320, "Scrum Meeting", "Dina", 15, PRIORITY.MEDIUM, STATUS.NOT_STARTED);
		assertEquals(STATUS.NOT_STARTED, task.getTaskStatus());
	}

	// 23. Test case = control started status
	@Test
	public void tc23() {
		Task task = new Task(1320, "Scrum Meeting", "Dina", 15, PRIORITY.MEDIUM, STATUS.STARTED);
		assertEquals(STATUS.STARTED, task.getTaskStatus());
	}

	// 24. Test case = control for test status
	@Test
	public void tc24() {
		Task task = new Task(1320, "Scrum Meeting", "Dina", 15, PRIORITY.MEDIUM, STATUS.FOR_TEST);
		assertEquals(STATUS.FOR_TEST, task.getTaskStatus());
	}

	// 25. Test case = control done status
	@Test
	public void tc25() {
		Task task = new Task(1320, "Scrum Meeting", "Dina", 15, PRIORITY.MEDIUM, STATUS.DONE);
		assertEquals(STATUS.DONE, task.getTaskStatus());
	}

	// 26. Test case = control unplanned status
	@Test
	public void tc26() {
		Task task = new Task(1320, "Scrum Meeting", "Dina", 15, PRIORITY.MEDIUM, STATUS.UNPLANNED);
		assertEquals(STATUS.UNPLANNED, task.getTaskStatus());
	}

	// 27. Test case = control â€œhinder som finnsâ€� status
	@Test
	public void tc27() {
		Task task = new Task(1320, "Scrum Meeting", "Dina", 15, PRIORITY.MEDIUM, STATUS.IMPEDIMENTS);
		assertEquals(STATUS.IMPEDIMENTS, task.getTaskStatus());
	}

	// 28. Test case = add activity/task to backlog
	@Test
	public void tc28() {
		Task t = new Task(1320, "Scrum Meeting", "Dina", 15, PRIORITY.MEDIUM, STATUS.IMPEDIMENTS);
		Backlog bl = new Backlog();
		bl.add(t);

		assertEquals(bl.getTaskFromBacklog(t), true);
	}

	// 29. Test case = set backlog activity status
	@Test
	public void tc29() {
		Task t = new Task(1320, "Scrum Meeting", "Dina", 15, PRIORITY.MEDIUM, STATUS.IMPEDIMENTS);
		Backlog bl = new Backlog();
		bl.add(t);
		assertEquals(bl.getTaskFromBacklog(t).getTaskStatus(), STATUS.IMPEDIMENTS);
	}

	// 30. Test case = set priority
	@Test
	public void tc30() {
		Task t = new Task(1320, "Scrum Meeting", "Dina", 15, PRIORITY.MEDIUM, STATUS.IMPEDIMENTS);
		assertEquals(c.getPriorityTask(t), PRIORITY.MEDIUM);
	}

	// 31. Test case = set project priority
	@Test
	public void tc31() {
		User u = new User(11232, "Anna", "hej123", false);
		Task task = new Task(1320, "Scrum Meeting", "Dina", 15, PRIORITY.MEDIUM, STATUS.DONE);
		task.setResponsibleUser(u);
		ArrayList<User> userList = new ArrayList<User>();
		userList.add(u);
		Project project = new Project("projektet", 124123, userList);
		project.setPriority(PRIORITY.MEDIUM);
		assertEquals(project.getProjectPriority(), PRIORITY.MEDIUM);

	}

}
