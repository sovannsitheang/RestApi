package kh.edu.istad.restapi.service;


import kh.edu.istad.restapi.dto.UserResponse;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.UUID;

public interface UserService {


    Page<UserResponse> getAllWithPaging(int pageNumber, int pageSize);


    // logic here

    List<UserResponse> getAll();

    UserResponse getById(UUID id);

}