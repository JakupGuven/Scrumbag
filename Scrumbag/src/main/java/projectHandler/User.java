package projectHandler;

public class User {
	private boolean admin;
	private String name;
	private String password;
	private int userID;

	

	public User(int userID, String userName, String password, boolean AdminOrNot) {
		this.userID=userID;
		this.name=userName;
		this.password=password;
		this.admin=AdminOrNot;
	}
	public boolean getAdminOrnot(){
		return admin;
	}
	
	public int getUserID(){
		return userID;
	}
	public String getUserName(String userName) {
		
		return userName;
		
	}


}
