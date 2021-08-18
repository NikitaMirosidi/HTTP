package Petstore;

import Petstore.service.UserInterface;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        String url = "https://petstore.swagger.io/v2/";
        UserInterface userInterface = new UserInterface(url);
        userInterface.mainController();
    }
}