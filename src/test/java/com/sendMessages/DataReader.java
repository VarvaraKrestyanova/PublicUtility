package com.sendMessages;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

public class DataReader {

    private static final String filePath = "src/test/resources/message.json";

    @DataProvider
    public Object[][] sender() {    //args: String login, String password

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

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sendData;
    }

    @DataProvider
    public Object[][] message() {

        Object[][] message = new Object[0][0];
        try {
            //считывание файла. как избежать дублирования?
            FileReader reader = new FileReader(filePath);

            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);

            // получение массива
            JSONArray messagesArray = (JSONArray) jsonObject.get("messages");
            int messagesCount = messagesArray.size();
            System.out.println(messagesCount);
            String recipients = "";
            String titles = "";
            String bodies = "";
            Iterator i = messagesArray.iterator();

            message = new Object[3][messagesCount];
            int y = 0;
            for (int z = 0; z < messagesCount; z++) {
                JSONObject messagesObj = (JSONObject) i.next();
                message[0][y] = messagesObj.get("recipient");
                message[1][y] = messagesObj.get("title");
                message[2][y] = messagesObj.get("body");
                y += 1;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return message;
    }

}

            /*while (i.hasNext()){
                JSONObject messagesObj = (JSONObject) i.next();
                recipients += (String) messagesObj.get("recipient") + ",";
                titles += (String) messagesObj.get("title") + ",";
                bodies += (String) messagesObj.get("body") + ",";
                System.out.println(recipients);
                System.out.println(titles);
                System.out.println(bodies);
            }*/
