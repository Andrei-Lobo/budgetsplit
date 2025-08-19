package com.budgetsplittingapp.budgetsplit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.budgetsplittingapp.budgetsplit.model.GroupMember;
import java.util.List;

public interface GroupMemberRepository extends JpaRepository<GroupMember, Long> {
    List<GroupMember> findByGroup_Id(Long groupId);
}
