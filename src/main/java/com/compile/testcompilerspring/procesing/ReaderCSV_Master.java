package com.compile.testcompilerspring.procesing;


import com.compile.testcompilerspring.data.Call;
import com.compile.testcompilerspring.data.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.event.spi.PostInsertEventListener;

import java.io.*;
import java.util.ArrayList;

public class ReaderCSV_Master {

    private String separator = ",";
    private String path = null;

    public ReaderCSV_Master(String path) {
        this.path = path;
    }

    public String getJSON_String(){
        String JSON = "";
        try {

            BufferedReader bufferedReader = new BufferedReader(new FileReader(this.path));
            String line = "";
            while ((line = bufferedReader.readLine()) != null){
                ArrayList<String> lineArr = readLine(line);
                Call call = getCallFromArrList(lineArr);
                System.out.println(call);
                Session session = HibernateUtils.getSession();
                session.beginTransaction();
                session.saveOrUpdate(call);
                session.getTransaction().commit();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return JSON;
    }

    private ArrayList<String> readLine(String line){
        ArrayList<String> arrayList = new ArrayList<>();
        Integer beginChar = 0;
        Integer bracketOpen = 0;

        for (int i = 0; i < line.length()-this.separator.length(); i++) {
            if (line.startsWith("\"", i)) {
                bracketOpen++;
            }

            if (line.startsWith(this.separator, i)){
                if (bracketOpen % 2 == 0) {
                    String subSting = line.substring(beginChar+1, i).replace("\"","");
                    arrayList.add(subSting);
                    beginChar = i;
                }
            }
        }

//        System.out.println(arrayList);
        return arrayList;
    }

    private Call getCallFromArrList(ArrayList<String> lineArr) {
        Call call = Call.builder()
                .Number1(lineArr.get(1))
                .Number2(lineArr.get(2))
                .calltouch(lineArr.get(5))
                .date1(lineArr.get(9))
                .date2(lineArr.get(10))
                .date3(lineArr.get(11))
                .duration1(lineArr.get(12))
                .duration2(lineArr.get(13))
                .condition(lineArr.get(14))
                .id(lineArr.get(16))
                .build();
        return call;
    }

}
