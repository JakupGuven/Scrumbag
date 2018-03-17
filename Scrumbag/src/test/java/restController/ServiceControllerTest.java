package restController;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import projectHandler.User;
import projectHandler.Group;
import projectHandler.Project;
import projectHandler.ProjectHandler;
import projectHandler.Task;
import projectHandler.Task.PRIORITY;
import projectHandler.Task.STATUS;

public class ServiceControllerTest {
	private int time; // Each status have a different int
	private boolean access;
	private projectHandler.Task t;
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
		
		int projectID = 10;
		int taskID = 10; 
		String taskName; 
		String responsiblePerson;
		int taskPriority;
		int taskStatus; 
		int expectedTime;
	
		c.createTask(projectID, taskName, responsiblePerson, taskPriority,
				 taskStatus);
		
		assertEquals(taskID, c.getTask(taskID));
		
		// fail("Not yet implemented");
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
		Task task = new Task(4, "Call the police", "Johan", 2, PRIORITY.LOW, STATUS.FOR_TEST);
		c.setAll("Call the FBI", "Bert", 1, 1, 15);
		assertEquals(task.getTaskName(), "Call the police");
		

	}

	// 5. Test case = login
	@Test
	public void tc5() {
		String userName= "kisseKatten96";
		String password = "123abc";
		User user = new User(46283, userName, password, false);
		
		assertSame(c.login(username, password), true );  //logiskt att just denna returnerar en true?
	}

	// 6. Test case = logout
	@Test
	public void tc6() {
		String userName= "kisseKatten96";
		String password = "123abc";
		User user = new User(46283, userName, password, false);
		c.login(username, password);
		assertEquals(c.logout(username, password), true);  
	}
	
	// 7. Test case = set Task Time Expected
	@Test
	public void tc7() {
		int projectID = 5;
		String taskName = "Scrum Meeting";
		String responsibleUser = "kisseKatten96";
		int expectedTime = 10; 
		
		Task task = new Task(projectID, taskName, responsibleUser, expectedTime, PRIORITY.LOW, STATUS.FOR_TEST); //Fixa rätt parametrar			
		int tempTime = 10;
//		c.setActuallTime(temp, t);
		c.setExpectedTime(tempTime, task);
		assertEquals(c.getExpectedTime(task), tempTime);  //byt namn till getExpectedTime
	}

	// 8. Test case = set responsible task
	@Test
	public void tc8() {
		String userName= "kisseKatten96";
		String password = "123abc";
		User user = new User(5928, userName, password, false);
		Task task = new Task(projectID, taskName, responsibleUser, expectedTime, priority, status);//Fixa rätt parametrar 
	
		c.setResponsibleTask(task, user); //och sätt userTemp.getName/id som responsible person		
		assertEquals(userName, task.getResponsibleUser()); 
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
		
		Task task = new Task(10, "Scrum Meeting", "Dina", 15, PRIORITY.MEDIUM, STATUS.DONE);
		User user = new User(15, "Dina", "kelf121", false); 
		c.setTaskTimeUser(15, user, task);
		assertEquals(15, t.getElapsedTime()); 
	}


	// 10. Test case = Admin create new user account
	@Test
	public void tc10() {
		String userName = "Janne93";
		String password = "Andersson12";
		int userID = 45;
		boolean AdminOrNot = false;
		User user = new User(userID , userName, password, AdminOrNot); 
	    User userAdmin = new User(12,"Anna", "hej123", true);
	    
		c.newUser(userAdmin, userName, false);
		assertEquals(userName, user.getUserName(userName)); 
		// Alternativt
		// assertEquals(c.newUser(userAdmin, arrayUser), true);
	}

	// 11. Test case = Admin add users to project
	@Test
	public void tc11() {
		User uAdmin = new User (12,"Anna", "hej123", true);
		User userToPut = new User (18, "Linda" , "lalal12", false);
		int userID = 18;
		ArrayList<String> userList;
		Project project = new Project("The crew", 200, userID, userList); 
		
		c.addUsersToProject(uAdmin, userToPut, project);
		
		assertEquals(userID, project.getUserID(userID)); //Osäker på denna om man ska lägga in en user i userList
		
		// Alternativt
		// assertEquals(c.newUser(userAdmin, userTest, project), true);
	}

	// 12. Test case = Admin delete users from a project
	@Test
	public void tc12() {
		User admin = new User(12, "Anna", "hej123", true);
		User userToPut = new User(18, "Linda" , "lalal12", false);
		int userID = 18;
		ArrayList<String> userList;
		Project project = new Project("The crew", 200, userID, userList); 
		
		c.deletUserFromProject(admin, userToPut, project); //Osäker på denna om man ska ta bort en user från en userList
		assertEquals(userID, null); 
	}

	// 13. Test case = Admin add group to a project
	@Test
	public void tc13() {
		
		int projectID = 100; 
		String projectName; 
		User uadmin = new User(12, "Anna", "hej123", true);
		ArrayList<String>userList;
		userList.add("Emma");
		userList.add("Sara"); 
		int userID;
		
		Project project = new Project(projectName, projectID, userID, userList); 
		
		c.addGroupToProject(uadmin, userList, projectID);
		
		assertEquals(userList, project.getusers(userList)); 
	}

	// 14. Test case = Admin delete group from a project
	@Test
	public void tc14() {

		User uadmin = new User(12, "Anna", "hej123", true);
		int projectID = 100;
		String projectName = "Number one";
		int userID;
		ArrayList<String> userList;
		userList.add("Emma");
		userList.add("Sara"); 
		Project project = new Project(projectName, projectID, userID,userList ); 
		
		c.deletGroupFromProject(true, userList, project);
		assertEquals(null, project.getusers(userList)); 
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
