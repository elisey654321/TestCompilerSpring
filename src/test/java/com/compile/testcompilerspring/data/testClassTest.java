package com.compile.testcompilerspring.data;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Test;

import javax.persistence.Entity;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.*;
import java.util.function.Function;

class TestClassTest {

    @Test
    void testSet(){

//        HashSet<Integer> eee = new HashSet<>();
//        eee.add(123);
//        eee.add(12311);
//        eee.add(123);
//
//        eee.stream().forEach(System.out::println);

//        HashMap<String,Integer> stringIntegerHashMap = new HashMap<>();
//        stringIntegerHashMap.put("222",123213);
//        stringIntegerHashMap.put("222111",1123213);
//
//        System.out.println(stringIntegerHashMap.get("222"));

        TreeMap<Integer,String> dsad = new TreeMap<>();
        dsad.put(12321,"tet111");
        dsad.put(1,"tet33");
        dsad.put(21,"te11t");

        Set<Integer> keys = dsad.keySet();

//        for (int i = 0; i < keys.size(); i++) {
            keys.stream().forEach(x -> System.out.println(dsad.get(x)));
//        }

    }

    private @NotNull ArrayList<Integer> deleteElementsFromArrayList(@NotNull ArrayList<Integer> list, Integer firstCharacter, Integer howMuchDelete) {
        howMuchDelete--;

        Object[] test = new Object[list.size()];
        for (int i = 0; i < list.size(); i++) {
            test[i] = list.get(i);
        }

        Integer length = test.length;
        int numMoved = length - firstCharacter - 1;
        System.arraycopy(test, firstCharacter + 1 + howMuchDelete, test, firstCharacter, numMoved - howMuchDelete);

        list = new ArrayList<>();

        for (int i = 0; i < test.length - howMuchDelete - 1; i++) {
            Optional<Object> o = Optional.ofNullable(test[i]);
            if (o.get() instanceof Integer){
                list.add((Integer) o.get());
            }
        }
        return list;
    }


}