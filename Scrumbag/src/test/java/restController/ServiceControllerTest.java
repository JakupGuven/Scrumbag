package restController;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import projectHandlerService.Project;
import projectHandlerService.Task;

public class ServiceControllerTest {
	private int time; // Each status have a different int
	private boolean access;
	private Task t;
	private Backlog bl;
	private Sprint s;
	private Project project;
	private User user, userTest;
	private Group group; // Should be a group object or an arrayList of users?
	private ServiceController c;
	private String name, RespondibleUser, taskDiscription;
	private int expectedTime, status, priority;
	private ArrayList arrayUser;
	private String password, username;
	private Object currentStatus;
	private Object taskprio;
	private Object actuallTime;
	private Object responsiblePerson;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		arrayTask = new ArrayList();
		arrayUser = new ArrayList();
		s = new Sprint();
		project = new Project();
		bl = new BackLog();
		userTest = new User();
		c = new Controller();
		group = new Group();
		t = new Task();
		status = 1;
		password = "123456";
		username = "mittAnvÃ¤ndarNamn";
		access = true;

	}

	@After
	public void tearDown() throws Exception {
	}

	// Test case = create task
	@Test
	public void tc1() {

		assertEquals(c.createTask(expectedTime, name, currentStatus, taskprio, responsiblePerson), true);
		// fail("Not yet implemented");
	}

	// Test case = change task status
	@Test
	public void tc2() {
		assertEquals(c.changeStatus(t, status), true);
	}

	// 3. Test case = remove task
	@Test
	public void tc3() {
		assertEquals(c.deleteTask(t), true);
	}

	// 4. Test case = edit task
	@Test
	public void tc4() {
		assertEquals(c.setAll(expectedTime, name, currentStatus, taskprio, responsiblePerson, actuallTime), true);

	}

	// 5. Test case = login
	@Test
	public void tc5() {
		user = c.login(username, password);
		assertSame(user, userTest);
	}

	// 6. Test case = logout
	@Test
	public void tc6() {
		assertEquals(c.logout(userTest), true);
	}

	// 7. Test case = set Task Time Expected
	@Test
	public void tc7() {
		Task t = new Task();
		int temp = 10;
		c.setActuallTime(temp, t);
		assertEquals(c.getActuallTime(t), temp);
	}

	// 8. Test case = set responsible task
	@Test
	public void tc8() {
		User userTemp = new User();
		assertEquals(c.setResponsibleTask(t, userTemp), true); //*
	}

	// 8. Test case = set responsible task
	// When you edit a task you will be able to edit the time as well
	// @Test
	// public void tc4() {
	// assertEquals(c.editTask(t, arrayTask), true);
	// }

	// 9. Test case = set task time spent
	//En användare skall kunna ange hur mycket 
	//tid som har spenderats på en specifik aktivitet. 
	// This operation should not be merged with another operation since the time
	// spent on a task will
	// always increase for each time someone makes progress on that task
	@Test
	public void tc9() {
		Task t = new Task();
		USer u = new User("KalleAnka", false);
		c.setTaskTimeUser(time, u, t);
		assertEquals(c.getTaskTimeUser(u, t), true); 
	}

	// 10. Test case = Admin create new user account
	@Test
	public void tc10() {
		assertEquals(c.newUser(userAdmin, name, adminOrNot), true);
		// Alternativt
		// assertEquals(c.newUser(userAdmin, arrayUser), true);
	}

	// 11. Test case = Admin add users to project
	@Test
	public void tc11() {
		User uAdmin = new User ("Anna" ,true);
		User userToPut = new User ("kalle" , false);
		assertEquals(c.addToProject(uAdmin, userToPut, project), true); 
		// Alternativt
		// assertEquals(c.newUser(userAdmin, userTest, project), true);
	}

	// 12. Test case = Admin delete users from a project
	@Test
	public void tc12() {
		User admin = new User("Anna", true);
		User userToPut = new User("kalle" ,false);
		assertEquals(c.deletUserFromProject(admin, userToPut, project), true); 
	}

	// 13. Test case = Admin add group to a project
	@Test
	public void tc13() {
		assertEquals(c.addGroupToProject(access, group, project), true); 
	}

	// 14. Test case = Admin delete group from a project
	@Test
	public void tc14() {
		assertEquals(c.deletGroupFromProject(access, group, project), true);
	}

	// 15. Test case = user can see registered tasks in a datastructure
	// 16. Test case = return responsible person for task
	// 17. Test case = return expected time for activities
	// 18. Test case = return activities time half day

	@Test
	public void tc15() {
		ArrayList<Task> tTemp = new ArrayList();
		ArrayList<Task> tList = new ArrayList();
		Task t1 = new Task();
		Task t2 = new Task();
		Task t3 = new Task();
		project.add(t1);
		project.add(t2);
		project.add(t3);
		tTemp.add(t1);
		tTemp.add(t2);
		tTemp.add(t3);

		tList = c.getTaskInProjects(userTest);

		assertEquals(tList, tTemp);
	}

	// 16. Test case = return responsible person for task

	// @Test
	// public void tc16() {
	// Object o = c.getTaskResponsibel(t);
	// assertEquals(o, o instanceof Task);
	// }

	// 17. Test case = return expected time for activities
	// @Test
	// public void tc17() {
	// Object tempTime;
	// assertEquals(tempTime = c.getTimeTask(t), tempTime instanceof Integer);
	//
	// }

	// 18. Test case = return activities time half day
	// @Test
	// public void tc18() {
	// int temp;
	//
	// }

	// 19. Test case = Display to â€œTask Board
	// ???
	@Test
	public void tc19() {
		ArrayList<Task> tList = new ArrayList();
		ArrayList<Task> tTemp = new ArrayList();
		Task t1 = new Task();
		Task t2 = new Task();
		tTemp.add(t1);
		tTemp.add(t2);
		s.addTask(t1);
		s.addTask(t2);
		tList = c.getTaskFromSprint(s);
		assertEquals(tList, tTemp);
	}

	// 20. Test case = Display activities status on â€œTask Boardâ€�
	// ???
	// @Test
	// public void tc20() {
	// assertEquals(c.showTaskStatus(t, status, tb), true);
	// }

	// 21. Test case = set activity status
	@Test
	public void tc21() {
		Task t = new Task t();
		c.setStatus(t, 1); 
		assertEquals(c.getStatus(t), 1);
	}

	// 20. Test case = Display activities status on â€œTask Boardâ€�
	// 22. Test case = control not started status
	// 23. Test case = control started status
	// 24. Test case = control for test status
	// 25. Test case = control done status
	// 26. Test case = control unplanned status
	// 27. Test case = control â€œhinder som finnsâ€� status
	@Test
	public void tc22() {
		int temp = 1;
		c.setStatus(t, temp);
		assertEquals(c.getStatus(t), temp);
	}

	// 28. Test case = add activity/task to backlog
	@Test
	public void tc28() {
		Task t = new Task();
		c.addTaskToBacklog(t);
		assertEquals(c.getTaskFromBacklog(t), true);
	}

	// 29. Test case = set backlog activity status
	// Redan lÃ¶st?
	//KOLLA UPP
	@Test
	public void tc29() {
		
		//c.setTaskStatusBacklog(t, status);
		assertEquals(c.getStatusFromBacklog(t, status), true);
	}

	// 30. Test case = set priority
	@Test
	public void tc30() {
		int temp1 = 0;
		c.setPriorityTask(t, temp1);
		assertEquals(c.getPriorityTask(t), temp1);
	}

	// 31. Test case = set project priority
	@Test
	public void tc31() {
		Project project = new Project(); 
		int temp = 0;
		c.setPriorityProject(project, temp);
		assertEquals(c.getProjectPriority(project), temp);

	}

}
