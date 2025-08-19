package com.budgetsplittingapp.budgetsplit.controllers;

import com.budgetsplittingapp.budgetsplit.model.Group;
import com.budgetsplittingapp.budgetsplit.model.GroupMember;
import com.budgetsplittingapp.budgetsplit.model.User;
import com.budgetsplittingapp.budgetsplit.repository.GroupMemberRepository;
import com.budgetsplittingapp.budgetsplit.repository.GroupRepository;
import com.budgetsplittingapp.budgetsplit.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/groups")
public class GroupMemberController {

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private GroupMemberRepository groupMemberRepository;

    @PostMapping("/{groupId}/members")
    public List<GroupMember> addMembers(@PathVariable Long groupId, @RequestBody List<String> memberNames) {
        Group group = groupRepository.findById(groupId)
                .orElseThrow(() -> new RuntimeException("Group not found"));

        List<GroupMember> newMembers = new ArrayList<>();

        for (String name : memberNames) {
            User user = new User();
            user.setName(name);
            userRepository.save(user);

            GroupMember gm = new GroupMember();
            gm.setGroup(group);
            gm.setUser(user);

            groupMemberRepository.save(gm);
            newMembers.add(gm);
        }

        return newMembers;
    }

    @GetMapping("/{groupId}/members")
    public List<GroupMember> getMembers(@PathVariable Long groupId) {
        return groupMemberRepository.findByGroup_Id(groupId);
    }
}
