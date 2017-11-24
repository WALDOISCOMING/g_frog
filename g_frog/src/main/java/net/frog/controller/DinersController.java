package net.frog.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import net.frog.services.diners.DinersService;
import net.frog.services.menu.MenuService;
import net.frog.services.reply.ReplyService;
import net.frog.vo.DinersVO;
import net.frog.vo.MenuVO;
import net.frog.vo.ReplyVO;
import net.frog.vo.diners.photo.DinersPhotopathVO;
import sun.java2d.pipe.AAShapePipe;

@Controller
public class DinersController {
	
	@Resource(name = "dinersService")
	private DinersService dinersService;
			

	@Resource(name = "replyService")
	private ReplyService replyService;
	
	@Resource(name="menuService")
	private MenuService menuService;
	
	//push the list 
	@RequestMapping(value="/diners/dinersList.do")
	public ModelAndView dinersList()throws Exception{
		ModelAndView modelAndView = new ModelAndView();
		List<DinersVO> posts = null;
		try{
			posts =dinersService.selectList(0,100);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		modelAndView.addObject("posts",posts);
		modelAndView.setViewName("/diners/dinersList");
		return modelAndView;
	}


	
	@RequestMapping(value="/diners/dinersDetail.do",method=RequestMethod.GET)
	public ModelAndView dinersDetail(
			@RequestParam(value="diners_no")int diners_no
			)throws Exception{
	
		ModelAndView modelAndView =  new ModelAndView();
		DinersVO dinersVO = new DinersVO();

		dinersVO =  dinersService.dinersDetail(diners_no);
		 
		String[] dinersPhotopath  = dinersService.dinersPhtopathDetail(diners_no);
		
		if(dinersVO!=null){
		modelAndView.addObject("dinersVO_no",dinersVO.getNo());
		modelAndView.addObject("dinersVO_name",dinersVO.getName());
		modelAndView.addObject("dinersVO_intro",dinersVO.getIntro());
		}
		modelAndView.addObject("dinersPhotopath",dinersPhotopath);
		
		//menu
		List<MenuVO> menuVO = menuService.selectList(diners_no);
		modelAndView.addObject("menulists", menuVO);
		
		//reply
		List<ReplyVO> replyVO = replyService.selectList(diners_no);		
		float grade = replyService.getGrade(diners_no);		
		modelAndView.addObject("lists", replyVO);
		modelAndView.addObject("grade", grade);
		//reply
		
		modelAndView.setViewName("/diners/dinersDetail");
		return modelAndView;
	}
	
	//검색 이것의 return 값이 위의 list를 대신 해 줘야한다.
	//검색 기능이 있다면 전처럼의 list는 필요가 없어진다.3
	

	@RequestMapping(value="/diners/search.do",method=RequestMethod.GET)
		public ModelAndView dinersSearch(
		@RequestParam(value="diner_name")String diner_name
										)throws Exception{

		ModelAndView modelAndView =  new ModelAndView();

		List<DinersVO> posts =  dinersService.dinersSearch(diner_name);
		if(posts!=null){
		modelAndView.addObject("diners",posts);
		}

		modelAndView.addObject("posts",posts);
		modelAndView.setViewName("/diners/dinersList");
		return modelAndView;
}
	
}
	
