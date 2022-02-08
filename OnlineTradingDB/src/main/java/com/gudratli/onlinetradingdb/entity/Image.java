package com.gudratli.onlinetradingdb.entity;

import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name = "image")
@Getter
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
public class Image
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "image")
    @NonNull
    private byte[] image;
    @JoinColumn(name = "advert", referencedColumnName = "id")
    @ManyToOne(cascade = CascadeType.MERGE)
    @NonNull
    private Advert advert;
}
