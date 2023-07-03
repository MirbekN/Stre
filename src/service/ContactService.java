package service;

import model.Contact;

public interface ContactService {

    void addContactToPhone(Long phoneId, Contact contact);

    Contact findContactByName(Long phoneId, String name);

    Contact findContactByPhoneNumber(Long phoneId, Long phoneNumber);

    void deleteContactByNamefromPhone(Long phoneId, String name);}

