package com.koreait.sevenfactory.command.member;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.koreait.sevenfactory.command.Command;
import com.koreait.sevenfactory.dao.SevenFactoryDAO;

public class AdminUserChangeCommand implements Command {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String mId = request.getParameter("mId");
		
		SevenFactoryDAO sDAO = sqlSession.getMapper(SevenFactoryDAO.class);
		
		sDAO.changeUser(mId); // 일반회원으로 권한 부여하기
		
		
	}

}
