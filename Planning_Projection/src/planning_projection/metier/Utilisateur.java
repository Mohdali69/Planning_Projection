/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planning_projection.metier;

/**
 *
 * @author Asus
 */
public class Utilisateur {
    private String user;
    private String password;
    private String type;
    private int numUser;
    
    public Utilisateur(String user,String password,String type,int numUser){
        this.user=user;
        this.password=password;
        this.type=type;
        this.numUser=numUser;
    }

    /**
     * @return the user
     */
    public String getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the numUser
     */
    public int getNumUser() {
        return numUser;
    }

    /**
     * @param numUser the numUser to set
     */
    public void setNumUser(int numUser) {
        this.numUser = numUser;
    }
}
