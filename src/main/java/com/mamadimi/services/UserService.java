package com.mamadimi.services;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import com.mamadimi.dao.UserDAO;
import com.mamadimi.models.User;

@Repository
public class UserService implements UserDAO {
	
	
	private JdbcTemplate jdbcTemplateObj;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplateObj = new JdbcTemplate(dataSource);
	}
	
	@Override
	public void save(User user) {
		
		BCryptPasswordEncoder passEncoder = new BCryptPasswordEncoder();		
		String sql = "insert into users (fullname, email, phone, company, password, role, active) values (?,?,?,?,?,?,?)" + 
				"";
		
		String encryptedPassword = passEncoder.encode(user.getPassword());
		
		jdbcTemplateObj.update(sql, user.getFullName(),user.getEmail(),user.getPhone(),user.getCompany(),encryptedPassword ,"ROLE_USER",1);
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public User getUserByEmail (String email) {
		// TODO Auto-generated method stub
		String sql = "Select * from users where email = ?";
		
		User user = jdbcTemplateObj.queryForObject(sql, new Object[] {email}, new UserRowMapper());
		
		return user;
	}
	
	@Override
	public User getUserById (long id) {
		// TODO Auto-generated method stub
		String sql = "Select * from users where id = ?";
		
		User user = jdbcTemplateObj.queryForObject(sql, new Object[] {id}, new UserRowMapper());
		
		return user;
	}

}
