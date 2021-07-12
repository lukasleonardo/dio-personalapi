package projeto.sistemadecadastro.dto.mapper;

import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import projeto.sistemadecadastro.dto.requests.PersonDTO;
import projeto.sistemadecadastro.entity.Person;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonMapper {
    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    @Mapping(target = "birth_date", source = "birth_date", dateFormat = "dd-MM-yyyy")
    Person toModel(PersonDTO dto);

    PersonDTO toDTO(Person dto);
}
