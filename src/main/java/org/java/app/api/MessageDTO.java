package org.java.app.api;

public class MessageDTO {

	private int id;
    private String name;
    private String email;
    private String subject;

    public MessageDTO() {}
    public MessageDTO(String name, String email, String subject) {
        this.name = name;
        this.email = email;
        this.subject = subject;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
    
    @Override
	public String toString() {
		
		return  "id: " + getId()
				+ "\n text: " + getSubject() 
				+ "\n email: " + getEmail()
				+ "\n name: " + getName();
	}
}


