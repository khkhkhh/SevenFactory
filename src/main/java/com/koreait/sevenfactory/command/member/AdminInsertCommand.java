package com.koreait.sevenfactory.command.member;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.koreait.sevenfactory.command.Command;
import com.koreait.sevenfactory.dao.SevenFactoryDAO;
import com.koreait.sevenfactory.dto.MemberDTO;

public class AdminInsertCommand implements Command {

	@Override	
	public void execute(SqlSession sqlSession, Model model) {

		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
	
		  MemberDTO mDTO = new MemberDTO();
		 
		mDTO.setmId(request.getParameter("mId"));
		mDTO.setmPw(request.getParameter("mPw"));
		mDTO.setmName(request.getParameter("mName"));
		mDTO.setmEmail(request.getParameter("mEmail"));
		mDTO.setmPhone(request.getParameter("mPhone"));
		mDTO.setmZipcode(Integer.parseInt(request.getParameter("mZipcode")));
		mDTO.setmAddr1(request.getParameter("mAddr1"));
		mDTO.setmAddr2(request.getParameter("mAddr2"));
		
		SevenFactoryDAO sDAO = sqlSession.getMapper(SevenFactoryDAO.class);
		sDAO.userInsert(mDTO);
		
	}

}
