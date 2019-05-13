package com.test.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.transaction.support.TransactionTemplate;

import com.test.board.dto.Employee;
import com.test.board.dto.QnADto;
import com.test.board.util.Constant;

public class QnADao {


	DataSource dataSource;
	JdbcTemplate template;
	TransactionTemplate transactionTemplate;

	public QnADao(){
		try {
			Context context = new InitialContext();
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/Mysql");
		} catch(NamingException e) {
			e.printStackTrace();
		}
		
		template = Constant.template;	
	}
	
	public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
		this.transactionTemplate = transactionTemplate;
	} 
	
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}




	public ArrayList<QnADto> qnaList(){
		String sql = "select q.qCode, qName, qEmail, qPhone, p.pdCode, p.pdName, qContents, q.qRegistTime, a.aAnswer, s.stCode, s.stName\n" + 
				"from question q\n" + 
				"left join answer a\n" + 
				"using (qCode)\n" +  
				"join product p\n" + 
				"on q.pdCode = p.pdCode\n" + 
				"join state s\n" + 
				"on q.stCode = s.stCode\n" + 
				"order by qRegistTime desc";
		return (ArrayList<QnADto>) template.query(sql, new BeanPropertyRowMapper<QnADto>(QnADto.class));
	}
	
	
	
	public List<QnADto> qnaResponding(int stCode, int emCode) {
		Object[] params = {stCode, emCode};
		String sql = "select qCode, qName, qEmail, qPhone, p.pdCode, p.pdName, qContents, qRegistTime,  s.stCode, s.stName\n" + 
				"from question q , product p, state s where q.pdCode = p.pdCode and q.stCode = s.stCode and q.stCode = ? and emCode = ?"; 
		return   template.query(sql, params, new BeanPropertyRowMapper<QnADto>(QnADto.class));
	}

	
	//QnA Regist
	public void regist(final String qName, final String qEmail, final String qPhone, final String pdCode, final String qContents) {
		
		String sql = "insert into question(qName, qEmail, qPhone, pdCode, qContents) values(?, ?, ?, ?, ?)";
		template.update(sql, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, qName);
				ps.setString(2, qEmail);
				ps.setString(3, qPhone);
				ps.setInt(4,  Integer.parseInt(pdCode));
				ps.setString(5,  qContents);
			}
				
		});	
	}
	
	public void reply(String reply, int qCode, int emCode) {
		
	
		
//		transactionTemplate.execute(new TransactionCallbackWithoutResult() {
//			
//			@Override
//			protected void doInTransactionWithoutResult(TransactionStatus status) {
//				
				String sql = "insert into answer(aAnswer, qCode, emCode) values(?, ?, ?)";
				
				template.update(sql, new PreparedStatementSetter() {

					@Override
					public void setValues(PreparedStatement ps) throws SQLException {
						ps.setString(1, reply);
						ps.setInt(2, qCode);
						ps.setInt(3, emCode);
						System.out.println(qCode);
						System.out.println(emCode);
						
					}
					
				});
//				
//				String quesry = "insert into test(id, title) values(?, ?)";
//				template.update(quesry, new PreparedStatementSetter() {
//
//					@Override
//					public void setValues(PreparedStatement ps) throws SQLException {
//						ps.setInt(1, 8);
//						ps.setString(2, "test");
//
//					}
//					
//				});
//				
//			}
//		});
//		
//		System.out.println("transactionTemplate : " + transactionTemplate);
//		
//		transactionTemplate.execute(new TransactionCallbackWithoutResult() {
//			
//			@Override
//			protected void doInTransactionWithoutResult(TransactionStatus status) {
//				
//				template.update(new PreparedStatementCreator() {
//					
//					@Override
//					public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
//						String sql = "insert into answer(aAnswer, qCode, emCode) values(?, ?, ?)";
//						PreparedStatement pstmt = con.prepareStatement(sql);
//						pstmt.setString(1, reply);
//						pstmt.setInt(2, qCode);
//						pstmt.setInt(3, emCode);
//						return pstmt;
//					}
//				});
//				
//			}
//		});
		
		


		
		
		
		
	}
	
//	public AnswerDto replyView(String qCode) {
//		
//		AnswerDto dto2 = null;
//		Connection connection = null;
//		PreparedStatement preparedStatement = null;
//		PreparedStatement preparedStatement2 = null;
//		ResultSet resultSet = null;
//		
//		TransactionDefinition definition =  new DefaultTransactionDefinition();
//		TransactionStatus status = transactionManager.getTransaction(definition);
//		
//		
//		try {
//			
//			connection = dataSource.getConnection();
//			String sql = "select * from answer where qCode = ?";
//			String query = "update question set aCode = ? where qCode = ?";
//
//			preparedStatement = connection.prepareStatement(sql);
//			preparedStatement.setInt(1,  Integer.parseInt(qCode));
//			resultSet = preparedStatement.executeQuery();
//			
//			if(resultSet.next()) {
//				String aAnswer = resultSet.getString("aAnswer");
//				int qnaCode = resultSet.getInt("qCode");
//				String qRegistTime = resultSet.getString("qRegistTime");
//				int emCode = resultSet.getInt("emCode");
//				
//				dto2 = new AnswerDto(aAnswer, qnaCode, qRegistTime, emCode);
//				
//				preparedStatement2 = connection.prepareStatement(query);
//				int aCode = resultSet.getInt("aCode");
//				preparedStatement2.setInt(1, aCode);
//				preparedStatement2.setInt(2, qnaCode);
//				preparedStatement2.executeUpdate();
//			}
//			
//			transactionManager.commit(status);
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//			transactionManager.rollback(status);
//		} finally {
//			try {
//				if(resultSet != null)resultSet.close();
//				if(preparedStatement != null)connection.close();
//				if(connection != null)connection.close();
//			} catch (Exception e2) {
//
//			}
//		}
//	
//	
//		return dto2;	
//	}
	
	public void signUp(final String emName, final String emPw, final String emNum) {
		
		String sql = "insert into signUpAdmin(emName, emPw, emNum) values(?, ?, ?)";
		template.update(sql, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				
				ps.setString(1, emName);
				ps.setString(2, emPw);
				ps.setString(3, emNum);
				
			}
		});
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
	
	//update inservice
	public void updateState(final int stCode, final int emCode, final int qCode) {
		
		String sql = "update question set stCode = ?, emCode = ? where qCode = ?";
		template.update(sql, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, stCode);
				ps.setInt(2, emCode);
				ps.setInt(3, qCode);
			}
		});
	}
	
	
	//change password
	public void changePw(String emNewPw, String emName, String emNum) {
		
		String sql = "update signUpAdmin set emPw = ? where emName = ? and emNum = ?";
		template.update(sql, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, emNewPw);
				ps.setString(2, emName);
				ps.setString(3, emNum);
			}
		});
	}

	
	
}
