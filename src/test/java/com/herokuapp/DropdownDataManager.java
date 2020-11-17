package com.herokuapp;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.nio.file.Paths;

public class DropdownDataManager {

    //DROPDOWN PAGE DATA------------------------------

    private static String filePath = "src/test/resources/dropdownList";
    ObjectMapper mapper = new ObjectMapper();
    DropdownPageData dropdownPageData = getDropdownData();

    public DropdownDataManager() throws IOException {
    }


    private DropdownPageData getDropdownData() throws IOException {
        DropdownPageData dropdownPageData = mapper.readValue(Paths.get(filePath).toFile(), DropdownPageData.class);
        return dropdownPageData;
    }

    @DataProvider
    public Object[][] dropdownValuesFromFile() throws IOException{

        Object[][] valuesData = new Object[dropdownPageData.values.size()][1];
        for(int i = 0; i < dropdownPageData.values.size(); i++){
            DropdownValues v = dropdownPageData.values.get(i);
            valuesData[i][0] = v;
        }
        return valuesData;
    }

    @DataProvider
    public Object[][] dropdownTitleFromFile() throws IOException{
        DropdownPageData dropdownPageData = getDropdownData();
        Object[][] pageData = new Object[1][1];
        pageData[0][0] = dropdownPageData.title;
        return pageData;
    }

    //FOOTER DATA--------------------------
    @DataProvider
    private Object[][] parseLocaleData() {
        return new Object[][]{
                {new DropdownListPageObject()}//,
                //{new ()}
        };
    }

}
