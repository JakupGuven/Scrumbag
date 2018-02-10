package restController;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestCases {
	private int status, time; //Each status have a different int
	private boolean access;
	private Task t;
	private Project project;
	private User user, userTest;
	private Group group; //Should be a group object or an arrayList of users? 
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
//		fail("Not yet implemented");
	}

	//Test case = change task status
	@Test
	public void tc2(){
		assertEquals(c.changeStatus(t, status), true);
	}
	
	//3. Test case = remove task
	@Test
	public void tc3(){
		assertEquals(c.deleteTask(t), true);
	}
	
	//4. Test case = edit task
	//7. Test case = set Task Time Expected 
	//8. Test case = set responsible task
	//When you edit a task you will be able to edit the time as well
	@Test
	public void tc4(){
		assertEquals(c.editTask(t, arrayTask),  true);
	}
	
	//5. Test case = login
	@Test
	public void tc5() {
		user = c.login(username, password);
		assertSame(user, userTest);
	}
	
	//6. Test case = logout
	@Test
	public void tc6() {
		assertEquals(c.logout(userTest), true);	
	}
	
	//7. Test case = set Task Time Expected 
//	public void tc7(){
//		assertEquals(c.setTimeTask(t, time), true);
//	}
	
	//8. Test case = set responsible task
//	@Test
//	public void tc8() {
//		assertEquals(c.delagateTask(t, userExp), true);
//	}

//	9. Test case = set task time spent
//  This operation should not be merged with another operation since the time spent on a task will
//	always increase for each time someone makes progress on that task
	@Test
	public void tc9(){
		assertEquals(c.setTaskTime(time, userTest), true); 
	}
	
	
//	10. Test case = Admin create new user account
	@Test
	public void tc10(){
		assertEquals(c.newUser(access, arrayUser), true);
//		Alternativt
//		assertEquals(c.newUser(userAdmin, arrayUser), true); 
	}
	
//	11. Test case = Admin add users to project
	@Test
	public void tc11(){
		assertEquals(c.addToProject(access, userTest, project), true);
//		Alternativt
//		assertEquals(c.newUser(userAdmin, userTest, project), true); 
	}

//	12. Test case = Admin delete users from a project
	@Test
	public void tc12(){
		assertEquals(c.deletUserFromProject(access, userTest, project), true);
	}
	
//	13. Test case = Admin add group to a project
	@Test
	public void tc13(){
		assertEquals(c.addGroupToProject(access, group, project), true);
	}
	
//	14. Test case = Admin delete group from a project

	public void tc14(){
		
	}
	
	
	

}
