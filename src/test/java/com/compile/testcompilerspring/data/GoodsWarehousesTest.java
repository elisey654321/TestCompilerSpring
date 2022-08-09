package com.compile.testcompilerspring.data;

import com.compile.testcompilerspring.data.enums.TypesMovement;
import org.hibernate.Session;
import org.junit.jupiter.api.Test;

import java.util.Date;

class GoodsWarehousesTest {
    @Test
    void creteData(){
        Session session = HibernateUtils.getSession();
        session.beginTransaction();

        Item ball = Item.builder()
                .name("ball")
                .build();

        Warehouses warehouses = Warehouses.builder()
                .name("Warehouses1")
                .build();

        GoodsWarehouses arrival1 = GoodsWarehouses.builder()
                .item(ball)
                .count(1)
                .period(new Date())
                .warehouses(warehouses)
                .typeMovement(TypesMovement.arrival)
                .build();
        session.save(arrival1);
        session.getTransaction().commit();

//
//        try {
//            arrival1.saveInDataBase();
//        } catch (CloneNotSupportedException e) {
//            throw new RuntimeException(e);
//        }


    }
}