package projeto.sistemadecadastro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projeto.sistemadecadastro.entity.Person;


@Repository
public interface PersonRepository extends JpaRepository<Person,Long> {
}
