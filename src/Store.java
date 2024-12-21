/*
* File: Store.java
* Author: Klíber Benedek
* Copyright: 2024, Klíber Benedek
* Date: 2024-12-21
* Github: https://github.com/Elydra5
* License: MIT
*/

class Store {
    private final String password;
    private final String username;
    private final String location;

    public Store(String password, String username, String location) {
        this.password = password;
        this.username = username;
        this.location = location;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public String getLocation() {
        return location;
    }

    public boolean isHollow() {
        return password.isEmpty() || username.isEmpty() || location.isEmpty();
    }
}
