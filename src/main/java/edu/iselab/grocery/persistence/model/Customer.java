package edu.iselab.grocery.persistence.model;

public class Customer extends AbstractModel {

    private String fullName;
    
    public String phoneNumber;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
