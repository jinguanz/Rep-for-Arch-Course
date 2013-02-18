package edu.cmu.mse.rui.J2ee.HW8.DataBean;
// default package



/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User  implements java.io.Serializable {


    // Fields    

     private Integer userId;
     private String emailAdd;
     private String firstName;
     private String lastName;
     private String password;


    // Constructors

    /** default constructor */
    public User() {
    }

    
    /** full constructor */
    public User(String emailAdd, String firstName, String lastName, String password) {
        this.emailAdd = emailAdd;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
    }

   
    // Property accessors

    public Integer getUserId() {
        return this.userId;
    }
    
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getEmailAdd() {
        return this.emailAdd;
    }
    
    public void setEmailAdd(String emailAdd) {
        this.emailAdd = emailAdd;
    }

    public String getFirstName() {
        return this.firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
   








}