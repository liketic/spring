package io.github.liketic.spring.user;


import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<User, Integer> {


    User findByLogin(String login);
}
