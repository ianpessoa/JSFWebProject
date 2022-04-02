package main.java.util;

import main.java.entities.User;

public class Util {
	static private User user;

	public static User getUser() {
		return user;
	}

	public static void setUser(User user) {
		Util.user = user;
	}
	
	
}
