package projectHandler;

import java.util.ArrayList;

import projectHandler.Task.PRIORITY;

public class Project {
	private User user;
	private ArrayList <User> userList;
	private int projektID;
	

	
	public Project(String projectName, int projectID, ArrayList<User> userList2) {
		this.userList=userList2;
		this.projektID=projektID;
	}

	public int getUserID(int userID) {
		return user.getUserID();

	}
	
	public int getProjektID(){
		return 432;
	}

	public ArrayList<User> getUserList(int projectId) {
		
		return null;
	}
	
	public int getProjectPriority(){
		return 0;
	}

	public void setPriority(PRIORITY priority) {
		// TODO Auto-generated method stub
		
	}

	public void addUsersToProject(User u) {
		// TODO Auto-generated method stub
		
	}

	public void deletUserFromProject(ArrayList<User> user2) {
		// TODO Auto-generated method stub
		
	}

}
