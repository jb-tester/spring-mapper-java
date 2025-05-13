package org.example.springmapperjava;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
public class PersonService {

    private final PersonRepository personRepository;
    private final PersonMapper mapper;
    private final PersonMapperWithUses mapperWithUses;
    private final PersonListMapper personListMapper;

    public PersonService(PersonRepository personRepository, PersonMapper myMapper, PersonMapperWithUses mapperWithUses, PersonListMapper personListMapper) {
        this.personRepository = personRepository;
        this.mapper = myMapper;
        this.mapperWithUses = mapperWithUses;
        this.personListMapper = personListMapper;
    }

    @Transactional
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
    public List<PersonDTO> getAllPersonDTO2() {
        List<PersonDTO> result = new ArrayList<>();
        for (Person person : personRepository.findAll()) {
            result.add(mapperWithUses.personToDTO(person));
        }
        return result;
    }

    public List<PersonDTO> getAllPersonDTO3() {
        List<Person> personList = (List<Person>) personRepository.findAll();
        List<PersonDTO> result = personListMapper.toDTO(personList);
        return result;
    }
}
