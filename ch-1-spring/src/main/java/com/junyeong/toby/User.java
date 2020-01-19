package com.junyeong.toby;

/**
 * User
 */
public class User {

    String id;
    String name;
    String password;

    /**
     * @return the id
     */
    public String getId() {
      return id;
    }
    /**
     * @return the name
     */
    public String getName() {
      return name;
    }
    /**
     * @return the password
     */
    public String getPassword() {
      return password;
    }
    /**
     * @param id the id to set
     */
    public void setId(String id) {
      this.id = id;
    }
    /**
     * @param name the name to set
     */
    public void setName(String name) {
      this.name = name;
    }
    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
      this.password = password;
    }
    
}