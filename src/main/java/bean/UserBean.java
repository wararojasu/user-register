package bean;

public class UserBean {

	private String name;
	private int age;
	private String password;

	public UserBean() {

	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean isOwnerUser(String user) {
		boolean isOwner = false;
		if (user.equals("wara")) {
			isOwner = true;
		}
		return isOwner;
	}

	public boolean onlyChars(String user) {
		if (user == null) {
			return false;
		}
		int len = user.length();
		for (int i = 0; i < len; i++) {
			if ((Character.isLetter(user.charAt(i)) == false)) {
				return false;
			}
		}
		return true;
	}

	public boolean userNoMoreThanSixChars(String user) {
		if (user.length() > 6) {
			return false;
		}
		return true;
	}
	
	public void cleanFields() {
		this.name = "";
		this.age = 0;
	}
	
	public String action() {
		if (!onlyChars(this.name)) {
			cleanFields();
			return "";
		}else {
			if (isOwnerUser(this.name)) {
				cleanFields();
				return "connect";
			} else {
				cleanFields();
				return null;
			}
		}
	}
}