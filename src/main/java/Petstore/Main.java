package Petstore;

import Petstore.model.*;
import Petstore.repository.PetStoreManager;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {

        String url = "https://petstore.swagger.io/v2/";

        User user = User.builder()
                .id(1)
                .userName("John")
                .firstName("John")
                .lastName("Smith")
                .eMail("JS@gmail.com")
                .password("124543345")
                .phone("0502345678")
                .userStatus(1)
                .build();

        Animal animal = Animal.builder()
                .id(1)
                .category(Category.builder()
                        .id(1)
                        .name("Category")
                        .build())
                .name("Dog")
                .photoUrls(Arrays.stream(new String[]{""}).collect(Collectors.toList()))
                .status("good dog")
                .tags(Arrays.stream(new Tag[]{Tag.builder()
                                .id(1).name("qwerty")
                                .build()})
                        .collect(Collectors.toList()))
                .status("sold")
                .build();

        Order order = Order.builder()
                .id(1)
                .petId(2)
                .quantity(23)
                .shipDate(LocalDateTime.now().toString())
                .status("placed")
                .complete(true)
                .build();

        PetStoreManager manager = new PetStoreManager(url);

        //Pet
        System.out.println(manager.uploadAnimalImage(1, "dog.jpg"));
        //System.out.println(manager.updateAnimal(animal));
        //System.out.println(manager.createAnimal(animal));
        //System.out.println(manager.getAnimalsByStatus("sold"));
        //System.out.println(manager.getAnimalById(1));
        //System.out.println(manager.updateAnimalWithForm(12, "dog", "sold"));
        //System.out.println(manager.deleteAnimal(13));

        //Store
        //System.out.println(manager.getPetInventories());
        //System.out.println(manager.createAnOrder(order));
        //System.out.println(manager.getOrderById(12));
        //System.out.println(manager.deleteOrderById(2));

        //User
        //System.out.println(manager.createUsersFromList(Arrays.stream(new User[]{user, user}).collect(Collectors.toList())));
        //System.out.println(manager.getUserByName("user"));
        //System.out.println(manager.updateUser(user));
        //System.out.println(manager.deleteUserByName("user12"));
        //System.out.println(manager.loginUser("user12", "user"));
        //System.out.println(manager.logoutUser());
        //System.out.println(manager.createUsersFromArray(new User[]{user, user}));
        //System.out.println(manager.createUser(user));

    }
}