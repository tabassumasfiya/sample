package com.example.FileDemo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.FileDemo.Entity.FileEntity;

@Repository
public interface FileRepo  extends JpaRepository<FileEntity, Long>{



}
