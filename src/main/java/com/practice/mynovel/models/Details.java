package com.practice.mynovel.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Details extends BaseEntity {

    @Lob
    private String synopsis;

    @OneToOne
    private Novel novel;

    @ManyToOne(cascade = CascadeType.ALL)
    private Status status;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Genre> genreList;

    public List<Genre> getGenreList() {
        if (genreList == null) genreList = new ArrayList<>();
        return genreList;
    }
}
