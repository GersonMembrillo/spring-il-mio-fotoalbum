package org.java.app;

import java.util.Arrays;
import java.util.List;

import org.hibernate.validator.constraints.Length;
import com.fasterxml.jackson.annotation.JsonBackReference;
import org.java.app.api.FotoDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Foto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false, unique = true, length = 64)
	@Length(min = 3, max = 64, message = "Il titolo deve essere compreso tra 3 e 64 caratteri")
	private String title;
	
	@Length(max = 255)
	private String description;
	
	@Length(max = 255)
	private String photo;
	
	private boolean visibility;
	
//	@Length(max = 255)
//	private String category;
	
	@ManyToMany
	@JsonBackReference
	private List<Category> categories;
	
	public Foto() { }
	public Foto(String title, String description, String photo, boolean visibility, Category...categories) {
		
		setTitle(title);
		setDescription(description);
		setPhoto(photo);
		setVisibility(visibility);
//		setCategory(category);
		setCategories(Arrays.asList(categories));
	}
	public Foto(FotoDTO fotoDto) {

		fillFromDto(fotoDto);

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
//	public String getCategory() {
//		return category;
//	}
//	public void setCategory(String category) {
//		this.category = category;
//	}
	
	public List<Category> getCategories() {
		return categories;
	}
	
	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	
	public void deleteCategory(Category category) {
		
		getCategories().remove(category);
	}
	
	public void fillFromDto(FotoDTO fotoDto) {

		setTitle(fotoDto.getTitle());
		setDescription(fotoDto.getDescription());
	}
	
	@Override
	public String toString() {
		
		return "["+ getId() + "] " + getTitle() + ": + getDescription()"  + "\n"			
				+ getPhoto() + "\n" 
				+ getVisibility(); 
//				+ getCategory();
				
	}
	
	public Foto get() {
		// TODO Auto-generated method stub
		return null;
	}

}
