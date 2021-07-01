package com.epam.esm.service.gift_certificate;

import com.epam.esm.dao.gift_certificate.GiftCertificate;
import com.epam.esm.dao.gift_certificate.GiftCertificateDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GiftCertificateServiceImpl implements GiftCertificateService {
    private final GiftCertificateDAO giftCertificateDAO;

    @Override
    public List<GiftCertificate> getAllGiftCertificates() {
        return giftCertificateDAO.getAllGiftCertificates();
    }

    @Override
    public List<GiftCertificate> getAllSortedByNameAndCreateDate() {
        return giftCertificateDAO.getAllSortedByNameAndCreateDate();
    }

    @Override
    public List<GiftCertificate> getAllSortedByNameAsc() {
        return giftCertificateDAO.getAllSortedByNameAsc();
    }

    @Override
    public List<GiftCertificate> getAllSortedByNameDesc() {
        return giftCertificateDAO.getAllSortedByNameDesc();
    }

    @Override
    public List<GiftCertificate> getAllSortedByCreateDateAsc() {
        return giftCertificateDAO.getAllSortedByCreateDateAsc();
    }

    @Override
    public List<GiftCertificate> getAllSortedByCreateDateDesc() {
        return giftCertificateDAO.getAllSortedByCreateDateDesc();
    }

    @Override
    public List<GiftCertificate> getAllGiftCertificatesByName(String name) {
        return giftCertificateDAO.getAllGiftCertificatesByName(name);
    }

    @Override
    public GiftCertificate getGiftCertificate(Long id) {
        return giftCertificateDAO.getGiftCertificate(id);
    }

    @Override
    public void create(GiftCertificate giftCertificate) {
        giftCertificateDAO.create(giftCertificate);
    }

    @Override
    public void update(GiftCertificate giftCertificate) {
        giftCertificateDAO.update(giftCertificate);
    }

    @Override
    public void deleteAll() {
        giftCertificateDAO.deleteAll();
    }

    @Override
    public void delete(Long id) {
        giftCertificateDAO.delete(id);
    }


}
