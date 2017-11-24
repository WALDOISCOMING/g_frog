package net.frog.services.admin;

import org.springframework.web.multipart.MultipartFile;

import net.frog.vo.DinersVO;
import net.frog.vo.MenuVO;

public interface AdminService {

	//int insert(DinersVO dinersVO)throws Exception;

	void insertFile(DinersVO dinersVO, MultipartFile[] photo_files)throws Exception;

	void deleteFile(int no)throws Exception;

	void update(int no,DinersVO dinersVO)throws Exception;

	void update(int no,DinersVO dinersVO ,MultipartFile[] photo_files)throws Exception;

	
}