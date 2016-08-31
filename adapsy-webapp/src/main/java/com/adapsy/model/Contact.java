package com.adapsy.model;

public class Contact {
	
	private Long id;
	private String nom;
	private String prenom;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getPrenom() {
		return prenom;
	}
	
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		boolean res = super.equals(obj);
		
		if (getId() != null && obj != null && obj instanceof Contact) {
			Contact other = (Contact) obj;
			
			if (other.getId() != null) {
				res = getId().equals(other.getId());
			}
		}
		
		return res;
	}

	@Override
	public String toString() {
		return String.format("[%d] %d %d", id != null ? id : -1, prenom != null ? prenom : "", nom != null ? nom : "");
	}

}
