package com.herokuapp;

import lombok.Data;

import java.util.List;

@Data
public class DropdownPageData {

    String title;
    List<DropdownValues> values;

}
