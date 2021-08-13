package Petstore.util;

import lombok.SneakyThrows;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitBuilder {

    public static <T> T getRetrofit(String baseUrl, Class <T> apiClass){
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(apiClass);
    }

    @SneakyThrows
    public static <T> T responseHandler(Call<T> method){

        Response<T> response = method.execute();

        if (response.isSuccessful()) {
            return response.body();
        }
        else {
            String errorMsg = "HTTP code: " + response.code() + " Message: " + response.errorBody().string();
            System.out.println(errorMsg);
            throw new RuntimeException(errorMsg);
        }
    }
}