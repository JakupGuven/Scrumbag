package restController;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestCases {
	private int status; //Each status have a different int
	private Task t;
	private User user, userExp;
	private ServiceController c;
	private ArrayList arrayTask;
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
		userExp = new User();
		t = new Task();
		c = new Controller();
		status = 1;
		password = "123456";
		username = "mittAnvändarNamn";
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
		assertSame(user, userExp);
	}
	
	//6. Test case = logout
	@Test
	public void tc6() {
		assertEquals(c.logout(userExp), true);	
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

	

}
