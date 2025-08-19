package com.budgetsplittingapp.budgetsplit.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.budgetsplittingapp.budgetsplit.model.Group;
import com.budgetsplittingapp.budgetsplit.repository.GroupRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/group")
public class GroupController {
    private GroupRepository groupRepo;

    public GroupController(GroupRepository groupRepo) {
        this.groupRepo = groupRepo;
    }

    @PostMapping
    public Group createGroup(@RequestBody Group group) {
        return groupRepo.save(group);
    }

    @GetMapping
    public List<Group> getGroup() {
        return groupRepo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Group> getGroupId(@PathVariable Long id) {
        return groupRepo.findById(id)
                .map(ResponseEntity::ok) // return 200 OK with group
                .orElseGet(() -> ResponseEntity.notFound().build()); // return 404
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGroup(@PathVariable Long id) {
        groupRepo.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
