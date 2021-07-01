package com.epam.esm.dao.gift_certificate;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class GiftCertificateMapper implements RowMapper<GiftCertificate> {
    @Override
    public GiftCertificate mapRow(ResultSet resultSet, int i) throws SQLException {
        GiftCertificate certificate = new GiftCertificate();
        certificate.setId(resultSet.getLong("id"));
        certificate.setName(resultSet.getString("name"));
        certificate.setDescription(resultSet.getString("description"));
        certificate.setPrice(resultSet.getInt("price"));
        certificate.setDuration(resultSet.getInt("duration"));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS");
        LocalDateTime createDate = LocalDateTime.parse(resultSet.getString("create_date"), formatter);
        certificate.setCreateDate(createDate);

        if(resultSet.getString("last_update_date") != null) {
            LocalDateTime lastUpdateDate =
                    LocalDateTime.parse(resultSet.getString("last_update_date"), formatter);
            certificate.setLastUpdateDate(lastUpdateDate);
        } else {
            certificate.setLastUpdateDate(null);
        }
        return certificate;
    }
}
