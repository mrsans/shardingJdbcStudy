package com.sans.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Student {

    private Long nId;

    private String cName;

    private String cPlace;

    private Integer nSex;

    private Long nCard;

}
