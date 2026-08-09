package com.luigisback.kaizen_api.entity;


import jakarta.persistence.*;
import org.hibernate.annotations.AnyDiscriminatorImplicitValues;
import org.hibernate.annotations.ManyToAny;

import java.time.LocalDate;

@Entity
public class HabitLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;



    @ManyToOne
    private Habit habit;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Habit getHabit() {
        return habit;
    }

    public void setHabit(Habit habit) {
        this.habit = habit;
    }

    public HabitLog(){

    }


}
