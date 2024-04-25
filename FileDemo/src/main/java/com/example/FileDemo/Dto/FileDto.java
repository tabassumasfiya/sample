package com.example.FileDemo.Dto;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


public class FileDto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String fileName;
	private String fileType;
    private String downloadURL;
	public FileDto() {
		super();
	}
	public FileDto(Long id, String fileName, String fileType, String downloadURL) {
		super();
		this.id = id;
		this.fileName = fileName;
		this.fileType = fileType;
		this.downloadURL = downloadURL;
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
	public String getDownloadURL() {
		return downloadURL;
	}
	public void setDownloadURL(String downloadURL) {
		this.downloadURL = downloadURL;
	}
	
	}
