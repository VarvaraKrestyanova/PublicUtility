package com.sendMessagePartTwo;

import com.github.javafaker.Faker;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;

import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

public class DataReader {

    private static final String filePath = "src/test/resources/message.json";

    @DataProvider
    public static Object[][] sender() {    //args: String login, String password

        Object[][] sendData = new Object[0][];
        try {
            //считывание файла
            FileReader reader = new FileReader(filePath);

            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);

            //получение строки из объекта
            String login = (String) jsonObject.get("login");

            String password = (String) jsonObject.get("password");

            sendData = new Object[1][2];
            sendData[0][0] = login;
            sendData[0][1] = password;


        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }

        return sendData;
    }

    //создание статиков для BeforeMethod

    static String senderLogin;
    static String senderPassword;

    public static String getSenderLogin() {
        if(senderLogin == null){
            senderLogin = (String) sender()[0][0];
        }
        return senderLogin;
    }

    public static String getSenderPassword() {
        if (senderPassword == null){
            senderPassword = (String) sender()[0][1];
        }
        return senderPassword;
    }



    @DataProvider
    public Object[][] message() {

        Object[][] message = new Object[0][0];
        try {
            //считывание файла
            FileReader reader = new FileReader(filePath);

            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);

            //создание фейкера
            Faker faker = new Faker();

            //получение массива
            JSONArray messagesArray = (JSONArray) jsonObject.get("messages");
            int messagesCount = messagesArray.size();
            Iterator i = messagesArray.iterator();

            message = new Object[messagesCount][4];
            int y = 0;
            for (int z = 0; z < messagesCount; z++) {
                JSONObject messagesObj = (JSONObject) i.next();
                message[y][0] = messagesObj.get("recipient");
                String id = faker.idNumber().valid();
                message[y][1] = id + ": " + messagesObj.get("title");
                String randomFunnyName = faker.funnyName().name();
                message[y][2] = messagesObj.get("body") + " Are you " + randomFunnyName + "?";
                message[y][3] = id;
                y += 1;
            }

        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }

        return message;
    }

}