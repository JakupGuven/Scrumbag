package projectHandler;

public class Task {

	private String taskName;

	private User responsibleUser;

	private int taskID;
	private int expectedTime;
	private int elapsedTime;
	private int elapsedTimeHalfDays;
	private PRIORITY taskPriority;
	private STATUS taskStatus;
	
	
	public static enum PRIORITY{
		HIGH, MEDIUM, LOW;
	}

	
	public static enum STATUS{
		NOT_STARTED, STARTED, FOR_TEST, DONE, UNPLANNED, IMPEDIMENTS;
	}
	
	public Task(String taskName, int expectedTime, int taskPriority, int taskStatus, String responsibleUser) {
		
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

	public void setTaskStatus(int taskStatus) {
	}

	public int getElapsedTimeHalfDays() {
		return elapsedTimeHalfDays;
	}

	public void setElapsedTimeHalfDays(int elapsedTimeHalfDays) {
		this.elapsedTimeHalfDays = elapsedTimeHalfDays;
	}

}
