package com.example.FileDemo.Service;


import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.FileDemo.Entity.FileEntity;
@Service
public interface FileService {

	FileEntity uploadFile(MultipartFile file) throws Exception ;

	byte[] showFile(Long id) throws Exception ;

	FileEntity updateFile(Long id, MultipartFile file) throws Exception ;

	void delete(Long id);


	
	
}
