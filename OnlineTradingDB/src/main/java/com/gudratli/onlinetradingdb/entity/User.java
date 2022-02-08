package com.gudratli.onlinetradingdb.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user")
@Getter
@NoArgsConstructor
@RequiredArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 100, name = "name")
    @NonNull
    @Setter
    private String name;
    @Column(length = 100, name = "surname")
    @NonNull
    @Setter
    private String surname;
    @Column(length = 200, name = "mail")
    @NonNull
    @Setter
    private String mail;
    @Column(length = 200, name = "phone")
    @NonNull
    @Setter
    private String phone;
    @JoinColumn(name = "city", referencedColumnName = "id")
    @ManyToOne(cascade = CascadeType.MERGE)
    @NonNull
    @Setter
    private City city;
    @Column(length = 255, name = "password")
    @NonNull
    @Setter
    private String password;
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<Advert> adverts;

    @Override
    public String toString ()
    {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", mail='" + mail + '\'' +
                ", phone='" + phone + '\'' +
                ", city=" + city +
                ", password='" + password + '\'' +
                '}';
    }
}
