package com.project.ncms.model;

import com.project.ncms.model.Types.BedStatus;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "bed")
public class Bed {

    @Id
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false,cascade= CascadeType.ALL)
    @JoinColumn(name = "hospitalId", nullable = false, referencedColumnName = "id")
    private Hospital hospital;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private BedStatus status;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public BedStatus getStatus() {
        return status;
    }

    public void setStatus(BedStatus status) {
        this.status = status;
    }
}
