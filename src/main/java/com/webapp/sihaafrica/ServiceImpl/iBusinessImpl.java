package com.webapp.sihaafrica.ServiceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.webapp.sihaafrica.Models.Businesses;
import com.webapp.sihaafrica.Services.iBusiness;


@Component("businessImpl")
public class iBusinessImpl implements iBusiness {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public boolean updateBtoBStatus(Long id, String status) {
		int result = jdbcTemplate.update("UPDATE businesses SET status = ? WHERE id = ?",
				new Object[] {status,id});
		return result != 0;
	}

	@Override
	public Businesses findByCompany(String companyName) {
		return jdbcTemplate.query("SELECT * FROM businesses WHERE company_name = ?",
				new Object[] {companyName},(rs,rowNum)-> 
		Optional.of(new Businesses(rs.getLong("id"),rs.getString("company_name"),
				rs.getString("company_responsable"), rs.getString("company_activity"), 
				rs.getString("company_address"),rs.getString("company_country"),
				rs.getString("company_number"), rs.getString("company_fax"), rs.getString("company_email"),
				rs.getBytes("logo"),rs.getString("company_website"),rs.getString("company_facebook"),
				rs.getString("company_instagram"),rs.getString("company_linkedin"),
				rs.getString("company_twitter"),rs.getString("status"),rs.getString("registration_date")))).get(0).get();
	}

}
