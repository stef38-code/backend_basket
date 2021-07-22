package com.stephane.backend.basketball.entities;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.domain.Persistable;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractEntityBase implements Persistable<String> {
    @Id
   // @Generated( GenerationTime.ALWAYS)
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid",strategy = "uuid")
    private String id;

    @Override
    public boolean isNew() {
        return id == null;
    }
    @Override
    public String getId() {
        return id;
    }
}
