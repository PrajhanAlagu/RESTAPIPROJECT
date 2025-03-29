package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    public User addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @GetMapping
    public List<User>getUsers(){
        return userService.getUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id,@RequestBody User userDetails){
        return userService.updateUser(id,userDetails);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id){
        boolean del=userService.deleteUser(id);
        if(del){
            return "User Deleted";
        }
        else{
            return "No user with id: "+id+" found";
        }
   }
   @GetMapping("/paging")
    public ResponseEntity<List<User>> getUsersWithPaginationAndSorting(
            @RequestParam int page,
            @RequestParam int size,
            @RequestParam String sortBy){
        List<User> users = userService.getAllUsersWithPaginationAndSorting(page, size, sortBy);
        return ResponseEntity.ok(users);
    }

}
