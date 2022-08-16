package com.compile.testcompilerspring.procesing;

import org.junit.jupiter.api.Test;

class ReaderCSV_MasterTest {

    @Test
    void testCreateClass(){
        String path = "\\\\TECH-1C-04\\Test\\master_test.csv";

        ReaderCSV_Master csv_to_json = new ReaderCSV_Master(path);
        String JSON_String = csv_to_json.getJSON_String();

    }

}