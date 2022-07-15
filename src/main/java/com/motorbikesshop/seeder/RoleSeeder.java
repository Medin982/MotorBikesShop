package com.motorbikesshop.seeder;

import com.motorbikesshop.model.entity.Role;
import com.motorbikesshop.model.enums.UserRoleEnum;
import com.motorbikesshop.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class RoleSeeder implements CommandLineRunner {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleSeeder(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        if (roleRepository.count() == 0) {
            this.roleRepository.saveAll(Arrays.stream(UserRoleEnum.
                            values()).
                    map(Role::new).
                    toList());
        }
    }
}
