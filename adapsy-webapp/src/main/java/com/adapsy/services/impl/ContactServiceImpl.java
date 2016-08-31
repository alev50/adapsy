package com.adapsy.services.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import com.adapsy.model.Contact;
import com.adapsy.services.ContactService;

@Service
public class ContactServiceImpl implements ContactService {

	private NamedParameterJdbcTemplate template;
	private ContactMapper contactMapper = new ContactMapper();
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
        this.template = new NamedParameterJdbcTemplate(dataSource);
    }
	
	@Override
	public List<Contact> findAll() {
		List<Contact> result = this.template.query("select * from contact", contactMapper);
		
		return result;
	}
	
	private static final class ContactMapper implements RowMapper<Contact> {

	    public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
	        Contact contact = new Contact();
	        
	        contact.setId(rs.getLong("id"));
	        contact.setPrenom(rs.getString("prenom"));
	        contact.setNom(rs.getString("nom"));
	        
	        return contact;
	    }
	}

}

