package com.svshayt.models;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
//@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private Integer id;
    private String title;
}
