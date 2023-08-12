package org.acme.timeManagement;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.NamedQuery;

import lombok.Data;

@Entity
@Data
@Table(name="timeElement")
@NamedQuery(name="timeElement.findLastElementForUser",
            query="SELECT t.id FROM timeElement t WHERE t.userId = :userId ORDER BY t.id DESC LIMIT 1")
public class timeElement {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    int id;

    @Column(name="user_id")
    String userId;

    @Column(name="check_in_time")
    long checkInTime; 

    @Column(name="check_out_time")
    long checkOutTime;

}
