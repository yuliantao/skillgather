package com.ylt.springdata.Service;

import java.util.List;

import com.ylt.springdata.entity.Person;
import com.ylt.springdata.repository.PersonRepsotory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonService {

	@Autowired
	private PersonRepsotory personRepsotory;
	
	@Transactional
	public void savePersons(List<Person> persons){
		personRepsotory.saveAll(persons);
	}
	
	@Transactional
	public void updatePersonEmail(String email, Integer id){
		personRepsotory.updatePersonEmail(id, email);
	}
}