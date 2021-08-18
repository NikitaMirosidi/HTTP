package Petstore.service;

import Petstore.model.*;
import Petstore.repository.PetStoreManager;
import Petstore.util.Creator;
import java.util.*;


public class UserInterface {

    private final Scanner SCANNER;
    private final PetStoreManager MANAGER;
    private final Creator CREATOR;

    public UserInterface(String baseUrl) {
        this.SCANNER = new Scanner(System.in);
        this.MANAGER = new PetStoreManager(baseUrl);
        this.CREATOR = new Creator(this.SCANNER);
    }

    public void mainController() {

        boolean a = true;

        while (a) {

            System.out.println("\nГлавное меню:\n" +
                                "1 - работа с User\n" +
                                "2 - работа с Store\n" +
                                "3 - работа с Pet\n" +
                                "0 - завершение приложения\n");

            String i = SCANNER.next();

            switch (i) {
                case "1":
                    userController();
                    break;
                case "2":
                    orderController();
                    break;
                case "3":
                    petController();
                    break;
                case "0":
                    a = false;
                    System.out.println("До скорых встреч\n");
                    break;
                default:
                    System.out.println("Поддерживаемая функция не выбрана\n" +
                                        "Попробуйте еще раз\n");
                    break;
            }
        }

        SCANNER.close();
    }

    private void userController(){

        boolean a = true;

        while (a) {

            System.out.println("\nМеню <Пользователи>:\n" +
                                "1 - создание пользователя\n" +
                                "2 - создание списка пользователей из переданного массива\n" +
                                "3 - создание списка пользователей из переданного массив\n" +
                                "4 - получение пользователя по имени\n" +
                                "5 - обновление пользователя\n" +
                                "6 - удаление пользователя по имени\n" +
                                "7 - вход в систему\n" +
                                "8 - выход из системы\n" +
                                "0 - возврат в предыдущее меню\n");


            String i = SCANNER.next();

            switch (i) {
                case "1":
                    System.out.println(MANAGER.createUser(CREATOR.userCreator()));
                    break;
                case "2":
                    List<User> list = new ArrayList<>();
                    list.add(CREATOR.userCreator());
                    list.add(CREATOR.userCreator());
                    System.out.println(MANAGER.createUsersFromList(list));
                    break;
                case "3":
                    User[] users = new User[]{CREATOR.userCreator(), CREATOR.userCreator()};
                    System.out.println(MANAGER.createUsersFromArray(users));
                    break;
                case "4":
                    System.out.println("Укажите имя пользователя\n");
                    i = SCANNER.next();

                    try {
                        System.out.println(MANAGER.getUserByName(i));
                    }
                    catch (RuntimeException e) {
                        System.out.println("Пользователь <" + i + "> не найден\n1");
                    }

                    break;
                case "5":
                    System.out.println(MANAGER.updateUser(CREATOR.userCreator()));
                    break;
                case "6":
                    System.out.println("Укажите имя пользователя\n");
                    i = SCANNER.next();

                    try {
                        System.out.println(MANAGER.deleteUserByName(i));
                    }
                    catch (RuntimeException e) {
                        System.out.println("Пользователь <" + i + "> не найден\n");
                    }

                    break;
                case "7":
                    System.out.println("Укажите имя пользователя\n");
                    String name = SCANNER.next();
                    System.out.println("Укажите пароль\n");
                    String password = SCANNER.next();
                    System.out.println(MANAGER.loginUser(name, password));
                    break;
                case "8":
                    System.out.println(MANAGER.logoutUser());
                    break;
                case "0":
                    a = false;
                    break;
                default:
                    System.out.println("Поддерживаемая функция не выбрана\n" +
                                        "Попробуйте еще раз\n");
                    break;
            }
        }
    }

