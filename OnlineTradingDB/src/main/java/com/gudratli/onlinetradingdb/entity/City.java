package com.gudratli.onlinetradingdb.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "city")
@Getter
@NoArgsConstructor
@RequiredArgsConstructor
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    @NonNull
    @Setter
    private String name;
    @OneToMany(mappedBy = "city", fetch = FetchType.EAGER)
    private List<User> users;

    @Override
    public String toString ()
    {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
