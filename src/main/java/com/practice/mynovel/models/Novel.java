package com.practice.mynovel.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Novel extends BaseEntity{
    private String name;
    private int totalChapter;
    private int rate;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    private Details details;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Source source;
}
