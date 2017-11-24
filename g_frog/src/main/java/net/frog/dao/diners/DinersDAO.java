package net.frog.dao.diners;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.frog.vo.DinersVO;
import net.frog.vo.diners.photo.DinersPhotoVO;

@Repository("dinersDAO")
public class DinersDAO {
	
	SqlSessionFactory sqlSessionFactory;	
	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory){
		this.sqlSessionFactory = sqlSessionFactory;
	}
	
	
	
	public int count() {
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		try{
			return sqlSession.selectOne("net.frog.dao.diners.DinersDao.count");
		}finally{
			sqlSession.close();
		}
	}



	public DinersVO dinersSelect_diners(int no) {
		SqlSession sqlSession = sqlSessionFactory.openSession();	
		try{	
			return sqlSession.selectOne("net.frog.dao.diners.DinersDao.select_diners",no);
		}
		finally{
			sqlSession.close();
		}		
	}


	
	public String[] dinersSelect_photopath(int no) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		String DinersPhotopath[] = new String[4];
		try{
			DinersPhotoVO dinersPhotoVO = new DinersPhotoVO();
			for(int i=0;i<4;i++){	
				//DinersPhotopathVO input = new DinersPhotopathVO();
				dinersPhotoVO.setDiners_no(no);
				dinersPhotoVO.setDiners_photo_value(i);
				DinersPhotopath[i]= sqlSession.selectOne("net.frog.dao.diners.DinersDao.select_diners_photopath",dinersPhotoVO);
			}
			return DinersPhotopath;
		}
		finally{
			sqlSession.close();
		}
	}



	public List<DinersVO> selectList(int i, int j) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		RowBounds rowBounds = new RowBounds(i,j);
		try{
			return sqlSession.selectList("net.frog.dao.diners.DinersDao.selectList", rowBounds);
		}finally{
			sqlSession.close();
		}
	}



	public List<DinersVO> searchList(String diner_name) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try{
			return sqlSession.selectList("net.frog.dao.diners.DinersDao.searchList",diner_name);
		}finally{
			sqlSession.close();
		}
	}
}
