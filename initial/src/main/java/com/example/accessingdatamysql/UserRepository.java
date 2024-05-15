package com.example.accessingdatamysql;

import org.springframework.data.repository.CrudRepository;

import com.example.accessingdatamysql.User;

/* Spring automatically implements this class into a Bean called userRepository
 * CRUD: Create, Read, Update, Delete */

public interface UserRepository extends CrudRepository<User, Integer> {

}