package com.gudratli.onlinetradingdb.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "subcategory")
@Getter
@NoArgsConstructor
@RequiredArgsConstructor
public class Subcategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 100, name = "name")
    @NonNull
    @Setter
    private String name;
    @JoinColumn(name = "category", referencedColumnName = "id")
    @ManyToOne(cascade = CascadeType.MERGE)
    @NonNull
    private Category category;
    @OneToMany(mappedBy = "subcategory")
    private Set<Kind> kinds;
    @OneToMany(mappedBy = "subcategory")
    private Set<Advert> advert;

    @Override
    public String toString ()
    {
        return "Subcategory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category=" + category +
                '}';
    }
}
