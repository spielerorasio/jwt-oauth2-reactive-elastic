package com.orasio.jwt.elastic.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data//replace getter / setter / toString / hashcode / equals
@NoArgsConstructor
@AllArgsConstructor
public class Event {
    private String name;
    private long time;


}
