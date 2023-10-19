package org.java.app.api;

public class CategoryDTO {

	private String name;

	public CategoryDTO() {}

	public CategoryDTO(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}

}

