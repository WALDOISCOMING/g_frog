package net.frog.controller;



import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import net.frog.services.admin.AdminService;
import net.frog.services.menu.MenuService;
import net.frog.vo.DinersVO;
import net.frog.vo.MenuVO;
import net.frog.vo.diners.photo.DinersPhotoVO;

@Controller
public class AdminController {
	@Resource(name = "adminService")
	private AdminService adminService;
	
	@Resource(name = "menuService")
	private MenuService menuService;
	
	//BF input
	@RequestMapping("/admin/add_diners.do")
	public String adddiners()throws Exception{
		return "/admin/addDiners";
	}
	//input times
	@RequestMapping(value="/admin/add_diners.do",method=RequestMethod.POST)
	public String adddiners(WebRequest request,
				@RequestParam(value="diner_name",required=true)String diner_name,
				@RequestParam(value="diner_call")String diner_call,
				@RequestParam(value="intro")String intro,
				@RequestParam(value="rest_day")String rest_day,
				@RequestParam(value="photo_main")MultipartFile photo_main,
				@RequestParam(value="photo_sub_1")MultipartFile photo_sub_1,
				@RequestParam(value="photo_sub_2")MultipartFile photo_sub_2,
				@RequestParam(value="photo_sub_3")MultipartFile photo_sub_3
			)throws Exception{
		//input String \n to <br>
			MultipartFile photo_files[] ={photo_main,photo_sub_1,photo_sub_2,photo_sub_3};
			intro = intro.replaceAll("\n","<br>");
			DinersVO dinersVO = new DinersVO();
			dinersVO.setName(diner_name);
			dinersVO.setCall_number(diner_call);
			dinersVO.setIntro(intro);
			dinersVO.setRest_day(rest_day);
			adminService.insertFile(dinersVO,photo_files);			
			return "/admin/addDiners";
	}
	
	
	@RequestMapping(value="/admin/delete_diners.do",method=RequestMethod.GET)
	public String deletediners(
			@RequestParam(value="no",required=true)int no
			) throws Exception{
		
		adminService.deleteFile(no);
		
		return "";
	}
	
	@RequestMapping(value="/admin/edit_diners.do",method=RequestMethod.GET)
	public ModelAndView editdiners(
			@RequestParam(value="no",required=true)int no
			)throws Exception{
		ModelAndView modelAndView =  new ModelAndView();
		modelAndView.addObject("no",no);
		modelAndView.setViewName("/admin/editDiners");
		return modelAndView;
	}
	
	@RequestMapping(value="/admin/edit_diners.do",method=RequestMethod.POST)
	public String editdiners(WebRequest request,
			@RequestParam(value="no",required=true)int no,
			@RequestParam(value="diner_name",required=true)String diner_name,
			@RequestParam(value="diner_call")String diner_call,
			@RequestParam(value="intro")String intro,
			@RequestParam(value="rest_day")String rest_day,
			@RequestParam(value="photo_main")MultipartFile photo_main,
			@RequestParam(value="photo_sub_1")MultipartFile photo_sub_1,
			@RequestParam(value="photo_sub_2")MultipartFile photo_sub_2,
			@RequestParam(value="photo_sub_3")MultipartFile photo_sub_3
						)throws Exception{
		
		DinersVO dinersVO = new DinersVO();
		dinersVO.setNo(no);
		dinersVO.setName(diner_name);
		dinersVO.setCall_number(diner_call);
		dinersVO.setIntro(intro);
		dinersVO.setRest_day(rest_day);
		
		if(photo_main.isEmpty()&&photo_sub_1.isEmpty()&&photo_sub_2.isEmpty()&&photo_sub_3.isEmpty()){
			adminService.update(no,dinersVO);
			System.out.println("not photo");
			
			return "";
		}
		
		MultipartFile photo_files[] ={photo_main,photo_sub_1,photo_sub_2,photo_sub_3};
		
		adminService.update(no,dinersVO,photo_files);
		
		return "";
	}
	
