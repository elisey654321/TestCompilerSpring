package com.compile.testcompilerspring.data;

import com.compile.testcompilerspring.data.enums.TypesMovement;
import com.compile.testcompilerspring.data.virtualTables.GoodsWarehousesRemains;
import lombok.*;
import org.hibernate.Session;

import javax.persistence.*;
import java.util.Date;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class GoodsWarehouses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @NonNull
    Date period;

    @OneToOne(cascade=CascadeType.ALL)
    @NonNull
    @JoinColumn(name = "item_name")
    Item item;

    @NonNull
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "warehouses_ID")
    Warehouses warehouses;

    @NonNull
    Integer count;

    @NonNull
    TypesMovement typeMovement;

    public final void saveInDataBase(){
        Session session = HibernateUtils.getSession();
        session.beginTransaction();
        GoodsWarehousesRemains goodsWarehousesRemains = new GoodsWarehousesRemains();
        goodsWarehousesRemains.setCount((typeMovement == TypesMovement.arrival)?count:-count,session,this);
        session.save(this);
        session.getTransaction().commit();
    }
}
