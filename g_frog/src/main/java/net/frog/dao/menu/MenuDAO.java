package net.frog.dao.menu;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.frog.vo.DinersVO;
import net.frog.vo.MenuVO;
import net.frog.vo.ReplyVO;
import net.frog.vo.diners.photo.DinersPhotoVO;
import net.frog.vo.diners.photo.DinersPhotopathVO;


@Repository("menuDAO")
public class MenuDAO {

	SqlSessionFactory sqlSessionFactory;	
	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory){
		this.sqlSessionFactory = sqlSessionFactory;
	}	
	
	

	public void menuInsert(MenuVO menuVO) {
		SqlSession sqlSession = sqlSessionFactory.openSession();	
		try{
				sqlSession.insert("net.frog.dao.menu.MenuDao.insert_menuVO",menuVO);
		}finally{
			sqlSession.close();
		}
	}


	public List<MenuVO> selectList(int diners_no) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try{
			return sqlSession.selectList("net.frog.dao.menu.MenuDao.selectList",diners_no);
		}finally{
			sqlSession.close();
		}
	}



	public MenuVO selectOne(int diners_no) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try{

			return sqlSession.selectOne("net.frog.dao.menu.MenuDao.selectOne",diners_no);
		}finally{
			sqlSession.close();
		}
	}



	public void delete(int diners_no) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try{
			 sqlSession.delete("net.frog.dao.menu.MenuDao.delete",diners_no);
		}finally{
			sqlSession.close();
		}
	}



	public void menuUpdate(MenuVO menuVO) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try{
			 sqlSession.delete("net.frog.dao.menu.MenuDao.update",menuVO);
		}finally{
			sqlSession.close();
		}
	}
}

