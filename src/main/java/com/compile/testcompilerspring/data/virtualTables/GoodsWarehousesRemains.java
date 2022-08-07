package com.compile.testcompilerspring.data.virtualTables;

import com.compile.testcompilerspring.data.GoodsWarehouses;
import com.compile.testcompilerspring.data.TypesMovement;
import lombok.*;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import javax.persistence.*;
import java.util.ArrayList;
import javax.persistence.Entity;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class GoodsWarehousesRemains extends GoodsWarehouses {

    @NonNull
    private Integer count;

    @Transient
    private TypesMovement typeMovement = null;

    public void setCount(Integer count, Session session, GoodsWarehouses goodsWarehouses) {
        this.setItem(goodsWarehouses.getItem());
        this.setWarehouses(goodsWarehouses.getWarehouses());
        this.setPeriod(goodsWarehouses.getPeriod());

        NativeQuery query = session.createSQLQuery("select * from GoodsWarehousesRemains where item = :item and Warehouses = :warehouses");
        query.setParameter("item",this.getItem());
        query.setParameter("warehouses",this.getWarehouses());
        query.addEntity(this.getClass());
        ArrayList<GoodsWarehousesRemains> remains = (ArrayList) query.list();
        if (remains.size() == 1){
            this.count = remains.get(0).getCount() + count;
        }
        session.save(this);
    }
}
