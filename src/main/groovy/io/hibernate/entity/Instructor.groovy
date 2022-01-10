package io.hibernate.entity

import groovy.transform.Canonical

import javax.persistence.CascadeType
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.OneToMany
import javax.persistence.OneToOne
import javax.persistence.Table

@Entity
@Table(name="Instructor")
class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    int id

    @Column(name="first_name")
    String firstName

    @Column(name="last_name")
    String lastName

    @Column(name="email")
    String email

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="instructor_detail_id")
    InstructorDetail instructorDetail

    Instructor() {
    }

    Instructor(String firstName, String lastName, String email) {
        this.firstName = firstName
        this.lastName = lastName
        this.email = email
    }


    @Override
    public String toString() {
        return "Instructor{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
