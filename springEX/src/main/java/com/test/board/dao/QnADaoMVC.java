package com.test.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.test.board.dto.AnswerDto;
import com.test.board.dto.Employee;
import com.test.board.dto.QnADto;
import com.test.board.util.Constant;

public class QnADaoMVC {
	
	DataSource dataSource;
	JdbcTemplate template = null;
	
	public QnADaoMVC(){
		try {
			Context context = new InitialContext();
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/Mysql");
		} catch(NamingException e) {
			e.printStackTrace();
		}
		
		template = Constant.template;
		
	}
	
	public ArrayList<QnADto> qnaList(){
		
//		String sql = "select q.qCode, qName, qEmail, qPhone, p.pdCode, p.pdName, qContents, q.qRegistTime, s.stCode, s.stName, a.aAnswer, ad.emName, ad.emCode \n" + 
//						"from question q , product p, state s, answer a, signUpAdmin ad\n" + 
//						"where q.qCode = a.qCode and ad.emCode = a.emCode and q.pdCode = p.pdCode and q.stCode = s.stCode"; 	
//		String sql = "select q.qCode, qName, qEmail, qPhone, p.pdCode, p.pdName, qContents, q.qRegistTime, s.stCode, s.stName, a.aAnswer, ad.emName, ad.emCode \n" + 
//				+ "from question q left join answer a on q.qCode = a.qCode join product p on q.pdCode = p.pdCode join state s on q.stCode = s.stCode left join signUpAdmin ad on a.emCode = ad.emCode";   
		String sql = "select q.qCode, qName, qEmail, qPhone, p.pdCode, p.pdName, qContents, q.qRegistTime, a.aAnswer, s.stCode, s.stName\n" + 
				"from question q\n" + 
				"left join \n" + 
				"		answer a\n" + 
				"using (qCode)\n" + 
				"\n" + 
				"join \n" + 
				"	product p\n" + 
				"on q.pdCode = p.pdCode\n" + 
				"join \n" + 
				"	state s\n" + 
				"on q.stCode = s.stCode\n" + 
				"\n" + 
				"order by qRegistTime desc";
		return (ArrayList<QnADto>) template.query(sql, new BeanPropertyRowMapper<QnADto>(QnADto.class));
		
		//////////////////JSP MVC2の時
		
//		ArrayList<QnADto> dtos = new ArrayList<QnADto>();
//		Connection connection = null;
//		PreparedStatement preparedStatement = null;
//		ResultSet resultSet = null;
//		
//		
//		try {
//			connection = dataSource.getConnection();
//			String sql = "select * from qnaQuestion";
//			preparedStatement = connection.prepareStatement(sql);
//			resultSet = preparedStatement.executeQuery();
//			
//			while(resultSet.next()) {
//				int qCode = resultSet.getInt("qnaCode");
//				String qName = resultSet.getString("qnaName");
//				String qEmail = resultSet.getString("qnaEmail");
//				String qPhone = resultSet.getString("qnaPhone");
//				String pdCode = resultSet.getString("pdCode");
//				String qContents = resultSet.getString("qnaContents");
//				String qRegistTime = resultSet.getString("qnaRegistTime");
//				int stCode = resultSet.getInt("stCode");
//				String pdName = resultSet.getString("pdName");
//				String stName = resultSet.getString("stName");
//				
//				
//				QnADto dto = new QnADto(qCode, qName, qEmail, qPhone, pdCode, qContents, qRegistTime, stCode, pdName, stName); 
//				dtos.add(dto);
//			}
//			
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			
//				try {
//					if(resultSet != null)resultSet.close();
//					if(preparedStatement != null)connection.close();
//					if(connection != null)connection.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//		}
//		return dtos;
	}
	
	public List<QnADto> qnaResponding(int stCode, int emCode) {
		Object[] params = {stCode, emCode};
		String sql = "select qCode, qName, qEmail, qPhone, p.pdCode, p.pdName, qContents, qRegistTime,  s.stCode, s.stName\n" + 
				"from question q , product p, state s where q.pdCode = p.pdCode and q.stCode = s.stCode and q.stCode = ? and emCode = ?"; 
		return   template.query(sql, params, new BeanPropertyRowMapper<QnADto>(QnADto.class));
				
		
	}
	
	public QnADto contentsView(String qCode) {
	
//		String sql = "select * from question where qCode = ?";
//		return template.queryForObject(sql, new BeanPropertyRowMapper<QnADto>(QnADto.class));
//		
		QnADto dto = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			
			String sql = "select qContents from question where qCode = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1,  Integer.parseInt(qCode));
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
//				int qnaCode = resultSet.getInt("qCode");
//				String qName = resultSet.getString("qName");
//				String qEmail = resultSet.getString("qEmail");
//				String qPhone = resultSet.getString("qPhone");
//				int pdCode = resultSet.getInt("pdCode");
				String qContents = resultSet.getString("qContents");
//				String qRegistTime = resultSet.getString("qRegistTime");
//				int stCode = resultSet.getInt("stCode");
				
				dto = new QnADto(qContents);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(resultSet != null)resultSet.close();
				if(preparedStatement != null)connection.close();
				if(connection != null)connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return dto;
	}
	
	public void regist(String qName, String qEmail, String qPhone, String pdCode, String qContents) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		System.out.println("前"+pdCode);
		
