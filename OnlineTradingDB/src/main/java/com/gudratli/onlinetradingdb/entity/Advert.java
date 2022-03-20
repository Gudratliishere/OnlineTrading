package com.gudratli.onlinetradingdb.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "advert")
@Getter
@NoArgsConstructor
@RequiredArgsConstructor
public class Advert
{
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
    @JoinColumn(name = "subcategory", referencedColumnName = "id")
    @ManyToOne(cascade = CascadeType.MERGE)
    @NonNull
    private Subcategory subcategory;
    @JoinColumn(name = "kind", referencedColumnName = "id")
    @ManyToOne(cascade = CascadeType.MERGE)
    @NonNull
    private Kind kind;
    @Column(name = "price")
    @NonNull
    @Setter
    private Integer price;
    @JoinColumn(name = "city", referencedColumnName = "id")
    @ManyToOne(cascade = CascadeType.MERGE)
    @NonNull
    @Setter
    private City city;
    @Column(name = "description")
    @NonNull
    @Setter
    private String description;
    @JoinColumn(name = "user", referencedColumnName = "id")
    @ManyToOne(cascade = CascadeType.MERGE)
    @NonNull
    private User user;
    @Column(name = "used")
    @NonNull
    private Boolean used;
    @Column(name = "vote")
    private Integer vote;
    @Column(name = "degree")
    @NonNull
    private int degree = 1;
    @Column(name = "publish_date")
    @Setter
    private Date publishDate;
    @OneToMany(mappedBy = "advert")
    private List<Image> images;

    @Override
    public String toString ()
    {
        return "Advert{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category=" + category +
                ", subcategory=" + subcategory +
                ", kind=" + kind +
                ", price=" + price +
                ", city=" + city +
                ", description='" + description + '\'' +
                ", user=" + user +
                ", used=" + used +
                ", vote=" + vote +
                ", degree=" + degree +
                ", publishDate=" + publishDate +
                ", images=" + images +
                '}';
    }
}
