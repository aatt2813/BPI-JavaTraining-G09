/**
 * 
 */
package group_9;
public class User {
	
	private int libraryID;
	private String name;
	private int pointer;
	
	private int [] libraryIDNum = {200105, 200106, 200107, 200108, 200109};
	private String [] libraryMembers = {"Elias", "Felicity", "Gunther", "Hensessy", "Iliana"};
	
	
	private void setLibraryID() {
		this.libraryID = libraryID; 
	}
	
	public int getLibraryID() {
		return this.libraryID; 
	}
	
	private void foundPosition(int pointer) {
		this.pointer = pointer;
	}
	
	private int getPosition() {
		return this.pointer;
	}
	
	//private void setCurrentUser(String name) {
	//	this.name = name;
	//}
	
	//private String getCurrentUser() {
	//	return this.name;
	//}
	
	
    // Returns true if 'libraryID' exists in 'libraryIDNum'; otherwise false
	public boolean checkUserID(int libraryID) {
		int j = 0;
        for (int id : libraryIDNum) {
			if (id == libraryID) {
				// System.out.println("foundPosition = " + j);
            	foundPosition(j);
            	// System.out.println("getPosition = " + getPosition());
            	// System.out.println("expected user = " + libraryMembers[getPosition()]);
            	// setCurrentUser(libraryMembers[getPosition()]);
                return true; // found				
            }
			j++;
        }
        return false; // not found
    }
	
	public boolean checkUserName(String name) {
		// System.out.println("Inside checkUserName()");
		// System.out.println("name: " + name);
		// System.out.println("getCurrentUser(): " + getCurrentUser());
		// needed to trim to ensure validation is not encountering problem due to trailing spaces
		if (name.trim().equals(libraryMembers[getPosition()].trim())) {
			return true;
		}
		return false;
	}
	
}