		try {
			
			connection = dataSource.getConnection();
			String sql = "insert into question(qName, qEmail, qPhone, pdCode, qContents) values(?, ?, ?, ?, ?)";
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1,  qName);
			preparedStatement.setString(2,  qEmail);
			preparedStatement.setString(3,  qPhone);
			preparedStatement.setInt(4,  Integer.parseInt(pdCode));
			preparedStatement.setString(5,  qContents);
			System.out.println(preparedStatement);
			System.out.println("後"+pdCode);
			System.out.println(qEmail);
			System.out.println(qPhone);
			System.out.println(qContents);
			preparedStatement.executeUpdate();
			
			System.out.println("111");
			
		} catch (Exception e) {
				System.out.println();
		} finally {
			try {
				if(resultSet != null)resultSet.close();
				if(preparedStatement != null)connection.close();
				if(connection != null)connection.close();
			} catch (Exception e2) {

			}
		}
		
	}
	
	public void reply(String reply, String qCode, int emCode) {	
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = dataSource.getConnection();
			String sql = "insert into answer(aAnswer, qCode, emCode) values(?, ?, ?)";
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1, reply);
			preparedStatement.setInt(2, Integer.parseInt(qCode));
			preparedStatement.setInt(3, emCode);
			System.out.println(qCode);
			System.out.println(emCode);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(resultSet != null)resultSet.close();
				if(preparedStatement != null)connection.close();
				if(connection != null)connection.close();
			} catch (Exception e2) {

			}
		}
	}
	
	public AnswerDto replyView(String qCode) {
		
		AnswerDto dto2 = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		PreparedStatement preparedStatement2 = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			String sql = "select * from answer where qCode = ?";
			String query = "update question set aCode = ? where qCode = ?";
			
			
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1,  Integer.parseInt(qCode));
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				String aAnswer = resultSet.getString("aAnswer");
				int qnaCode = resultSet.getInt("qCode");
				String qRegistTime = resultSet.getString("qRegistTime");
				int emCode = resultSet.getInt("emCode");
				
				dto2 = new AnswerDto(aAnswer, qnaCode, qRegistTime, emCode);
				
				preparedStatement2 = connection.prepareStatement(query);
				int aCode = resultSet.getInt("aCode");
				preparedStatement2.setInt(1, aCode);
				preparedStatement2.setInt(2, qnaCode);
				preparedStatement2.executeUpdate();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(resultSet != null)resultSet.close();
				if(preparedStatement != null)connection.close();
				if(connection != null)connection.close();
			} catch (Exception e2) {

			}
		}
		
		
		return dto2;
		
	}
	
	public void signUp(String emName, String emPw, String emNum) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
			try {
				connection = dataSource.getConnection();
				String sql = "insert into signUpAdmin(emName, emPw, emNum) values(?, ?, ?)";
				preparedStatement = connection.prepareStatement(sql);
				
				preparedStatement.setString(1, emName);
				preparedStatement.setString(2, emPw);
				preparedStatement.setString(3, emNum);
				
				preparedStatement.executeUpdate();
				System.out.println("dao" + preparedStatement);
				System.out.println("dao" +  emPw);
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if(resultSet != null)resultSet.close();
					if(preparedStatement != null)connection.close();
					if(connection != null)connection.close();
				} catch (Exception e2) {

				}
			}
	}
	
	public Employee login(String emNumber, String password) {
		
		Employee employee = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			String sql = "select * from signUpAdmin where emNum = ?";
			preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1,  emNumber);
		//preparedStatement.setString(2,  emPw);
		resultSet = preparedStatement.executeQuery();
		
		
		if(resultSet.next()) {
			System.out.println(resultSet.getString("emName"));
			System.out.println(resultSet.getString("emPw"));
			System.out.println(resultSet.getString("emNum"));
			
			int emCode = resultSet.getInt("emCode");
			String emName = resultSet.getString("emName");
			String emPw = resultSet.getString("emPw");
			String emNum = resultSet.getString("emNum");
			

			
			if(emPw.equals(password)) {
				employee = new Employee(emCode, emName, emPw, emNum);
				return employee;
			} 
			return employee;
		}
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(resultSet != null)resultSet.close();
				if(preparedStatement != null)connection.close();
				if(connection != null)connection.close();
			} catch (Exception e2) {
			}
		}	
		return employee;	
	}
	
	public void updateState(int stCode, int emCode, int qCode) {
		System.out.println("dao" + stCode);
		System.out.println("dao" + qCode);
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			String sql = "update question set stCode = ?, emCode = ? where qCode = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, stCode);
			preparedStatement.setInt(2, emCode);
			preparedStatement.setInt(3, qCode);
			System.out.println("emCode : " + emCode);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(resultSet != null)resultSet.close();
				if(preparedStatement != null)connection.close();
				if(connection != null)connection.close();
			} catch (Exception e2) {
			}
		}
		
		
	}
	
	public void changePw(String emNewPw, String emName, String emNum) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			String sql = "update signUpAdmin set emPw = ? where emName = ? and emNum = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, emNewPw);
			preparedStatement.setString(2, emName);
			preparedStatement.setString(3, emNum);
			
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(resultSet != null)resultSet.close();
				if(preparedStatement != null)connection.close();
				if(connection != null)connection.close();
			} catch (Exception e2) {
			}
		}
	}

}
