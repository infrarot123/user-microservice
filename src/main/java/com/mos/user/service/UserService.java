package com.mos.user.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mos.user.entity.User;
import com.mos.user.repository.UserRepository;
import com.mos.user.valueobjects.Department;
import com.mos.user.valueobjects.ResponseTemplate;


@Service
public class UserService {

   private static final Logger _log = LoggerFactory.getLogger(UserService.class);

   @Autowired
   private UserRepository _userRepository;
   @Autowired
   private RestTemplate _restTemplate;

   public ResponseTemplate getUserWithDepartment( Long userId ) {
      _log.info("Inside getUserWithDepartment of UserService");

      User user = _userRepository.findByUserId(userId);
      Department department = _restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" + user.getDepartmentId(), Department.class);

      return new ResponseTemplate(user, department);
   }

   public User saveUser( User user ) {
      _log.info("Inside saveUser of UserService");
      return _userRepository.save(user);
   }
}
