package com.anatoly.bondarenko.domain;

import lombok.*;

import java.util.Date;

@ToString
@EqualsAndHashCode
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class ProjectsResults {

    private String projectsName;

    private Date date;

    private Integer amountOfDevelopers;



}
