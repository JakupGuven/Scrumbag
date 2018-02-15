package restController;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ServiceControllerTest {
	private int status, time; // Each status have a different int
	private boolean access;
	private Task t;
	private Backlog bl;
	private Project project;
	private User user, userTest;
	private Group group; // Should be a group object or an arrayList of users?
	private ServiceController c;
	private ArrayList arrayTask;
	private ArrayList arrayUser;
	private String password, username;

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
		project = new Project();
		bl = new BackLog();
		userTest = new User();
		c = new Controller();
		group = new Group();
		t = new Task();
		status = 1;
		password = "123456";
		username = "mittAnvändarNamn";
		access = true;

	}

	@After
	public void tearDown() throws Exception {
	}

	// Test case = create task
	@Test
	public void tc1() {
		assertEquals(c.createTask(arrayTask), true);
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
	// 7. Test case = set Task Time Expected
	// 8. Test case = set responsible task
	// When you edit a task you will be able to edit the time as well
	@Test
	public void tc4() {
		assertEquals(c.editTask(t, arrayTask), true);
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
	// public void tc7(){
	// assertEquals(c.setTimeTask(t, time), true);
	// }

	// 8. Test case = set responsible task
	// @Test
	// public void tc8() {
	// assertEquals(c.delagateTask(t, userExp), true);
	// }

	// 9. Test case = set task time spent
	// This operation should not be merged with another operation since the time
	// spent on a task will
	// always increase for each time someone makes progress on that task
	@Test
	public void tc9() {
		assertEquals(c.setTaskTime(time, userTest), true);
	}

	// 10. Test case = Admin create new user account
	@Test
	public void tc10() {
		assertEquals(c.newUser(access, arrayUser), true);
		// Alternativt
		// assertEquals(c.newUser(userAdmin, arrayUser), true);
	}

	// 11. Test case = Admin add users to project
	@Test
	public void tc11() {
		assertEquals(c.addToProject(access, userTest, project), true);
		// Alternativt
		// assertEquals(c.newUser(userAdmin, userTest, project), true);
	}

	// 12. Test case = Admin delete users from a project
	@Test
	public void tc12() {
		assertEquals(c.deletUserFromProject(access, userTest, project), true);
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

	// 15. Test case = return user time spent
	@Test
	public void tc15() {
		int time = c.getTimSpentUser(userTest, t);
		//???

	}

	// 16. Test case = return responsible person for task

	@Test
	public void tc16() {
		Object o = c.getTaskResponsibel(t);
		assertEquals(o, o instanceof Task);
	}

	// 17. Test case = return expected time for activities
	@Test
	public void tc17() {
		Object tempTime;
		assertEquals(tempTime = c.getTimeTask(t), tempTime instanceof Integer);

	}

	// 18. Test case = return activities time half day
	@Test
	public void tc18() {
		// ?????
	
	}

	// 19. Test case = Display to “Task Board
	//???
	@Test
	public void tc19() {
		assertEquals(c.showTaskBoard(t, tb), true);
	}

	// 20. Test case = Display activities status on “Task Board”
	//???
	@Test
	public void tc20() {
		assertEquals(c.showTaskStatus(t, status, tb), true);
	}

	// 21. Test case = set activity status
	@Test
	public void tc21() {
		assertEquals(c.setStatus(t, status), true);
	}

	// 22. Test case = control not started status
	// 23. Test case = control started status
	// 24. Test case = control for test status
	// 25. Test case = control done status
	// 26. Test case = control unplanned status
	// 27. Test case = control “hinder som finns” status
	@Test
	public void tc22() {
		int temp;
		c.setStatus(t, temp);
		assertEquals(c.getStatus(t), temp);
	}

	// 28. Test case = add activity/task to backlog
	@Test
	public void tc28() {
		assertEquals(c.addTaskToBl(t), true);
	}

	// 29. Test case = set backlog activity status
	// Redan löst? 
	@Test
	public void tc29() {
		assertEquals(c.setTaskStatusBl(t, status), true);
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
		int temp = 0;
		c.setPriorityProject(project, temp);
		assertEquals(c.getProjectPriority(), temp);

	}

}
