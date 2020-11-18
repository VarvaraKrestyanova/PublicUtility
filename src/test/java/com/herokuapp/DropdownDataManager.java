package com.herokuapp;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.nio.file.Paths;

public class DropdownDataManager {

    //DROPDOWN PAGE DATA------------------------------

    private static String filePath = "src/test/resources/dropdownList";
    static ObjectMapper mapper = new ObjectMapper();
    static DropdownPageData dropdownPageData;

    static {
        try {
            dropdownPageData = getDropdownData();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public DropdownDataManager() throws IOException {
    }


    private static DropdownPageData getDropdownData() throws IOException {
        dropdownPageData = mapper.readValue(Paths.get(filePath).toFile(), DropdownPageData.class);
        return dropdownPageData;
    }

    @DataProvider
    public Object[][] dropdownValuesFromFile() throws IOException{

        Object[][] valuesData = new Object[dropdownPageData.values.size()][1];
        for(int i = 0; i < dropdownPageData.getValues().size(); i++){
            DropdownValues v = dropdownPageData.getValues().get(i);
            valuesData[i][0] = v;
        }
        return valuesData;
    }

    @DataProvider
    public Object[][] dropdownTitleFromFile() throws IOException{
        dropdownPageData = getDropdownData();
        Object[][] pageData = new Object[1][1];
        pageData[0][0] = dropdownPageData.getTitle();
        return pageData;
    }

}
