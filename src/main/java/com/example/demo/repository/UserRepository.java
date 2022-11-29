package com.example.demo.repository;

import com.example.demo.domain.User;
import org.hibernate.ScrollableResults;
import org.hibernate.internal.util.type.PrimitiveWrapperHelper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public  interface UserRepository extends JpaRepository<User,Integer>{

    public  User findByUserNameAndPassword(String userName, String password);

}
