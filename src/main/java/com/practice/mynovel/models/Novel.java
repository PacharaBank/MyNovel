package com.practice.mynovel.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Novel extends BaseEntity{
    private String name;
    private String totalChapter;
    private String rate;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    private Details details;

    @OneToOne(cascade = {CascadeType.ALL})
    private Source source;
}
