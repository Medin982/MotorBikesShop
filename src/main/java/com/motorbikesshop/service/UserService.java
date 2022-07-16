package com.motorbikesshop.service;

import com.motorbikesshop.model.dtos.RegisterDTO;
import com.motorbikesshop.model.entity.Role;
import com.motorbikesshop.model.entity.UserEntity;
import com.motorbikesshop.model.enums.UserRoleEnum;
import com.motorbikesshop.repository.RoleRepository;
import com.motorbikesshop.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final ModelMapper modelMapper;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, RoleRepository roleRepository,
                       ModelMapper modelMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
    }

    public void registerUser(RegisterDTO registerDTO) {
        String rowPassword = this.passwordEncoder.encode(registerDTO.getPassword());
        UserEntity user = this.modelMapper.map(registerDTO, UserEntity.class);
        Optional<Role> userRole = this.roleRepository.findByName(UserRoleEnum.USER);
        user.setPassword(rowPassword);
        user.setRole(userRole.get());
        this.userRepository.save(user);
    }
}
