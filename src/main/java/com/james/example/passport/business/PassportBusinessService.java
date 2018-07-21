package com.james.example.passport.business;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.james.example.passport.model.entity.PassportEntity;
import com.james.example.passport.model.repository.PassportEntityRepository;
import com.james.example.passport.web.Passport;

/**
 * 
 * @author James Jayaputera (james.jayaputera@gmail.com)
 *
 */
@Service
public class PassportBusinessService {
	private PassportEntityRepository passportRepository;
	
	private static final DateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

	@Autowired
    public PassportBusinessService(PassportEntityRepository passportRepository) {
		this.passportRepository = passportRepository;
	}

	public void create(Passport passport) throws IllegalArgumentException {
		Date dob = createDateFromDateString(passport.getDateOfBirth()); 
		Date doi = createDateFromDateString(passport.getDateOfIssue()); 
		Date doe = createDateFromDateString(passport.getDateOfExpiry());
		
		if (doi.after(doe)) {
			throw new IllegalArgumentException("'Date of issue' cannot be after 'Date of Expiry'.");
		}
				
		PassportEntity entity = new PassportEntity(passport.getDocNo(), 
				passport.getFirstName(), passport.getLastName(), passport.getPlaceOfBirth(), passport.getNationality(),
				passport.getSex(), passport.getAuthority(), new java.sql.Date(dob.getTime()), new java.sql.Date(doi.getTime()),
				new java.sql.Date(doe.getTime()), passport.getImageFilename(), passport.getImage(), passport.getImageContentType());

		this.passportRepository.save(entity);
	}
	
	public void saveChanges(String passportNo, Passport passport) {
		PassportEntity pe = this.passportRepository.findByDocNo(passportNo);
		Assert.notNull(pe, "Passport with number " + passportNo + " does not exist in database.");
		Date dob = createDateFromDateString(passport.getDateOfBirth());
		Date doi = createDateFromDateString(passport.getDateOfIssue());
		Date doe = createDateFromDateString(passport.getDateOfExpiry());

		if (doi.after(doe)) {
			throw new IllegalArgumentException("'Date of issue' cannot be after 'Date of Expiry'.");
		}

		pe.setFirstName(passport.getFirstName());
		pe.setLastName(passport.getLastName());
		pe.setPlaceOfBirth(passport.getPlaceOfBirth());
		pe.setNationality(passport.getNationality());
		pe.setSex(passport.getSex());
		pe.setAuthority(passport.getAuthority());
		pe.setDateOfBirth(new java.sql.Date(dob.getTime()));
		pe.setDateOfIssue(new java.sql.Date(doi.getTime()));
		pe.setDateOfExpiry(new java.sql.Date(doe.getTime()));
		pe.setImage(passport.getImage());
		pe.setImageFilename(passport.getImageFilename());
		pe.setImageContentType(passport.getImageContentType());

		this.passportRepository.save(pe);
	}

	public Passport findByPassportDocNo(String docNo) {
		Passport p = null;
		PassportEntity pe = this.passportRepository.findByDocNo(docNo);
		if (pe != null) {
			String dob = createDateStringFromDateSQL(pe.getDateOfBirth()); 
			String doi = createDateStringFromDateSQL(pe.getDateOfIssue()); 
			String doe = createDateStringFromDateSQL(pe.getDateOfExpiry());

			p = new Passport(pe.getDocNo(), 
					pe.getFirstName(), pe.getLastName(), pe.getPlaceOfBirth(), pe.getNationality(),
					pe.getSex(), pe.getAuthority(), dob, doi, doe, pe.getImage(), pe.getImageFilename(), pe.getImageContentType());
		}

		return p;		
	}
	
	public void delete(String id) {
		this.passportRepository.deleteById(id);
	}

	private Date createDateFromDateString(String dateString){
        Date date = null;
        if (null != dateString) {
            try {
                date = DATE_FORMAT.parse(dateString);
            }catch(ParseException pe){
                date = new Date();
            }
        } else {
            date = new Date();
        }
        
        return date;
    }
	
	private String createDateStringFromDateSQL(Date date){
        return date == null ? null : DATE_FORMAT.format(date);
    }
}
