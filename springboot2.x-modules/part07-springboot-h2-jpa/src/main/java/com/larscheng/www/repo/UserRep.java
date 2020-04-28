package com.larscheng.www.repo;

import com.larscheng.www.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRep extends JpaRepository<User,Long> {


}
