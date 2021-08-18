package Petstore.repository;

import Petstore.model.*;
import Petstore.util.RetrofitBuilder;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

import java.io.File;
import java.util.HashMap;
import java.util.List;

public class PetStoreManager {

    private final APIService API_SERVICE;

    public PetStoreManager(String baseUrl) {
        this.API_SERVICE = RetrofitBuilder.getRetrofit(baseUrl, APIService.class);
    }

    //Pet
    public ApiResponse uploadAnimalImage(long animalId, String imageUrl) {

        File file = new File(imageUrl);
        RequestBody requestBody = RequestBody.create(MediaType.parse("image/*"), file);
        MultipartBody.Part filePart = MultipartBody.Part.createFormData("file", file.getName(), requestBody);
        RequestBody description = RequestBody.create(MediaType.parse("text/plane"), "dog");

        return RetrofitBuilder.responseHandler(API_SERVICE.uploadAnimalImage(animalId, description, filePart));
    }

    public Animal createAnimal(Animal animal) {
        return RetrofitBuilder.responseHandler(API_SERVICE.createAnimal(animal));
    }

    public Animal updateAnimal(Animal animal) {
        return RetrofitBuilder.responseHandler(API_SERVICE.updateAnimal(animal));
    }

    public List<Animal> getAnimalsByStatus(String status) {
        return RetrofitBuilder.responseHandler(API_SERVICE.getAnimalsByStatus(status));
    }

    public Animal getAnimalById(long animalId) {
        return RetrofitBuilder.responseHandler(API_SERVICE.getAnimalById(animalId));
    }

    public ApiResponse updateAnimalWithForm(long animalId, String name, String status) {
        return RetrofitBuilder.responseHandler(API_SERVICE.updateAnimalWithForm(animalId, name, status));
    }

    public ApiResponse deleteAnimal(long animalId) {
        return RetrofitBuilder.responseHandler(API_SERVICE.deleteAnimal(animalId));
    }

    //Store
    public HashMap<String, String> getPetInventories() {
        return RetrofitBuilder.responseHandler(API_SERVICE.getPetInventories());
    }

    public Order createAnOrder(Order order) {
        return RetrofitBuilder.responseHandler(API_SERVICE.createAnOrder(order));
    }

    public Order getOrderById(long orderId){
        return RetrofitBuilder.responseHandler(API_SERVICE.getOrderById(orderId));
    }

    public ApiResponse deleteOrderById(long orderId) {
        return RetrofitBuilder.responseHandler(API_SERVICE.deleteOrderById(orderId));
    }

    //User
    public ApiResponse createUsersFromList(List<User> users) {
        return RetrofitBuilder.responseHandler(API_SERVICE.createUsersFromList(users));
    }

    public User getUserByName(String username) {
        return RetrofitBuilder.responseHandler(API_SERVICE.getUserByName(username));
    }

    public ApiResponse updateUser(User user) {
        return RetrofitBuilder.responseHandler(API_SERVICE.updateUser(user.getUserName(), user));
    }

    public ApiResponse deleteUserByName(String username) {
        return RetrofitBuilder.responseHandler(API_SERVICE.deleteUserByName(username));
    }

    public ApiResponse loginUser(String username, String password) {
        return RetrofitBuilder.responseHandler(API_SERVICE.loginUser(username, password));
    }

    public ApiResponse logoutUser() {
        return RetrofitBuilder.responseHandler(API_SERVICE.logoutUser());
    }

    public ApiResponse createUsersFromArray(User[] users) {
        return RetrofitBuilder.responseHandler(API_SERVICE.createUsersFromArray(users));
    }

    public ApiResponse createUser(User user) {
        return RetrofitBuilder.responseHandler(API_SERVICE.createUser(user));
    }
}