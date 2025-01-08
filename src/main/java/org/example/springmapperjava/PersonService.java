package org.example.springmapperjava;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class PersonService {

    private final PersonRepository personRepository;
    private final PersonMapper mapper;

    public PersonService(PersonRepository personRepository, PersonMapper myMapper) {
        this.personRepository = personRepository;
        this.mapper = myMapper;
    }

    public void populateDB() {
        personRepository.save(new Person("ivan","ivanov",25,Gender.MALE));
        personRepository.save(new Person("maria","mashkina",25,Gender.FEMALE));
        personRepository.save(new Person("pavel","pavlov",30,Gender.MALE));
        System.out.println("====== the DB was populated =====");
    }

    public PersonDTO getPersonDTO(Person person) {
        return mapper.personToDTO(person);
    }

    public List<PersonDTO> getAllPersonDTO() {
        List<PersonDTO> result = new ArrayList<>();
        for (Person person : personRepository.findAll()) {
            result.add(mapper.personToDTO(person));
        }
        return result;
    }
}