    private void orderController() {

        boolean a = true;

        while (a) {

            System.out.println("\nМеню <Заказы>:\n" +
                                "1 - размещение заказа на животное\n" +
                                "2 - получение заказа по ID\n" +
                                "3 - удаление заказа по ID\n" +
                                "4 - получение списка статусов всех животных\n" +
                                "0 - возврат в предыдущее меню\n");

            String i = SCANNER.next();

            switch (i) {
                case "1":
                    System.out.println(MANAGER.createAnOrder(CREATOR.orderCreator()));
                    break;
                case "2":
                    System.out.println("Укажмте ID заказа\n");

                    try {
                        long l1 = SCANNER.nextLong();
                        System.out.println(MANAGER.getOrderById(l1));
                    }
                    catch (InputMismatchException ex) {
                        System.out.println("ID указан неверно\n");
                        SCANNER.next();
                    }
                    catch (RuntimeException e) {
                        System.out.println("Заказ не найден\n");
                    }

                    break;
                case "3":
                    System.out.println("Укажмте ID заказа\n");

                    try {
                        long l2 = SCANNER.nextLong();
                        System.out.println(MANAGER.deleteOrderById(l2));
                    }
                    catch (InputMismatchException ex) {
                        System.out.println("ID указан неверно\n");
                        SCANNER.next();
                    }
                    catch (RuntimeException e) {
                        System.out.println("Заказ не найден\n");
                    }

                    break;
                case "4":
                    System.out.println(MANAGER.getPetInventories());
                    break;
                case "0":
                    a = false;
                    break;
                default:
                    System.out.println("Поддерживаемая функция не выбрана\n" +
                            "Попробуйте еще раз\n");
                    break;
            }
        }
    }

    private void petController() {

        boolean a = true;

        while (a) {

            System.out.println("\nМеню <Животные>:\n" +
                                "1 - создание животного\n" +
                                "2 - загрузка изображения животного\n" +
                                "3 - получение животного по ID\n" +
                                "4 - получение списка животных по статусу\n" +
                                "5 - обновление животного\n" +
                                "6 - обновление имени и статуса животного по ID\n" +
                                "7 - удаление животного по ID\n" +
                                "0 - возврат в предыдущее меню\n");

            String i = SCANNER.next();

            switch (i) {
                case "1":
                    System.out.println(MANAGER.createAnimal(CREATOR.animalCreator()));
                    break;
                case "2":
                    System.out.println("Укажите ID животного\n");
                    long animalId1;

                    try {
                        animalId1 = SCANNER.nextLong();
                    }
                    catch (InputMismatchException e) {
                        System.out.println("ID указан неверно\n");
                        SCANNER.next();
                        break;
                    }

                    System.out.println("Укажите путь к изображеию\n");
                    String imageUrl = SCANNER.next();
                    System.out.println(MANAGER.uploadAnimalImage(animalId1, imageUrl));
                    break;
                case "3":
                    System.out.println("Укажите ID животного\n");
                    long animalId2;

                    try {
                        animalId2 = SCANNER.nextLong();
                        System.out.println(MANAGER.getAnimalById(animalId2));
                    }
                    catch (InputMismatchException e) {
                        System.out.println("ID указан неверно\n");
                        SCANNER.next();
                    }
                    catch (RuntimeException ex) {
                        System.out.println("Животное не найдено\n");
                    }

                    break;
                case "4":
                    System.out.println("Укажите статус животного (available / pending / sold)\n");
                    String animalStatus = SCANNER.next();
                    System.out.println(MANAGER.getAnimalsByStatus(animalStatus));
                    break;
                case "5":
                    System.out.println(MANAGER.updateAnimal(CREATOR.animalCreator()));
                    break;
                case "6":
                    System.out.println("Укажите ID животного\n");
                    long animalId3;

                    try {
                        animalId3 = SCANNER.nextLong();
                    }
                    catch (InputMismatchException e) {
                        System.out.println("ID указан неверно\n");
                        SCANNER.next();
                        break;
                    }

                    System.out.println("Укажите название животного\n");
                    String animalName = SCANNER.next();
                    System.out.println("Укажите статус животного (available / pending / sold)\n");
                    String animalStatus2 = SCANNER.next();
                    System.out.println(MANAGER.updateAnimalWithForm(animalId3, animalName, animalStatus2));
                    break;
                case "7":
                    System.out.println("Укажите ID животного\n");
                    long animalId4;

                    try {
                        animalId4 = SCANNER.nextLong();
                        System.out.println(MANAGER.deleteAnimal(animalId4));
                    }
                    catch (InputMismatchException e) {
                        System.out.println("ID указан неверно\n");
                        SCANNER.next();
                    }
                    catch (RuntimeException ex) {
                        System.out.println("Животное не найдено\n");
                    }

                    break;
                case "0":
                    a = false;
                    break;
                default:
                    System.out.println("Поддерживаемая функция не выбрана\n" +
                                        "Попробуйте еще раз\n");
                    break;
            }
        }
    }
}