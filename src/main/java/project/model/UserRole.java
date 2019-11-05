package project.model;

public enum UserRole {
    ADMIN(1),
    USER(2);

    int i;

    private static UserRole[] arrayOfUserRole = UserRole.values();

    UserRole(int i) {
        this.i = i;
    }

    public int getI() {
        return i;
    }

    static public UserRole getUserRole(int i) {
        for (UserRole userRole : arrayOfUserRole) {
            if (userRole.getI() == i) {
                return userRole;
            }
        }
        return null;
    }

}
