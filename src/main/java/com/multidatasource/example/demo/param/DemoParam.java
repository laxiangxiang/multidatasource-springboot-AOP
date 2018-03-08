package com.multidatasource.example.demo.param;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DemoParam {

    private Integer id;

    @NotBlank(message = "名称不能为空")
    @Length(max = 15,min = 3,message = "名称长度需要在3-15个字之间")
    private String name;

    @NotNull(message = "编号不能为空")
    private Integer NO;
}
