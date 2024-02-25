package com.springlec.base.service.admin;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.springlec.base.dao.admin.AdminDao;
import com.springlec.base.model.admin.ProductCrudDto;

@Service
//Transaction을 적용하여 클래스 내에서 발생하는 예외가 발생할 경우 롤백 처리됩니다.
@Transactional(rollbackFor = Exception.class)
public class ProductCrudServiceImpl implements ProductCrudService {

 
 // AdminDao 빈을 주입받습니다.
 @Autowired
 AdminDao dao;

 //**************************** 이미지 업로드를 위한 method ****************************
 // 업로드된 이미지 파일의 고유 파일 이름을 저장하는 변수
 String uniqueFileName = "";
 // application.properties에서 설정한 파일 업로드 디렉토리 경로를 주입받습니다.
 @Value("${subwaymenu.upload.directory}")
 private String uploadDirectory;

 // 이미지 파일을 업로드하는 method
 public String uploadImage(MultipartFile file) throws IOException {
     // 파일의 고유한 이름 생성
     uniqueFileName = generateUniqueFileName(file.getOriginalFilename());
     // 파일 경로 생성
     Path fileNameAndPath = Paths.get(uploadDirectory, uniqueFileName);
     // 파일을 해당 경로에 저장
     Files.write(fileNameAndPath, file.getBytes());
     // 업로드된 파일의 고유한 이름을 반환
     return uniqueFileName;
 }

 // 고유한 파일 이름 생성 method
 private String generateUniqueFileName(String originalFileName) {
     // UUID와 원본 파일 이름을 조합하여 고유한 파일 이름 생성
     return UUID.randomUUID().toString() + "_" + originalFileName;
 }
 //************************************************************************************
 
 
 //*************************** ProductInsert Task ***************************
 // 제품 정보를 데이터베이스에 삽입하는 method
 @Override
 public void ProductInsertTask(MultipartFile file, String mnctg, String mnname, 
		 String mnengname, String mninfo, String mnprice, 
		 String mngram, String mnkcal, String mnprotein, 
		 String mnfat, String mnsugar, String mnnatrum) throws Exception {
     
     // 이미지 파일을 업로드하고 고유한 파일 이름을 반환받습니다.
     String mnimg = uploadImage(file);
     
     // 제품 정보를 삽입하기 위해 DAO에 작업을 위임합니다.
     dao.insertMenuAction(mnctg, mnname, mnengname, mninfo, mnimg, mnprice);
     dao.insertMenuSpecAction(mngram, mnkcal, mnprotein, mnfat, mnsugar, mnnatrum);
 }
//*************************** ProductInsert Task End ***************************

 
//*************************** ProductListCountTask Task ***************************

 @Override
 public int ProductListCountTask() throws Exception {
	 return dao.productListCount();
 }
//*************************** ProductListCountTask Task End ***************************

 
//*************************** productListSelectTask Task ***************************
@Override
public List<ProductCrudDto> productListSelectTask(int limit, int offset) throws Exception {
	return dao.productListSelect(limit, offset);
}
//*************************** productListSelectTask Task End ***************************


//*************************** productListSearchTask Task ***************************
@Override
public List<ProductCrudDto> productListSearchTask(
		String selectSearch, String search) throws Exception {
	return dao.productListSearch(selectSearch, '%'+search+'%');
}
//*************************** productListSearchTask Task End ***************************


//*************************** productDetailTask Task ***************************
@Override
public ProductCrudDto productDetailTask(int mncode) throws Exception {
	return dao.productDetail(mncode);
}
//*************************** productDetailTask Task End***************************


//*************************** productUpdateTask Task ***************************
@Override
public void ProductUpdateTask(MultipartFile file, int mncode, String mnctg, 
		String mnname, String mnengname, String mninfo,
		String mnprice, String mngram, String mnkcal, 
		String mnprotein, String mnfat, String mnsugar, String mnnatrum)
		throws Exception {
	// MultipartFile의 이미지파일은 선택되지 않아도 빈 값일 뿐 null은 아님
//    System.out.println(file.isEmpty()); <- true
//    System.out.println(file==null); <- false
    if(!file.isEmpty()) {	// 이미지 파일이 존재한다면 if문을 실행
    	// 이미지 파일을 업로드하고 고유한 파일 이름을 반환받습니다.
    	String mnimg = uploadImage(file);
    	// img 정보를 수정하기 위해 DAO에 작업을 위임합니다.
    	dao.updateImgAction(mncode, mnimg);
    }
    
    // 제품 정보를 수정하기 위해 DAO에 작업을 위임합니다.
    dao.updateMenuAction(mncode, mnctg, mnname, mnengname, mninfo, mnprice);
    dao.updateMenuSpecAction(mncode, mngram, mnkcal, 
    		mnprotein, mnfat, mnsugar, mnnatrum);
}
//*************************** productUpdateTask Task End ***************************

}
