package org.java.app.api;

public class FotoDTO {

	private String title;
	private String description;

	public FotoDTO() { }
	public FotoDTO(String title, String description) {

		setTitle(title);
		setDescription(description);
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {

		return "title: " + getTitle()
			+ "\ndescription: " + getDescription();
	}
}
