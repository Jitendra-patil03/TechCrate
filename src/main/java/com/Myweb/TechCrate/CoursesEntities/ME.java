package com.Myweb.TechCrate.CoursesEntities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
@Entity
@Table(name="me")
public class ME {
	@Id
	@Column(name="coursename")
	private String coursename;
	

	public String getCoursename() {
		return coursename;
	}
	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}


	@Lob
	@Column(name="data")
	private byte[] data;
	@Column(name="filename")
	private String filename;
	@Column(name="filetype")
	private String filetype;
	@Column(name="description")
	private String description;
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	ME(){}
	public ME(String courseName,String fileName,String fileType,byte[] data,String des){
		this.filename = fileName;
		this.filetype = fileType;
		this.data = data;
		this.coursename = courseName;
		this.description = des;
	}
	
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getFiletype() {
		return filetype;
	}
	public void setFiletype(String filetype) {
		this.filetype = filetype;
	}
	public byte[] getData() {
		return data;
	}


	public void setData(byte[] data) {
		this.data = data;
	}

}