	@RequestMapping(value="/admin/add_Menu.do",method=RequestMethod.GET)
	public ModelAndView insertmenu(
			@RequestParam(value="no",required=true)int no
			)throws Exception{
		ModelAndView modelAndView =  new ModelAndView();
		modelAndView.addObject("no",no);
		modelAndView.setViewName("/admin/addMenu");
		return modelAndView;
	}
	
	@RequestMapping(value="/admin/add_Menu.do",method=RequestMethod.POST)
	public ModelAndView insertmenu(WebRequest request,
			@RequestParam(value="no",required=true)int no,
			@RequestParam(value="menu_name",required=true)String menu_name,
			@RequestParam(value="menu_main",required=true)String menu_main,
			@RequestParam(value="menu_original_price",required=true)String menu_original_price,
			@RequestParam(value="menu_sale",required=true)String menu_sale,
			@RequestParam(value="menu_start_date",required=true)String menu_start_date,
			@RequestParam(value="menu_end_date",required=true)String menu_end_date,
			@RequestParam(value="menu_photo")MultipartFile menu_photo
			)throws Exception{
		SimpleDateFormat transFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		Date s_date =transFormat.parse(menu_start_date);
		Date e_date =transFormat.parse(menu_end_date);
		
	MenuVO menuVO = new MenuVO();
	menuVO.setDiners_no(no);
	menuVO.setMenu_name(menu_name);
	menuVO.setMenu_main(menu_main);
	menuVO.setMenu_original_price(Integer.parseInt(menu_original_price));
	menuVO.setMenu_sale(Integer.parseInt(menu_sale));
	menuVO.setMenu_start_date(s_date);
	menuVO.setMenu_end_date(e_date);
	menuService.menu_insert(menuVO,menu_photo);
		ModelAndView modelAndView =  new ModelAndView();
		modelAndView.addObject("no",no);
		modelAndView.setViewName("/admin/addMenu");
		return modelAndView;
	}
		
	
	
	@RequestMapping(value="/admin/delete_Menu.do",method=RequestMethod.GET)
	public String deletemenu(
			@RequestParam(value="no",required=true)int no
			) throws Exception{		
		menuService.deleteFile(no);	
		return "";
	}
	
	@RequestMapping(value="/admin/edit_Menu.do",method=RequestMethod.GET)
	public ModelAndView editmenu(
			@RequestParam(value="no",required=true)int no
			) throws Exception{		
		ModelAndView modelAndView =  new ModelAndView();
		modelAndView.addObject("no",no);
		modelAndView.setViewName("/admin/editMenu");
		return modelAndView;
	}
	
	@RequestMapping(value="/admin/edit_Menu.do",method=RequestMethod.POST)
	public ModelAndView editmenu(WebRequest request,
			@RequestParam(value="no",required=true)int no,
			@RequestParam(value="menu_name",required=true)String menu_name,
			@RequestParam(value="menu_main",required=true)String menu_main,
			@RequestParam(value="menu_original_price",required=true)String menu_original_price,
			@RequestParam(value="menu_sale",required=true)String menu_sale,
			@RequestParam(value="menu_start_date",required=true)String menu_start_date,
			@RequestParam(value="menu_end_date",required=true)String menu_end_date,
			@RequestParam(value="menu_photo")MultipartFile menu_photo
			
			) throws Exception{	
		SimpleDateFormat transFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		Date s_date =transFormat.parse(menu_start_date);
		Date e_date =transFormat.parse(menu_end_date);
		MenuVO menuVO = new MenuVO();
		menuVO.setNo(no);
		menuVO.setMenu_name(menu_name);
		menuVO.setMenu_main(menu_main);
		menuVO.setMenu_original_price(Integer.parseInt(menu_original_price));
		menuVO.setMenu_sale(Integer.parseInt(menu_sale));
		menuVO.setMenu_start_date(s_date);
		menuVO.setMenu_end_date(e_date);
		menuService.menu_update(menuVO,menu_photo);
		ModelAndView modelAndView =  new ModelAndView();
		modelAndView.addObject("no",no);
		modelAndView.setViewName("/admin/editMenu");
		return modelAndView;
	}
	
}

