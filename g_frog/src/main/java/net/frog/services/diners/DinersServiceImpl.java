package net.frog.services.diners;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import net.frog.dao.diners.DinersDAO;
import net.frog.vo.DinersVO;


@Service("dinersService")
public class DinersServiceImpl implements DinersService{


	@Resource(name="dinersDAO")
	private DinersDAO dinersDAO;	
	
	@Override
	public int count() throws Exception {
		return dinersDAO.count();
	}

	@Override
	public DinersVO dinersDetail(int no) throws Exception{		
		return dinersDAO.dinersSelect_diners(no);
	}

	@Override
	public String[] dinersPhtopathDetail(int no)throws Exception {
		return dinersDAO.dinersSelect_photopath(no);
	}

	@Override
	public List<DinersVO> selectList(int i, int j) throws Exception {
		return dinersDAO.selectList(i,j);
	}

	@Override
	public List<DinersVO> dinersSearch(String diner_name)throws Exception {
		return dinersDAO.searchList(diner_name);
	}
}
