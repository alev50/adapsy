package com.adapsy.services.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;

import com.adapsy.model.Contact;
import com.adapsy.services.ContactService;

@Service
public class ContactServiceImpl implements ContactService {

	private NamedParameterJdbcTemplate template;
	private ContactMapper contactMapper = new ContactMapper();
	
	private static final class ContactMapper implements RowMapper<Contact> {

	    public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
	        Contact contact = new Contact();
	        
	        contact.setId(rs.getLong("id"));
	        contact.setPrenom(rs.getString("prenom"));
	        contact.setNom(rs.getString("nom"));
	        
	        return contact;
	    }
	}
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
        this.template = new NamedParameterJdbcTemplate(dataSource);
    }
	
	@Override
	public List<Contact> findAll() {
		String sql = "select * from contact";
		List<Contact> contacts = this.template.query(sql, contactMapper);
		
		return contacts;
	}
	

	@Override
	public List<Contact> searchContacts(Contact criteria) {
		String sql = "select * from contact where id = :id or lower(nom) = lower(:nom) or lower(prenom) = lower(:prenom)";
		SqlParameterSource parameters = new BeanPropertySqlParameterSource(criteria);
		List<Contact> contact = this.template.query(sql, parameters, contactMapper);
		
		return contact;
	}
	
	@Override
	public Contact getContact(Long id) {
		String sql = "select * from contact where id = :id";
		SqlParameterSource parameters = new MapSqlParameterSource("id", id);
		Contact contact = this.template.queryForObject(sql, parameters, contactMapper);
		
		return contact;
	}

	@Override
	public Long createContact(Contact contact) {
		String sql = "insert into contact (nom, prenom) values (:nom, :prenom)";
		SqlParameterSource parameters = new BeanPropertySqlParameterSource(contact);
		KeyHolder keyHolder = new GeneratedKeyHolder();
		this.template.update(sql, parameters, keyHolder);
		
		return Long.valueOf((Integer) keyHolder.getKeys().get("id"));
	}
	
}
