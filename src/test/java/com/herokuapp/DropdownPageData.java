package com.herokuapp;

import lombok.Data;

import java.util.List;

@Data
public class DropdownPageData {

    String title;
    List<DropdownValues> values;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<DropdownValues> getValues() {
        return values;
    }

    public void setValues(List<DropdownValues> values) {
        this.values = values;
    }



}
