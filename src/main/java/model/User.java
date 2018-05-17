package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="user")
public class User{
	
	@Id
	@Column(name ="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name ="username")
	private String userName;
	
	@Column(name ="password")
	private String password;
	
	@Column (name = "idPermission")
	private String idPermission;
	
	
	public String getIdPermission() {
		return idPermission;
	}
	public void setIdPermission(String idPermission) {
		this.idPermission = idPermission;
	}
	public int getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", password=" + password + ", idPermission=" + idPermission
				+ "]";
	}

}