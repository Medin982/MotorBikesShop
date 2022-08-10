package com.motorbikesshop.util;

import com.motorbikesshop.model.entity.*;
import com.motorbikesshop.model.enums.*;
import com.motorbikesshop.repository.*;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class TestData {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final AnnouncementRepository announcementRepository;
    private final BrandRepository brandRepository;
    private final ModelRepository modelRepository;
    private final ImagesRepository imagesRepository;
    private final AddressRepository addressRepository;
    private final CityRepository cityRepository;

    public TestData(UserRepository userRepository,
                    RoleRepository roleRepository,
                    AnnouncementRepository announcementRepository,
                    BrandRepository brandRepository,
                    ModelRepository modelRepository,
                    ImagesRepository imagesRepository,
                    AddressRepository addressRepository,
                    CityRepository cityRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.announcementRepository = announcementRepository;
        this.brandRepository = brandRepository;
        this.modelRepository = modelRepository;
        this.imagesRepository = imagesRepository;
        this.addressRepository = addressRepository;
        this.cityRepository = cityRepository;
    }

    private void initRoles() {
        if (roleRepository.count() <= 0) {
            Role adminRole = new Role();
            adminRole.setName(UserRoleEnum.ADMIN);
            Role userRole = new Role();
            userRole.setName(UserRoleEnum.USER);
            this.roleRepository.save(adminRole);
            this.roleRepository.save(userRole);
        }
    }

    public UserEntity initTestAdmin() {
        initRoles();
        Optional<Role> adminRole = this.roleRepository.findByName(UserRoleEnum.ADMIN);
        var admin = new UserEntity();
        admin.setFirstName("Admin");
        admin.setLastName("Admin");
        admin.setEmail("admin@mail.com");
        admin.setRole(adminRole.get());
        admin.setPassword("ca034dee7f2ab6ec995e1257add7f0521a84039429a33766b568d86f4b4fe038bfc92c783099eeec");
        admin.setPhoneNumber(00000000);
        return this.userRepository.save(admin);
    }

    public UserEntity initTestUser() {
        initRoles();
        Optional<Role> userRole = this.roleRepository.findByName(UserRoleEnum.USER);
        var user = new UserEntity();
        user.setFirstName("User");
        user.setLastName("User");
        user.setEmail("user@mail.com");
        user.setRole(userRole.get());
        user.setPassword("ca034dee7f2ab6ec995e1257add7f0521a84039429a33766b568d86f4b4fe038bfc92c783099eeec");
        user.setPhoneNumber(00000001);
        return this.userRepository.save(user);
    }

    public Brand initTestBrand() {
        var testBrand = new Brand();
        testBrand.setName("KTM");
        return this.brandRepository.save(testBrand);
    }

    public Model initTestModel(Brand brand) {
        var testModel = new Model();
        testModel.setName("SXF");
        testModel.setCategory(MotorBikesType.MOTOCROSS);
        testModel.setBrand(brand);
        return this.modelRepository.save(testModel);
    }

    public Address initTestAddress(City city) {
        var testAddress = new Address();
        testAddress.setCity(city);
        testAddress.setStreet("Street");
        testAddress.setStreetNumber(1);

        return this.addressRepository.save(testAddress);
    }

    public City intiTestCity() {
        var testCity = new City();
        testCity.setName("City");
        testCity.setPostCode(1020);

        return this.cityRepository.save(testCity);
    }

    public Images initTestImages() {
        var testImage = new Images();
        testImage.setUrl("http://image/sads");
        testImage.setPublicId("imagePublicId");

        return this.imagesRepository.save(testImage);
    }

    public Announcement initTestAnnouncement(UserEntity seller, Model model,
                                             Address address, List<Images> images) {
        var testAnnouncement = new Announcement();
        testAnnouncement.setAddress(address);
        testAnnouncement.setCategory(MotorBikesType.MOTOCROSS);
        testAnnouncement.setColor(ColorType.RED);
        testAnnouncement.setCreated(LocalDateTime.now());
        testAnnouncement.setConditions(ConditionType.USED);
        testAnnouncement.setDescription("some description fot this announcement!!!");
        testAnnouncement.setDateOfManufacture(LocalDate.of(2000, 01, 01));
        testAnnouncement.setEngine(EngineType.PETROL);
        testAnnouncement.setHorsePower(50);
        testAnnouncement.setMileage(100);
        testAnnouncement.setModel(model);
        testAnnouncement.setSeller(seller);
        testAnnouncement.setImages(images);
        testAnnouncement.setModification("test");
        testAnnouncement.setPrice(BigDecimal.valueOf(100));
        testAnnouncement.setTransmission(TransmissionType.AUTOMATIC);

        return this.announcementRepository.save(testAnnouncement);
    }

    public void clearTestDate() {
        announcementRepository.deleteAll();
        addressRepository.deleteAll();
        cityRepository.deleteAll();
        imagesRepository.deleteAll();
        userRepository.deleteAll();
        roleRepository.deleteAll();
        modelRepository.deleteAll();
        brandRepository.deleteAll();
    }
}
