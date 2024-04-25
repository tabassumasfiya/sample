package com.example.FileDemo.ServiceImpl;

import java.awt.Image;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

import javax.annotation.processing.Filer;
import javax.persistence.Entity;
import javax.xml.crypto.Data;

import org.apache.tomcat.jni.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.ConditionalOnDefaultWebSecurity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.FileDemo.Dto.FileDto;
import com.example.FileDemo.Entity.FileEntity;
import com.example.FileDemo.Repo.FileRepo;
import com.example.FileDemo.Service.FileService;
@Service
public class FileServiceImpl implements FileService {

	@Autowired
	private FileRepo fileRepo;

	private final String Folder_Path = "C:\\Users\\Sunplus\\Desktop\\MyImages\\";
	
	@Override
	public FileEntity uploadFile(MultipartFile file) throws Exception {
		String fileName =Folder_Path+ file.getOriginalFilename();
		try {
			if(fileName.contains("..")) {
				throw new Exception("Invalid name"+fileName);
			}
			FileEntity fileEntity = new FileEntity(fileName, file.getContentType(), file.getBytes());
			file.transferTo(new java.io.File(fileName));
			return fileRepo.save(fileEntity);
			
		} catch (Exception e) {
			throw new Exception("Could not save file"+fileName);
		}
	}	
	@Override
	public byte[] showFile(Long id) throws Exception {
		 Optional<FileEntity> optionalFileEntity = fileRepo.findById(id);
	        if (optionalFileEntity.isPresent()) {
	            return optionalFileEntity.get().getImageData();
	        } else {
	            throw new Exception("FileEntity with id " + id + " not found");
	        }
	    }	
	@Override
	public FileEntity updateFile(Long id, MultipartFile file) throws Exception {
		Optional<FileEntity> optionalFileEntity = fileRepo.findById(id);
        if (optionalFileEntity.isPresent()) {
            FileEntity fileEntity = optionalFileEntity.get();
            try {
                fileEntity.setFileName(file.getOriginalFilename());
                fileEntity.setFileType(file.getContentType());
                fileEntity.setImageData(file.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
                // Handle IOException
            }
            FileEntity savedEntity = fileRepo.save(fileEntity);
            return savedEntity;
        } else {
            throw new Exception("FileEntity with id " + id + " not found");
        }
    }
	@Override
	public void delete(Long id) {
		this.fileRepo.deleteById(id);
		
	}
}