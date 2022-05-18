package com.example.mybatispluspage.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("page")
public class Page implements Serializable {
    private Long id;
    private String name;
    private Long age;
}
