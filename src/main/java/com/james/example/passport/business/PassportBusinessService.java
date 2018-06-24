package com.james.example.passport.business;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.james.example.passport.model.entity.PassportEntity;
import com.james.example.passport.model.repository.PassportEntityRepository;
import com.james.example.passport.web.Passport;

@Service
public class PassportBusinessService {
	private PassportEntityRepository passportRepository;
	
	private static final DateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

	@Autowired
    public PassportBusinessService(PassportEntityRepository passportRepository) {
		this.passportRepository = passportRepository;
	}

	public void create(Passport passport) {
		Date dob = createDateFromDateString(passport.getDateOfBirth()); 
		Date doi = createDateFromDateString(passport.getDateOfIssue()); 
		Date doe = createDateFromDateString(passport.getDateOfExpiry());
		
				
		PassportEntity entity = new PassportEntity(passport.getDocNo(), 
				passport.getFirstName(), passport.getLastName(), passport.getPlaceOfBirth(), passport.getNationality(),
				passport.getSex(), passport.getAuthority(), new java.sql.Date(dob.getTime()), new java.sql.Date(doi.getTime()),
				new java.sql.Date(doe.getTime()), passport.getImageFilename(), passport.getImage(), passport.getImageContentType());
		
		this.passportRepository.save(entity);
	}
	
	public PassportEntity findByPassportDocNo(String docNo) {
		PassportEntity pe = this.passportRepository.findByDocNo(docNo);
		return pe;
		
	}
	
	private Date createDateFromDateString(String dateString){
        Date date = null;
        if(null!=dateString) {
            try {
                date = DATE_FORMAT.parse(dateString);
            }catch(ParseException pe){
                date = new Date();
            }
        }else{
            date = new Date();
        }
        return date;
    }
}