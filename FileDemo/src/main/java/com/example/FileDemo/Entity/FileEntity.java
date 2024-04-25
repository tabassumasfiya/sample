package com.example.FileDemo.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.xml.crypto.Data;

@Entity
@Table(name = "images")
public class FileEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String fileName;
	private String fileType;
    @Lob
	private byte[] imageData;
	public FileEntity() {
		super();
	}
	public FileEntity(String fileName, String fileType, byte[] imageData) {
		super();
		this.id = id;
		this.fileName = fileName;
		this.fileType = fileType;
		this.imageData = imageData;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public byte[] getImageData() {
		return imageData;
	}
	public void setImageData(byte[] imageData) {
		this.imageData = imageData;
	}
	
}
