package com.gmailTest;

import lombok.Data;
import lombok.experimental.Accessors;
import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Data
@Accessors(chain = true)
public class JsonMessageParser {

    @DataProvider
    public Object[] jsonMessageParser() throws IOException {
        Path path = Paths.get("src/test/resources/message.json");
        List<String> data = Files.readAllLines(path);

        Object[] message = new Object[2];
        message[0] = data.get(1);
        message[1] = data.get(2);

        return message;
    }
}
