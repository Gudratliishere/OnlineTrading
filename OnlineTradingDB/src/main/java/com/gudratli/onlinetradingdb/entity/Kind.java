package com.gudratli.onlinetradingdb.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "kind")
@Getter
@NoArgsConstructor
@RequiredArgsConstructor
public class Kind
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 100, name = "name")
    @NonNull
    @Setter
    private String name;
    @JoinColumn(name = "subcategory", referencedColumnName = "id")
    @ManyToOne(cascade = CascadeType.MERGE)
    @NonNull
    private Subcategory subcategory;
    @OneToMany(mappedBy = "kind", fetch = FetchType.EAGER)
    private List<Advert> adverts;

    @Override
    public String toString ()
    {
        return "Kind{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", subcategory=" + subcategory +
                '}';
    }
}
