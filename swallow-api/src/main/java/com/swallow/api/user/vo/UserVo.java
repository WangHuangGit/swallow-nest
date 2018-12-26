package com.swallow.api.user.vo;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 接收请求的vo
 * @author WangHan
 * @date 2018/12/26 10:29
 */

@Data
public class UserVo {

    @NotBlank(message = "姓名不能为空")
    private String name = "";

    private String phone = "";

    @NotNull(message = "性别不能为空")
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
