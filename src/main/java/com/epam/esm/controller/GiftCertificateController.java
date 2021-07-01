package com.epam.esm.controller;

import com.epam.esm.dao.gift_certificate.GiftCertificate;
import com.epam.esm.exception_handling.NoGiftCertificatesInDataBaseException;
import com.epam.esm.exception_handling.NoSuchGiftCertificateException;
import com.epam.esm.service.gift_certificate.GiftCertificateService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/giftCertificates")
public class GiftCertificateController {
    private final GiftCertificateService giftCertificateService;
    private static final String GET_ALL = "/getAll";
    private static final String GET = "/get/{id}";
    private static final String GET_ALL_BY_NAME = "/getAll/{name}";
    private static final String CREATE = "/create";
    private static final String UPDATE = "/update";
    private static final String GET_ALL_SORTED_BY_NAME_ASC = "/getAll/sortedByNameAsc";
    private static final String GET_ALL_SORTED_BY_NAME_DESC = "/getAll/sortedByNameDesc";
    private static final String GET_ALL_SORTED_BY_CREATE_DATE_ASC = "/getAll/sortedByCreateDateAsc";
    private static final String GET_ALL_SORTED_BY_CREATE_DATE_DESC = "/getAll/sortedByCreateDateDesc";
    private static final String GET_ALL_SORTED_BY_NAME_AND_CREATE_DATE = "/getAll/sortedByNameAndCreateDate";
    private static final String DELETE = "/delete/{id}";
    private static final String DELETE_ALL = "/deleteAll";

    @GetMapping(GET_ALL)
    public List<GiftCertificate> getAll() {
        List<GiftCertificate> giftCertificates = giftCertificateService.getAllGiftCertificates();

        if (giftCertificates.size() == 0)
            throw new NoGiftCertificatesInDataBaseException("Requested resource not found");

        return giftCertificates;
    }

    @GetMapping(GET_ALL_SORTED_BY_NAME_AND_CREATE_DATE)
    public List<GiftCertificate> getAllSortedByNameAndCreateDate() {
        return giftCertificateService.getAllSortedByNameAndCreateDate();
    }

    @GetMapping(GET_ALL_SORTED_BY_NAME_ASC)
    public List<GiftCertificate> getAllSortedByNameAsc() {
        List<GiftCertificate> giftCertificates = giftCertificateService.getAllSortedByNameAsc();

        if (giftCertificates.size() == 0)
            throw new NoGiftCertificatesInDataBaseException("Requested resource not found");

        return giftCertificates;
    }

    @GetMapping(GET_ALL_SORTED_BY_NAME_DESC)
    public List<GiftCertificate> getAllSortedByNameDesc() {
        List<GiftCertificate> giftCertificates = giftCertificateService.getAllSortedByNameDesc();

        if (giftCertificates.size() == 0)
            throw new NoGiftCertificatesInDataBaseException("Requested resource not found");

        return giftCertificates;
    }

    @GetMapping(GET_ALL_SORTED_BY_CREATE_DATE_ASC)
    public List<GiftCertificate> getAllSortedByCreateDateAsc() {
        List<GiftCertificate> giftCertificates = giftCertificateService.getAllSortedByCreateDateAsc();

        if (giftCertificates.size() == 0)
            throw new NoGiftCertificatesInDataBaseException("Requested resource not found");

        return giftCertificates;
    }

    @GetMapping(GET_ALL_SORTED_BY_CREATE_DATE_DESC)
    public List<GiftCertificate> getAllSortedByCreateDateDesc() {
        List<GiftCertificate> giftCertificates = giftCertificateService.getAllSortedByCreateDateDesc();

        if (giftCertificates.size() == 0)
            throw new NoGiftCertificatesInDataBaseException("Requested resource not found");

        return giftCertificates;
    }

    @GetMapping(GET_ALL_BY_NAME)
    public List<GiftCertificate> getAllByName(@PathVariable("name") String name) {
        List<GiftCertificate> giftCertificates = giftCertificateService.getAllGiftCertificatesByName(name);

        if(giftCertificates.size() == 0)
            throw new NoGiftCertificatesInDataBaseException("Requested resource not found (name = " +
                     name + ")");

        return giftCertificates;
    }

    @GetMapping(GET)
    public GiftCertificate get(@PathVariable("id") Long id) {
        GiftCertificate certificate = null;

        try {
            certificate = giftCertificateService.getGiftCertificate(id);
        } catch (EmptyResultDataAccessException e) {
            throw new NoSuchGiftCertificateException("Requested resource not found (id = " + id + ")");
        }

        return certificate;
    }

    @PostMapping(CREATE)
    public void create(@RequestBody GiftCertificate certificate) {
        giftCertificateService.create(certificate);
    }

    @PutMapping(UPDATE)
    public void update(@RequestBody GiftCertificate certificate) {
        GiftCertificate GiftCertificate = null;

        try {
            GiftCertificate = giftCertificateService.getGiftCertificate(certificate.getId());
        } catch (EmptyResultDataAccessException e) {
            throw new NoSuchGiftCertificateException
                    ("Requested resource not found (id = " + certificate.getId() + ")");
        }

        giftCertificateService.update(certificate);
    }

    @DeleteMapping(DELETE_ALL)
    public void deleteAll() {
        giftCertificateService.deleteAll();
    }

    @DeleteMapping(DELETE)
    public void delete(@PathVariable("id") Long id) {
        GiftCertificate giftCertificate = null;

        try {
            giftCertificate = giftCertificateService.getGiftCertificate(id);
        } catch (EmptyResultDataAccessException e) {
            throw new NoSuchGiftCertificateException
                    ("Requested resource not found (id = " + id + ")");
        }

        giftCertificateService.delete(id);
    }
}