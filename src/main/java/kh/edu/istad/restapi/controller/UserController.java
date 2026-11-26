package kh.edu.istad.restapi.controller;

import kh.edu.istad.restapi.dto.UserResponse;
import kh.edu.istad.restapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor

public class UserController {

    private final UserService userService;

    @GetMapping("/paging")
    public Page<UserResponse> getAllWithPaging(
            @RequestParam(required = false, defaultValue = "0") int pageNumber,
            @RequestParam(required = false, defaultValue = "25") int pageSize
    ){
        return  userService.getAllWithPaging(pageNumber, pageSize);
    }

    @GetMapping("/all")
    public List<UserResponse> getAll(){
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public UserResponse getById(@PathVariable UUID id){
        return userService.getById(id);
    }

//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public User create(@RequestBody User user) {
//        return userService.create(user);
//    }
//
//    @DeleteMapping("/{id}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void delete(@PathVariable UUID id) {
//        userService.deleteById(id);
//    }

}
