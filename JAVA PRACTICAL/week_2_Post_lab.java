class UserSession {
    private static UserSession instance;
    private boolean loggedIn;
    private UserSession() {}
    public static UserSession getInstance() {
        if (instance == null) {
            instance = new UserSession();
        }
        return instance;
    }
    public void login() {
        loggedIn = true;
    }
    public void logout() {
        loggedIn = false;
    }
    public boolean isLoggedIn() {
        return loggedIn;
    }
}

public class week_2_Post_lab {
    public static void main(String[] args) {
        UserSession session = UserSession.getInstance();
        session.login();
        if (session.isLoggedIn()) {
            System.out.println("User is logged in. You can view balance, deposit, or withdraw.");
        }
    }
}
