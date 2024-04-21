package com.capstone.backend.domain.user.controller;

import com.capstone.backend.domain.user.repository.ChildRepository;
import com.capstone.backend.domain.user.service.ChildService;
import com.capstone.backend.domain.user.service.FriendService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/friends")
public class FriendController {
    private final FriendService friendService;
    private final ChildService childService;

    public FriendController(FriendService friendService, ChildService childService) {
        this.friendService = friendService;
        this.childService = childService;
    }

    @PostMapping("/accept")
    public ResponseEntity<?> acceptFriendRequest(@RequestBody Map<String, Long> requestBody) {
        Long teacherUserId = requestBody.get("teacherUserId");
        Long parentUserId = requestBody.get("parentUserId");

        friendService.acceptFriendRequest(teacherUserId, parentUserId);
        childService.mapTeacherToChild(teacherUserId, parentUserId);

        return ResponseEntity.ok("Friend request accepted successfully.");
    }
}