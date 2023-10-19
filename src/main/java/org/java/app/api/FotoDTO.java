package org.java.app.api;

import java.util.List;

public class FotoDTO {
	
	private int id;
	private String title;
	private String description;
	private String photo;
	private boolean visibility;
	private List<CategoryDTO> categories;

	public FotoDTO() { }

	public FotoDTO(int id, String title, String description, String photo, boolean visibility, List<CategoryDTO> categories) {
		
		setId(id);
		setTitle(title);
		setDescription(description);
		setPhoto(photo);
		setVisibility(visibility);
		setCategories(categories);
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public boolean getVisibility() {
		return visibility;
	}

	public void setVisibility(boolean visibility) {
		this.visibility = visibility;
	}

	public List<CategoryDTO> getCategories() {
		return categories;
	}

	public void setCategories(List<CategoryDTO> categories) {
		this.categories = categories;
	}

	@Override
	public String toString() {

		return "title: " + getTitle()
			+ "\ndescription: " + getDescription();
	}
}