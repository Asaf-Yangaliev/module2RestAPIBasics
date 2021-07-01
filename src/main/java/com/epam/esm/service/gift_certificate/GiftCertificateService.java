package com.epam.esm.service.gift_certificate;

import com.epam.esm.dao.gift_certificate.GiftCertificate;

import java.util.List;

public interface GiftCertificateService {
    List<GiftCertificate> getAllGiftCertificates();
    List<GiftCertificate> getAllSortedByNameAndCreateDate();
    List<GiftCertificate> getAllSortedByNameAsc();
    List<GiftCertificate> getAllSortedByNameDesc();
    List<GiftCertificate> getAllSortedByCreateDateAsc();
    List<GiftCertificate> getAllSortedByCreateDateDesc();
    List<GiftCertificate> getAllGiftCertificatesByName(String name);
    GiftCertificate getGiftCertificate(Long id);
    void create(GiftCertificate giftCertificate);
    void update(GiftCertificate giftCertificate);
    void deleteAll();
    void delete(Long id);
}
