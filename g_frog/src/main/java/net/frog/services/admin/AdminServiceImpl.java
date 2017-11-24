package net.frog.services.admin;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import net.frog.dao.admin.AdminDAO;
import net.frog.dao.diners.DinersDAO;
import net.frog.services.diners.DinersService;
import net.frog.util.CommonUtil;
import net.frog.util.FileUtil;
import net.frog.util.admin.FileAdminutil;
import net.frog.vo.DinersVO;
import net.frog.vo.MenuVO;
import net.frog.vo.diners.photo.DinersPhotoVO;
import net.frog.vo.diners.photo.DinersPhotopathVO;

@Service("adminService")
public class AdminServiceImpl implements AdminService{
	

	@Resource(name="fileAdminUtil")
	private FileAdminutil fileAdminUtil;
	
	@Resource(name="commonUtil")
	private CommonUtil commonUtil;//random and dir time 
	
	@Resource(name="adminDAO")
	private AdminDAO adminDAO;
	
	@Resource(name="dinersDAO")
	private DinersDAO dinersDAO;
	
	/*
	@Override
	public int insert(DinersVO dinersVO) throws Exception {
		return adminDAO.dinersinsert(dinersVO);		
	}*/
	
	@Override
	public void insertFile(DinersVO dinersVO, MultipartFile[] photo_files) {

		String dir_Name = dinersVO.getName()+commonUtil.str_Date()+commonUtil.str_Rnd();

		dinersVO.setDiner_directory_name(dir_Name);

		dir_Name = fileAdminUtil.setDirectory(dir_Name);

		DinersPhotoVO[] dinersPhotoVO = new DinersPhotoVO[4];
		DinersPhotopathVO[] dinersPhotopathVO = new DinersPhotopathVO[4];
		for(int i=0;i<4;i++){
			dinersPhotoVO[i] =  fileAdminUtil.setDinersPhotoVO(photo_files[i],i, dir_Name);
			dinersPhotopathVO[i] = fileAdminUtil.setDinersPhotopathVO(dir_Name+"\\diners\\"+dinersPhotoVO[i].getStored_file_name());		
		}		
		adminDAO.dinersInsert(dinersVO,dinersPhotoVO,dinersPhotopathVO);
	}
	
	@Override
	public void deleteFile(int no)throws Exception{
		String dir_Name = "C:\\diners\\"+adminDAO.delete(no);
		fileAdminUtil.deleteAllFile(dir_Name);		
	}

	@Override
	public void update(int no,DinersVO dinersVO) throws Exception {
		 adminDAO.update(dinersVO);			
	}

	@Override
	public void update(int no,DinersVO dinersVO,MultipartFile[] photo_files) throws Exception {
		adminDAO.update(dinersVO);	
		String dir_Name = dinersDAO.dinersSelect_diners(no).getDiner_directory_name();
		dir_Name = "C:\\diners\\"+dir_Name;
		
		fileAdminUtil.deleteDinersFile(dir_Name);
		
		for(int i=0;i<4;i++){
			fileAdminUtil.setDinersPhotoVO(photo_files[i],i, dir_Name);		
		}	
	}



}

