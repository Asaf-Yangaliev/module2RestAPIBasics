package com.epam.esm.dao.gift_certificate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
public class GiftCertificate {
    private Long id;
    private String name;
    private String description;
    private Integer price;
    private Integer duration;

    @JsonProperty("create_date")
    @JsonSerialize(using = ToStringSerializer.class)
    private LocalDateTime createDate;

    @JsonProperty("last_update_date")
    @JsonSerialize(using = ToStringSerializer.class)
    private LocalDateTime lastUpdateDate;

    public GiftCertificate() {}
}

