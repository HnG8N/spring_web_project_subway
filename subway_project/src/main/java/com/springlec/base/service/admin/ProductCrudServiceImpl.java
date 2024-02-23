package com.springlec.base.service.admin;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.springlec.base.dao.admin.AdminDao;

@Service
//Transaction을 해주기 위한 명령어 (class 내에서 에러가 걸리면 롤백함)
@Transactional(rollbackFor = Exception.class)
public class ProductCrudServiceImpl implements ProductCrudService{

	// Field
	String uniqueFileName = "";
	
	@Autowired
	AdminDao dao;
	
    @Value("${subwaymenu.upload.directory}")
    private String uploadDirectory;

    // image 파일 업로드
    public String uploadImage(MultipartFile file) throws IOException {
        uniqueFileName = generateUniqueFileName(file.getOriginalFilename());
        Path fileNameAndPath = Paths.get(uploadDirectory, uniqueFileName);
        Files.write(fileNameAndPath, file.getBytes());
        return uniqueFileName;
    }

    private String generateUniqueFileName(String originalFileName) {
        return UUID.randomUUID().toString() + "_" + originalFileName;
    }
	
    // DB에 product 정보를 insert
	@Override
	public void ProductInsertTask(MultipartFile file, String mnctg, String mnname, String mnengname, String mninfo,
			String mnprice, String mngram, String mnkcal, String mnprotein, String mnfat, String mnsugar,
			String mnnatrum) throws Exception {
		
		String mnimg = uploadImage(file);
		
		dao.insertMenuAction(mnctg, mnname, mnengname, mninfo, mnimg, mnprice);
		dao.insertMenuSpecAction(mngram, mnkcal, mnprotein, mnfat, mnsugar, mnnatrum);
		
	}

}
