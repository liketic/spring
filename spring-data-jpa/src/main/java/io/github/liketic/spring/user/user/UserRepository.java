package io.github.liketic.spring.user.user;


import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<User, Integer> {


    User findByLogin(String login);
}
