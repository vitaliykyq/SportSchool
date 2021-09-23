package edu.coursework.sportschool.model;

/*
    @author:    Anton
    @project:    SportSchool
    @class:    FamousSportsmen
    @version:    1.0.0 
    @since:    15.04.2021     
*/


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "famousSportsmen")
public class FamousSportsmen {
    @Id
    private String id;

    private Sportsmen sportsmen;

    private Date createdAt;
    private Date modifiedAt;
    private String description;
}
