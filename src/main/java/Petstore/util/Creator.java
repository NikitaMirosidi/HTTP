package Petstore.util;

import Petstore.model.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Creator {

    Scanner scanner;

    public Creator(Scanner scanner) {
        this.scanner = scanner;
    }

    public User userCreator() {

        long id;

        while (true) {
            System.out.println("Укажите ID пользователя\n");

            try {
                id = scanner.nextLong();
                break;
            }
            catch (InputMismatchException e) {
                System.out.println("ID указан неверно. Поробуйте еще раз\n");
                scanner.next();
            }
        }

        System.out.println("Укажите ник пользователя\n");
        String userName = scanner.next();

        System.out.println("Укажите имя пользователя\n");
        String firstName = scanner.next();

        System.out.println("Укажите фамилию пользователя\n");
        String lastName = scanner.next();

        System.out.println("Укажите e-mail пользователя\n");
        String eMail = scanner.next();

        System.out.println("Укажите пароль для пользователя\n");
        String password = scanner.next();

        System.out.println("Укажите номер телефона пользователя\n");
        String phone = scanner.next();

        int userStatus;

        while(true) {
            System.out.println("Укажите статус пользователя\n");

            try {
                userStatus = scanner.nextInt();
                break;
            }
            catch (InputMismatchException e) {
                System.out.println("Статус указан неверно. Поробуйте еще раз\n");
                scanner.next();
            }
        }

        return User.builder()
                .id(id)
                .userName(userName)
                .firstName(firstName)
                .lastName(lastName)
                .eMail(eMail)
                .password(password)
                .phone(phone)
                .userStatus(userStatus)
                .build();
    }

    public Order orderCreator() {

        long id;

        while(true) {

            System.out.println("Укажите ID заказа\n");

            try {
                id = scanner.nextLong();
                break;
            }
            catch (InputMismatchException e) {
                System.out.println("ID указан неверно. Поробуйте еще раз\n");
                scanner.next();
            }
        }

        long petId;

        while(true) {

            System.out.println("Укажите ID животного\n");

            try {
                petId = scanner.nextLong();
                break;
            }
            catch (InputMismatchException e) {
                System.out.println("ID указан неверно. Поробуйте еще раз\n");
                scanner.next();
            }
        }

        int quantity;

        while (true) {

            System.out.println("Укажите количество животных\n");

            try {
                quantity = scanner.nextInt();
                break;
            }
            catch (InputMismatchException e) {
                System.out.println("Количество указано неверно. Поробуйте еще раз\n");
                scanner.next();
            }
        }

        System.out.println("Укажите дату отправки\n");
        String shipDate = scanner.next();

        System.out.println("Укажите статус заказа (placed / approved / delivered)\n");
        String status = scanner.next();

        boolean complete;

        while (true) {

            System.out.println("Укажите состояние выполнения заказа (true / false)\n");

            try {
                complete = scanner.nextBoolean();
                break;
            }
            catch (InputMismatchException e) {
                System.out.println("Состояние выполнения указано неверно. Поробуйте еще раз\n");
                scanner.next();
            }
        }

        return Order.builder()
                .id(id)
                .petId(petId)
                .quantity(quantity)
                .shipDate(LocalDateTime.now().toString())
                .status(status)
                .complete(complete)
                .build();
    }

    public Animal animalCreator() {

        long id;

        while(true) {

            System.out.println("Укажите ID животного\n");

            try {
                id = scanner.nextLong();
                break;
            }
            catch (InputMismatchException e) {
                System.out.println("ID указан неверно. Поробуйте еще раз\n");
                scanner.next();
            }
        }

        long categoryId;

        while(true) {

            System.out.println("Укажите ID категории животного\n");

            try {
                categoryId = scanner.nextLong();
                break;
            }
            catch (InputMismatchException e) {
                System.out.println("ID указан неверно. Поробуйте еще раз\n");
                scanner.next();
            }
        }

        System.out.println("Укажите название категории животного\n");
        String categoryName = scanner.next();

        Category category = Category.builder()
                .id(categoryId)
                .name(categoryName)
                .build();

        System.out.println("Укажите название животного\n");
        String name = scanner.next();

        System.out.println("Добавьте ссылки на фото животного\n");
        List<String> photoUrls = new ArrayList<>();
        boolean a = true;

        while(a) {

            System.out.println("1 - добавить ссылку\n" +
                                "2 - завершить добавление ссылок\n");

            String i = scanner.next();

            switch (i) {
                case "1":
                    System.out.println("Укажите ссылку\n");
                    photoUrls.add(scanner.next());
                    break;
                case "2":
                    a = false;
                    break;
                default:
                    System.out.println("Поддерживаемая функция не выбрана\n" +
                                        "Попробуйте еще раз\n");
                    break;
            }
        }

        System.out.println("Добавьте теги\n");
        List<Tag> tags = new ArrayList<>();
        a = true;

        while(a) {

            System.out.println("1 - добавить тег\n" +
                                "2 - завершить добавление тегов\n");

            String i = scanner.next();

            switch (i) {
                case "1":
                    long tagId;

                    while(true) {

                        System.out.println("Укажите ID тега\n");

                        try {
                            tagId = scanner.nextLong();
                            break;
                        }
                        catch (InputMismatchException e) {
                            System.out.println("ID указан неверно. Поробуйте еще раз\n");
                            scanner.next();
                        }
                    }

                    System.out.println("Укажите название тега\n");
                    String tagName = scanner.next();

                    Tag tag = Tag.builder()
                            .id(tagId)
                            .name(tagName)
                            .build();

                    tags.add(tag);
                    break;
                case "2":
                    a = false;
                    break;
                default:
                    System.out.println("Поддерживаемая функция не выбрана\n" +
                                        "Попробуйте еще раз\n");
                    break;
            }
        }

        System.out.println("Укажите статус животного (available / pending / sold)\n");
        String status = scanner.next();

        return Animal.builder()
                .id(id)
                .category(category)
                .name(name)
                .photoUrls(photoUrls)
                .tags(tags)
                .status(status)
                .build();
    }
}