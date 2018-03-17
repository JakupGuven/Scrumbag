package projectHandler;

public class Task {

	private String taskName;
	//maybe User class instead?
	private User responsibleUser;
	
	private int taskID;
	private int expectedTime;
	private int elapsedTime;
	private int elapsedTimeHalfDays;
	private PRIORITY taskPriority;
	private STATUS taskStatus;
	private int projectID;
	
	
	public static enum PRIORITY{
		HIGH, MEDIUM, LOW;
	}

	
	public static enum STATUS{
		NOT_STARTED, STARTED, FOR_TEST, DONE, UNPLANNED, IMPEDIMENTS;
	}
	
	public Task(int projectID, String taskName, String responsibleUser, int expectedTime, Task.PRIORITY priority, Task.STATUS status) {
		
	}

	
	
	public void setProjectID(int projectID) {
		
	}
	
	public int getProjectID() {
		
		return 0; 
		
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public User getResponsibleUser() {
		return responsibleUser;
	}

	public void setResponsibleUser(User responsibleUser) {
		this.responsibleUser = responsibleUser;
	}

	public int getTaskID() {
		return taskID;
	}

	private void setTaskID(int taskID) {
		this.taskID = taskID;
	}

	public int getExpectedTime() {
		return expectedTime;
	}

	public void setExpectedTime(int expectedTime) {
		this.expectedTime = expectedTime;
	}

	public int getElapsedTime() {
		return elapsedTime;
	}

	public void setElapsedTime(int elapsedTime) {
		this.elapsedTime = elapsedTime;
	}

	public PRIORITY getTaskPriority() {
		return taskPriority;
	}

	public void setTaskPriority(int taskPriority) {
	}

	public STATUS getTaskStatus() {
		return taskStatus;
	}
	

	public void setTaskStatus(STATUS taskStatus) {
	}

	public int getElapsedTimeHalfDays() {
		return elapsedTimeHalfDays;
	}

	public void setElapsedTimeHalfDays(int elapsedTimeHalfDays) {
		this.elapsedTimeHalfDays = elapsedTimeHalfDays;
	}






}
