package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="words")
public class Words{
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name= "id")
	private int id;
	
	@Column(name ="words")
	private String words;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getWords() {
		return words;
	}
	public void setWords(String words) {
		this.words = words;
	}
	
	public Words(int id, String words) {
		this.id = id;
		this.words = words;
	}
	
	
	public Words() {
		super();
	}
	@Override
	public String toString() {
		return "Words [id=" + id + ", words=" + words + "]";
	}
	
}
