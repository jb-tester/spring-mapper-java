package org.example.springmapperjava;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public abstract class PersonMapper {

    // we need to use field injection here
    // also private field should not be used here
     @Autowired
     NameService nameService;

     // it would be nice to have references in the annotation attributes to complete/validate them
    @Mapping(target = "name", expression = "java(nameService.getName(source.getGender(), source.getFirstName(), source.getLastName()))")
    @Mapping(target = "age", source = "source.age")
    public abstract PersonDTO personToDTO(Person source);
}