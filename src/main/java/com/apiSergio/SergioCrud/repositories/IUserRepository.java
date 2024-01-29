package com.apiSergio.SergioCrud.repositories;

import com.apiSergio.SergioCrud.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Arrays;

@Repository
public interface IUserRepository extends JpaRepository<UserModel, Long> {
    //clase que permite query a db
}
