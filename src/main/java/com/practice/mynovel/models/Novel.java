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
    private String totalChapter;
    private String rate;
    private String photosSource;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    private Details details;

    @OneToOne(cascade = {CascadeType.ALL})
    private Source source;

    @Transient
    public String getPhotosImagePath(){
        if (photosSource == null || getId() == null) return null;
        return photosSource;
    }
}
