package com.hand.repository;

import com.hand.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by 亮着的灯 on 2018/1/3.
 */
@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
