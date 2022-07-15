package com.motorbikesshop.service;

import com.motorbikesshop.model.dtos.RegisterDTO;
import com.motorbikesshop.model.entity.Role;
import com.motorbikesshop.model.entity.UserEntity;
import com.motorbikesshop.model.enums.UserRoleEnum;
import com.motorbikesshop.repository.RoleRepository;
import com.motorbikesshop.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final ModelMapper modelMapper;

    @Autowired
    public UserService(UserRepository userRepository, RoleRepository roleRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.modelMapper = modelMapper;
    }

    public void registerUser(RegisterDTO registerDTO) {
        //TODO: Need to implement passwordEncoder
        UserEntity user = this.modelMapper.map(registerDTO, UserEntity.class);
        Optional<Role> userRole = this.roleRepository.findByName(UserRoleEnum.USER);
        user.setRole(userRole.get());
        this.userRepository.save(user);
    }
}
