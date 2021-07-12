package projeto.sistemadecadastro.dto.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;
import projeto.sistemadecadastro.entity.Telephone;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonDTO {


    private Long id;

    @NotEmpty
    @Size(min = 2, max = 100)
    private String first_name;

    @NotEmpty
    @Size(min = 2, max = 100)
    private String last_name;
    @NotEmpty
    @CPF
    private String cpf;
    @NotNull
    private String birth_date;
    @Valid
    @NotEmpty
    private List<Telephone> telephones;


}
