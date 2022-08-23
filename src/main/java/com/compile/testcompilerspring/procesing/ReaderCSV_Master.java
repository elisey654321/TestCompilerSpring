package com.compile.testcompilerspring.procesing;


import com.compile.testcompilerspring.data.Call;
import com.compile.testcompilerspring.data.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.event.spi.PostInsertEventListener;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

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
//                System.out.println(call);
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

        Date date1 = null;
        Date date2 = null;
        Date date3 = null;

        try {
            date1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(lineArr.get(9));
            date2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(lineArr.get(10));
            date3 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(lineArr.get(11));
        } catch (ParseException e) {

        }

        Call call = Call.builder()
                .Number1(lineArr.get(1))
                .Number2(lineArr.get(2))
                .calltouch(lineArr.get(5))
                .date1(Optional.ofNullable(date1).orElse(new Date()))
                .date2(Optional.ofNullable(date2).orElse(new Date()))
                .date3(Optional.ofNullable(date3).orElse(new Date()))
                .duration1(Integer.parseInt(lineArr.get(12)))
                .duration2(Integer.parseInt(lineArr.get(13)))
                .condition(lineArr.get(14))
                .id(lineArr.get(16))
                .build();
        return call;
    }

}
