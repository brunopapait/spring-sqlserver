package br.com.papait.bruno.spring.com.sql_server.repository;

import br.com.papait.bruno.spring.com.sql_server.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<UserModel, Long> {
}
