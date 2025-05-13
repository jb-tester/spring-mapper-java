package org.example.springmapperjava;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = PersonMapper.class, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface PersonListMapper  {

    List<PersonDTO> toDTO(List<Person> persons);
    List<Person> toPerson(List<PersonDTO> personDTOS);
}
