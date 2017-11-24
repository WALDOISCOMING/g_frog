package net.frog.services.diners;

import java.util.List;

import net.frog.vo.DinersVO;

public interface DinersService {

	public int count()throws Exception;

	public DinersVO dinersDetail(int no)throws Exception;

	public String[] dinersPhtopathDetail(int no)throws Exception;

	public List<DinersVO> selectList(int i, int j)throws Exception;

	public List<DinersVO> dinersSearch(String diner_name)throws Exception;
	
}