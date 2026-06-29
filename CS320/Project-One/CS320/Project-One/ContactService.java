import java.util.HashMap;
import java.util.Map;

public class ContactService {
    private Map<String, Contact> contacts;

    // Constructor
    public ContactService() {
        this.contacts = new HashMap<>();
    }

    // Add a contact with a unique ID
    public void addContact(Contact contact) {
        if (contact == null) {
            throw new IllegalArgumentException("Contact cannot be null");
        }
        if (contacts.containsKey(contact.getContactID())) {
            throw new IllegalArgumentException("Contact with ID " + contact.getContactID() + " already exists");
        }
        contacts.put(contact.getContactID(), contact);
    }

    // Delete a contact by contact ID
    public void deleteContact(String contactID) {
        if (contactID == null) {
            throw new IllegalArgumentException("Contact ID cannot be null");
        }
        if (!contacts.containsKey(contactID)) {
            throw new IllegalArgumentException("Contact with ID " + contactID + " not found");
        }
        contacts.remove(contactID);
    }

    // Update contact first name
    public void updateContactFirstName(String contactID, String firstName) {
        if (contactID == null) {
            throw new IllegalArgumentException("Contact ID cannot be null");
        }
        if (!contacts.containsKey(contactID)) {
            throw new IllegalArgumentException("Contact with ID " + contactID + " not found");
        }
        contacts.get(contactID).setFirstName(firstName);
    }

    // Update contact last name
    public void updateContactLastName(String contactID, String lastName) {
        if (contactID == null) {
            throw new IllegalArgumentException("Contact ID cannot be null");
        }
        if (!contacts.containsKey(contactID)) {
            throw new IllegalArgumentException("Contact with ID " + contactID + " not found");
        }
        contacts.get(contactID).setLastName(lastName);
    }

    // Update contact phone
    public void updateContactPhone(String contactID, String phone) {
        if (contactID == null) {
            throw new IllegalArgumentException("Contact ID cannot be null");
        }
        if (!contacts.containsKey(contactID)) {
            throw new IllegalArgumentException("Contact with ID " + contactID + " not found");
        }
        contacts.get(contactID).setPhone(phone);
    }

    // Update contact address
    public void updateContactAddress(String contactID, String address) {
        if (contactID == null) {
            throw new IllegalArgumentException("Contact ID cannot be null");
        }
        if (!contacts.containsKey(contactID)) {
            throw new IllegalArgumentException("Contact with ID " + contactID + " not found");
        }
        contacts.get(contactID).setAddress(address);
    }

    // Get a contact by ID
    public Contact getContact(String contactID) {
        if (contactID == null) {
            throw new IllegalArgumentException("Contact ID cannot be null");
        }
        if (!contacts.containsKey(contactID)) {
            throw new IllegalArgumentException("Contact with ID " + contactID + " not found");
        }
        return contacts.get(contactID);
    }
}
