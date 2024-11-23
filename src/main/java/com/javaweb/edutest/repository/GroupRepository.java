package com.javaweb.edutest.repository;

import com.javaweb.edutest.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {
    List<Group> findByOwner_Id(long ownerId);

}
