package org.example.springmapperjava;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses ={NameConverter.class}, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface PersonMapperWithUses {
    @Mapping(target = "name", expression = "java(NameConverter.convert(source.getFirstName(), source.getLastName()))")
    @Mapping(target = "age", source = "source.age")
    PersonDTO personToDTO(Person source);
}
