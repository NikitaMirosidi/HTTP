package Petstore.repository;

import Petstore.model.Animal;
import Petstore.model.ApiResponse;
import Petstore.model.Order;
import Petstore.model.User;
import jdk.jfr.MetadataDefinition;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;
import java.util.Map;

public interface APIService {

    //pet
    @Multipart
    @POST("pet/{petId}/uploadImage")
    Call<ApiResponse> uploadAnimalImage(@Path("petId") long petId,
                                        @Part("description") RequestBody description,
                                        @Part MultipartBody.Part filePart);

    @POST("pet")
    Call<Animal> createAnimal(@Body Animal animal);

    @PUT("pet")
    Call<Animal> updateAnimal(@Body Animal animal);

    @GET("pet/findByStatus")
    Call<List<Animal>> getAnimalsByStatus(@Query("status") String status);

    @GET("pet/{petId}")
    Call<Animal> getAnimalById(@Path("petId") long petId);

    @FormUrlEncoded
    @POST("pet/{petId}")
    Call<ApiResponse> updateAnimalWithForm(@Path("petId") long petId,
                                           @Field("name") String name,
                                           @Field("status") String status);

    @Headers("api_key: delete")
    @DELETE("pet/{petId}")
    Call<ApiResponse> deleteAnimal(@Path("petId") long petId);

    //store
    @GET("store/inventory")
    Call<Object> getPetInventories();

    @POST("store/order")
    Call<Order> createAnOrder(@Body Order order);

    @GET("store/order/{orderId}")
    Call<Order> getOrderById(@Path("orderId") long orderId);

    @DELETE("store/order/{orderId}")
    Call<ApiResponse> deleteOrderById(@Path("orderId") long orderId);


    //user
    @POST("user/createWithList")
    Call<ApiResponse> createUsersFromList(@Body List<User> users);

    @GET("user/{username}")
    Call<User> getUserByName(@Path("username") String userName);

    @PUT("user/{username}")
    Call<ApiResponse> updateUser(@Path("username") String userName,
                                 @Body User user);

    @DELETE("user/{username}")
    Call<ApiResponse> deleteUserByName(@Path("username") String userName);

    @GET("user/login")
    Call<ApiResponse> loginUser(@Query("username") String username,
                                @Query("password") String password);

    @GET("user/logout")
    Call<ApiResponse> logoutUser();

    @POST("user/createWithArray")
    Call<ApiResponse> createUsersFromArray(@Body User[] users);

    @POST("user")
    Call<ApiResponse> createUser(@Body User user);
}