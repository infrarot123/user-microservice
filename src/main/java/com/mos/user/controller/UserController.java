package com.mos.user.controller;

import javax.websocket.server.PathParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mos.user.entity.User;
import com.mos.user.service.UserService;
import com.mos.user.valueobjects.ResponseTemplate;


@RestController
@RequestMapping("/users")
public class UserController {

   private static final Logger _log = LoggerFactory.getLogger(UserController.class);

   @Autowired
   private UserService _userService;

   @PostMapping("/")
   public User saveUser(@RequestBody User user) {
      _log.info("Inside saveUser of UserController");
      return _userService.saveUser(user);
   }

   @GetMapping("/{id}")
   public ResponseTemplate getUserWithDepartment(@PathVariable("id") Long userId) {
      _log.info("Inside getUserWithDepartment of UserController");
      return _userService.getUserWithDepartment(userId);
   }
}
