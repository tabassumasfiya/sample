package com.example.FileDemo.Controller;



import java.awt.Image;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.http.HttpHeaders;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

import javax.swing.filechooser.FileNameExtensionFilter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.ConditionalOnDefaultWebSecurity;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import com.example.FileDemo.Entity.FileEntity;
import com.example.FileDemo.Repo.FileRepo;
import com.example.FileDemo.Service.FileService;


@RestController
@RequestMapping("/file")
public class FileController {
	@Autowired
	private FileService fileService;
	
	@PostMapping("/upload")
	public ResponseEntity<FileEntity> uploadaFile(@RequestParam("file")MultipartFile file)throws Exception{
		try {
			FileEntity uploadFile = this.fileService.uploadFile(file);
			return ResponseEntity.ok(uploadFile);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/show/{id}")
	public ResponseEntity<byte[]> showFile(@PathVariable Long id) throws Exception {
		try {
			byte[] imageData = fileService.showFile(id);
			return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(imageData);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}	
	
	@PutMapping("/update/{id}")
	public ResponseEntity<FileEntity> updateFile(@PathVariable Long id,@RequestParam("file")MultipartFile file) throws Exception {
		try {
			FileEntity updateFile= this.fileService.updateFile(id,file);
			return  ResponseEntity.ok(updateFile);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable Long id) {
	    fileService.delete(id);
		return "Id deleted Successfully";
	}
}



	

