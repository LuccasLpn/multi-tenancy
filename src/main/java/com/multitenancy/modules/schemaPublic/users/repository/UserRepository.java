package com.multitenancy.modules.schemaPublic.users.repository;

import com.multitenancy.modules.schemaPublic.users.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
