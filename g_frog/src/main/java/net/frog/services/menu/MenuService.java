package net.frog.services.menu;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import net.frog.vo.MenuVO;

public interface MenuService {

	void menu_insert(MenuVO menuVO,MultipartFile menu_photo)throws Exception;

	List<MenuVO> selectList(int diners_no);

	void deleteFile(int no);

	void menu_update(MenuVO menuVO, MultipartFile menu_photo);
}