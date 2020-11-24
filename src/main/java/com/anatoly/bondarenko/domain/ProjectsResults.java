package com.anatoly.bondarenko.domain;

import lombok.Data;

import java.util.Date;

@Data
public class ProjectsResults {

    private Date date;

    private String projectsName;

    private Integer amountOfDevelopers;


    ProjectsResults(Date date, String projectsName, Integer amountOfDevelopers) {

        this.date = date;
        this.projectsName = projectsName;
        this.amountOfDevelopers = amountOfDevelopers;

    }




}




/*

    public ScheduledDay (
            Long id, Long employeeId,
            Integer hourIn, Integer hourOut,
            String dayofWeek) {
        this.id = id;
        this.employeeId = employeeId;
        this.dayOfWeek = dayofWeek;
    }
    Кроме того, сопоставление определяет целевой класс и столбцы (оба обязательны):

@SqlResultSetMapping(
        name="ScheduleResult",
        classes={
                @ConstructorResult(
                        targetClass=com.baeldung.sqlresultsetmapping.ScheduledDay.class,
                        columns={
                                @ColumnResult(name="id", type=Long.class),
                                @ColumnResult(name="employeeId", type=Long.class),
                                @ColumnResult(name="dayOfWeek")})})



@NamedNativeQuery(name = "Schedules",
        query = "SELECT **  FROM schedule__days WHERE employeeId = 8",
        resultSetMapping = "ScheduleResult")

*/

