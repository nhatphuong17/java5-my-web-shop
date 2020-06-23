package com.nhatpoly.NhatAssignment5.reponseitory;


import com.nhatpoly.NhatAssignment5.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserReponseitory extends CrudRepository<User, Long> {

}
