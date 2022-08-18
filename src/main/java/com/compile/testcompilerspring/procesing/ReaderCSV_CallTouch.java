package com.compile.testcompilerspring.procesing;

import com.compile.testcompilerspring.data.Communication;
import com.compile.testcompilerspring.data.HibernateUtils;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.context.annotation.Lazy;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ReaderCSV_CallTouch {

    private static String path = "\\\\TECH-1C-04\\Test\\Calltouch 15-18_08_2022.csv";

    private ReaderCSV_CallTouch() {
    }

    public static void saveFile() throws IOException {
        FileWriter writer = new FileWriter("\\\\TECH-1C-04\\Test\\Calltouch 15-18_08_2022.txt");
        Session session = HibernateUtils.getSession();
        session.beginTransaction();

        List<Object[]> data = session.createSQLQuery(getQuery())
                .addScalar("number1", StandardBasicTypes.STRING)
                .addScalar("number2", StandardBasicTypes.STRING)
                .addScalar("date3", StandardBasicTypes.STRING)
                .addScalar("text", StandardBasicTypes.STRING)
                .addScalar("duration", StandardBasicTypes.INTEGER)
                .list();
        for (Object[] row : data) {
            StringBuilder builder = new StringBuilder();
            Optional<Object> optionalR = Optional.of(row);
            if (optionalR.isPresent()) {
                builder.append(Optional.ofNullable(row[0]).orElse("").toString());
                builder.append(",");
                builder.append(Optional.ofNullable(row[1]).orElse("").toString());
                builder.append(",");
                builder.append(Optional.ofNullable(row[2]).orElse("").toString());
                builder.append(",");
                builder.append(Optional.ofNullable(row[3]).orElse("").toString());
                builder.append(",");
                builder.append(Optional.ofNullable(row[4]).orElse("").toString());
                builder.append("\n");

                writer.write(builder.toString());
            }
        }
        writer.close();
        session.getTransaction().commit();

    }

    private static String getQuery() {
        return "select c.number1,\n" +
                "       call.number2,\n" +
                "       MIN(call.date3) as date3,\n" +
                "       c.text,\n" +
                "       c.duration\n" +
                "from call\n" +
                "         left join communication c on call.number1 = c.number1\n" +
                "where (call.number2 = '758' or call.number2 = '781')\n" +
                "  and (call.date3 like '2022-08-15%' or call.date3 like '2022-08-16%')\n" +
                "  and call.duration2 != '0'\n" +
                "group by\n" +
                "    c.number1,\n" +
                "    call.number2,\n" +
                "    c.text,\n" +
                "    c.duration";
    }

    public static void readFile(){
        try {
            getDataFromFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static ArrayList<Communication> getDataFromFile() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF-8"));
        String line = "";
        reader.readLine();

        while ((line = reader.readLine()) != null){
            Communication communication = getCommunicationFromLine(line);
            Session session = HibernateUtils.getSession();
            session.beginTransaction();
            session.save(communication);
            session.getTransaction().commit();
            System.out.println(communication);
        }

        return new ArrayList<>();
    }

    private static Communication getCommunicationFromLine(String line) {

        Integer indexSeparator = 0;

        ArrayList<String> strings = new ArrayList<>();

        while (line.indexOf(";") != -1){
            indexSeparator = line.indexOf(";");
            strings.add(line.substring(0,indexSeparator));
            line = line.substring(indexSeparator+1);
        }
        strings.add(line);

        String number1 = strings.get(1);

        String strDuration = strings.get(4);
        Integer minute = Integer.valueOf(strDuration.substring(0,2));
        Integer second = Integer.valueOf(strDuration.substring(3,5));
        second += minute*60;

        String phrase = strings.get(5);
        phrase = phrase.substring(0,phrase.length()>255?255:phrase.length());
        Communication communication = Communication.builder()
                .number1(number1)
                .duration(second)
                .text(phrase)
                .build();
        return communication;
    }

}
