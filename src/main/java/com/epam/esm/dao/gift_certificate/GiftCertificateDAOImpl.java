package com.epam.esm.dao.gift_certificate;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@RequiredArgsConstructor
@Repository
public class GiftCertificateDAOImpl implements GiftCertificateDAO {
    private final JdbcTemplate jdbcTemplate;
    private final GiftCertificateMapper mapper;

    @Override
    public List<GiftCertificate> getAllGiftCertificates() {
        return jdbcTemplate.query("select * from gift_certificate;", mapper);
    }

    @Override
    public List<GiftCertificate> getAllSortedByNameAndCreateDate() {
        return jdbcTemplate.query("select * from gift_certificate order by name, create_ date;", mapper);
    }

    @Override
    public List<GiftCertificate> getAllSortedByNameAsc() {
        return jdbcTemplate.query("select * from gift_certificate order by name;", mapper);
    }

    @Override
    public List<GiftCertificate> getAllSortedByNameDesc() {
        return jdbcTemplate.query("select * from gift_certificate order by name desc;", mapper);
    }

    @Override
    public List<GiftCertificate> getAllSortedByCreateDateAsc() {
        return jdbcTemplate.query("select * from gift_certificate order by create_date;", mapper);
    }

    @Override
    public List<GiftCertificate> getAllSortedByCreateDateDesc() {
        return jdbcTemplate.query("select * from gift_certificate order by create_date desc;", mapper);
    }

    @Override
    public List<GiftCertificate> getAllGiftCertificatesByName(String name) {
        return jdbcTemplate.query("select * from gift_certificate where name = ?;", mapper, name);
    }

    @Override
    public GiftCertificate getGiftCertificate(Long id) {
        return jdbcTemplate.queryForObject("select * from gift_certificate where id = ?", mapper, id);
    }

    @Override
    public void create(GiftCertificate certificate) {
        String now = LocalDateTime.of(LocalDate.now(), LocalTime.now()).toString();
        now = now.substring(0, 23);
        jdbcTemplate.update("insert into gift_certificate (name, description, price, duration, create_date) " +
                "values(?, ?, ?, ?, ?);", certificate.getName(), certificate.getDescription(),
                certificate.getPrice(), certificate.getDuration(), now);
    }

    @Override
    public void update(GiftCertificate giftCertificate) {
        Long id = giftCertificate.getId();

        String newName = giftCertificate.getName();
        if(newName != null) {
            jdbcTemplate.update("update gift_certificate set name = ? where id = ?;", newName, id);
        }

        String newDescription = giftCertificate.getDescription();
        if(newDescription != null) {
            jdbcTemplate.update("update gift_certificate set description = ? where id = ?;", newDescription, id);
        }

        Integer newPrice = giftCertificate.getPrice();
        if(newPrice != null) {
            jdbcTemplate.update("update gift_certificate set price = ? where id = ?;", newPrice, id);
        }

        Integer newDuration = giftCertificate.getDuration();
        if(newDuration != null) {
            jdbcTemplate.update("update gift_certificate set duration = ? where id = ?;", newDuration, id);
        }

        String now = LocalDateTime.of(LocalDate.now(), LocalTime.now()).toString();
        now = now.substring(0, 23);

        jdbcTemplate.update("update gift_certificate set last_update_date = ? where id = ?", now, giftCertificate.getId());
    }

    @Override
    public void deleteAll() {
        jdbcTemplate.update("delete from gift_certificate");
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update("delete from gift_certificate where id = ?", id);
    }
}