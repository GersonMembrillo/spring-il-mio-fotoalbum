package org.java.app;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToMany(mappedBy = "categories")
	@JsonBackReference
	private List<Foto> fotos;
	
	@Column(nullable = false)
	private String name;
	
	public Category() { }
	public Category(String name) {
		
		setName(name);
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

	public List<Foto> getFotos() {
		return fotos;
	}
	public void setFotos(List<Foto> fotos) {
		this.fotos = fotos;
	}
	
	@Override
	public String toString() {
		
		return "[" + getId() + "] " + getName();
	}
	
	@Override
	public int hashCode( ) {
		
		return getId();
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if (!(obj instanceof  Category)) return false;
		
		Category objIng = (Category) obj;
		
		return getId() == objIng.getId();
		
	}
}
