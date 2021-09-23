package edu.coursework.sportschool.model;

/*
    @author:    Anton
    @project:    SportSchool
    @class:    Competition
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "competition")
public class Competition {
    @Id
    private String id;

    private Sport sport;
    private int numOfEvents;
    private String date;

    private Date createdAt;
    private Date modifiedAt;
    private String description;
}
