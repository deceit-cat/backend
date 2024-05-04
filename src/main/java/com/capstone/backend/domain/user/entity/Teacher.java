package com.capstone.backend.domain.user.entity;

import lombok.*;
import javax.persistence.*;

@Table(name = "TEACHERS")
@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private User user;

    @Column
    private String teacherSchool; // 학교

    @Column
    private String teacherClass; // 학급

    public Teacher(User user, String teacherSchool, String teacherClass) {
        this.user = user;
        if (user.getRole() != Role.TEACHER) {
            this.user.setRole(Role.TEACHER);
        }
        this.teacherSchool = teacherSchool;
        this.teacherClass = teacherClass;
    }

    public String getTeacherName() {
        return this.user.getName();
    }
}
