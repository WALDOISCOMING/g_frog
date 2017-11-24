package net.frog.services.menu;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import net.frog.dao.admin.AdminDAO;
import net.frog.dao.diners.DinersDAO;
import net.frog.dao.menu.MenuDAO;
import net.frog.util.CommonUtil;
import net.frog.util.admin.FileAdminutil;
import net.frog.vo.DinersVO;
import net.frog.vo.MenuVO;
import net.frog.vo.ReplyVO;


@Service("menuService")
public class MenuServiceImpl implements MenuService{

	@Resource(name="fileAdminUtil")
	private FileAdminutil fileAdminUtil;
	
	@Resource(name="commonUtil")
	private CommonUtil commonUtil;//random and dir time 
	
	@Resource(name="menuDAO")
	private MenuDAO menuDAO;
	
	@Resource(name="dinersDAO")
	private DinersDAO dinersDAO;
	
	
	@Override
	public void menu_insert(MenuVO menuVO, MultipartFile photo) throws Exception {
		// TODO Auto-generated method stub
		//first input and then input the file...
		String menu_Name = commonUtil.str_Date()+commonUtil.str_Rnd()+menuVO.getMenu_name();

		String dir_Name = dinersDAO.dinersSelect_diners(menuVO.getDiners_no()).getDiner_directory_name();
		dir_Name="C:\\diners\\"+dir_Name+"\\event\\";
		dir_Name = dir_Name+menu_Name;
		dir_Name = fileAdminUtil.setMenuPhotoVO(dir_Name,photo);
		menuVO.setMenu_photo(dir_Name);
		 menuDAO.menuInsert(menuVO);
		
	}


	@Override
	public List<MenuVO> selectList(int diners_no) {
		return menuDAO.selectList(diners_no);
	}
	
	

	@Override
	public void deleteFile(int no) {
		// TODO Auto-generated method stub
		String dir_Name =menuDAO.selectOne(no).getMenu_photo();
		menuDAO.delete(no);
		fileAdminUtil.deleteFile(dir_Name);
		
	}

	@Override
	public void menu_update(MenuVO menuVO, MultipartFile menu_photo) {
		MenuVO AVO = new MenuVO();
		
		String menu_Name = commonUtil.str_Date()+commonUtil.str_Rnd()+menuVO.getMenu_name();

		AVO= menuDAO.selectOne(menuVO.getNo());

		String dir_Name = dinersDAO.dinersSelect_diners(AVO.getDiners_no()).getDiner_directory_name();	
				
		dir_Name="C:\\diners\\"+dir_Name+"\\event\\";
		dir_Name = dir_Name+menu_Name;
		dir_Name = fileAdminUtil.setMenuPhotoVO(dir_Name,menu_photo);
		menuVO.setMenu_photo(dir_Name);
		
		
		fileAdminUtil.deleteFile(AVO.getMenu_photo());
	
		 menuDAO.menuUpdate(menuVO);
		
	}
}
