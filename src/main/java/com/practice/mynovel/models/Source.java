package com.practice.mynovel.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Source extends BaseEntity{
    private String name;
    private String url;

    @OneToOne
    private Novel novel;

    public Source(String name, String url) {
        this.name = name;
        this.url = url;
    }
}
