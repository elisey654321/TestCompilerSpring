package com.compile.testcompilerspring.procesing;

import com.compile.testcompilerspring.data.Call;
import org.hibernate.event.spi.PostInsertEvent;
import org.hibernate.event.spi.PostInsertEventListener;
import org.hibernate.persister.entity.EntityPersister;

public class ReplicationInsertEventListener implements PostInsertEventListener {
    @Override
    public void onPostInsert(PostInsertEvent postInsertEvent) {
        final Object entity = postInsertEvent.getEntity();
        if (entity instanceof Call){
            System.out.println("test");
        }
    }

    @Override
    public boolean requiresPostCommitHanding(EntityPersister entityPersister) {
        return false;
    }
}
