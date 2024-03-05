package com.example.ballet.data.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity //엔티티 정의
@Table(name="schedule") //사용하지 않으면 클래스 이름이 테이블 이름이 됨
@Getter //lombok getter
@Setter //lombok setter
@Builder
public class ScheduleEntity {

    @Id //기본키를 의미. 반드시 기본키를 가져야함.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 45)
    private String groupName;

    @Column(nullable = false, length = 125)
    private String performanceTitle;

    @Column(nullable = false, length = 45)
    private String performanceDate;

    @Column(nullable = false, length = 50)
    private String performancePlace;

}
