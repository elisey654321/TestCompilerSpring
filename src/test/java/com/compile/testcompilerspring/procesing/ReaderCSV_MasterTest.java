package com.compile.testcompilerspring.procesing;

import org.junit.jupiter.api.Test;

class ReaderCSV_MasterTest {

    @Test
    void testCreateClass(){

        String path = "\\\\TECH-1C-04\\Test\\masterParse\\Master-20220816.csv";
        ReaderCSV_Master csv_to_json16 = new ReaderCSV_Master(path);
        csv_to_json16.getJSON_String();

        path = "\\\\TECH-1C-04\\Test\\masterParse\\Master-20220817.csv";
        ReaderCSV_Master csv_to_json17 = new ReaderCSV_Master(path);
        csv_to_json17.getJSON_String();

        path = "\\\\TECH-1C-04\\Test\\masterParse\\Master-20220818.csv";
        ReaderCSV_Master csv_to_json18 = new ReaderCSV_Master(path);
        csv_to_json18.getJSON_String();

    }

}