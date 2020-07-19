package com.webapp.sihaafrica.ServiceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.webapp.sihaafrica.Models.Exhibitors;
import com.webapp.sihaafrica.Services.iExhibitor;


@Component
public class iExhibitorImpl implements iExhibitor {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public boolean updateExhibitorStatut(Long id, String status) {
		int result = jdbcTemplate.update("UPDATE exhibitors SET status = ? WHERE id = ?",
				new Object[] {status,id});
		return result != 0;
	}

	@Override
	public Exhibitors findByCompany(String companyName) {
		return jdbcTemplate.query("SELECT * FROM exhibitors WHERE company_name = ?",
				new Object[] {companyName},(rs,rowNum)-> 
		Optional.of(new Exhibitors(rs.getLong("id"),rs.getString("company_name"),
				rs.getString("company_responsable"), rs.getString("company_activity"), 
				rs.getString("company_address"),rs.getString("company_country"),
				rs.getString("company_number"), rs.getString("company_fax"), rs.getString("company_email"),
				rs.getBytes("logo"),rs.getString("company_website"), rs.getString("registration_date"), 
				rs.getString("status"), rs.getString("stands"), rs.getString("facade"),rs.getString("surface"),
				rs.getDouble("montant"),rs.getInt("lunchbox"),rs.getInt("pub_minipage"),
				rs.getInt("pub_onepage"),rs.getInt("pub_doublepage"),rs.getInt("chairs"),
				rs.getInt("tables"),rs.getInt("desks"),rs.getString("company_city")))).get(0).get();
	}

}
