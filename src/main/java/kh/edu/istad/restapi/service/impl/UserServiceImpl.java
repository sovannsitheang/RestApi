package kh.edu.istad.restapi.service.impl;

import kh.edu.istad.restapi.dto.UserResponse;
import kh.edu.istad.restapi.mapper.UserMapper;
import kh.edu.istad.restapi.repository.UserRepository;
import kh.edu.istad.restapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public Page<UserResponse> getAllWithPaging(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return userRepository.findAll(pageable)
                .map(userMapper::mapUserToUserResponse);
    }

    @Override
    public List<UserResponse> getAll() {
        // SELECT * FROM m2_users;
        return userRepository.findAll()
                .stream()
                .map(userMapper::mapUserToUserResponse)
                .toList();
    }


    @Override
    public UserResponse getById(UUID id) {

        return userRepository.findById(id)
                .map(userMapper::mapUserToUserResponse)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "User not found"
                ));
    }


    }



