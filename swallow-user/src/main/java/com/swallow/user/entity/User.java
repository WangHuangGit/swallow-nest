package com.swallow.user.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * User的实体类
 * @author WangHan
 * @date 2018/12/25 16:00
 */

@Data
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 16, nullable = false)
    private String name = "";

    @Column(length = 11, nullable = false)
    private String phone = "";

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Gender gender = Gender.HIDE;

    @SuppressWarnings("unused")
    public enum Gender {
        /**
         * 性别：男
         */
        MALE("男"),
        /**
         * 性别：女
         */
        FEMALE("女"),
        /**
         * 性别：未知
         */
        HIDE("未知");

        private String value;

        Gender(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}
