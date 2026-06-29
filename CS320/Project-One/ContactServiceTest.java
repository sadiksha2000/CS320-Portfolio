import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactServiceTest {
    private ContactService service;
    private Contact contact1;
    private Contact contact2;

    @BeforeEach
    public void setUp() {
        service = new ContactService();
        contact1 = new Contact("C001", "John", "Doe", "1234567890", "123 Main St");
        contact2 = new Contact("C002", "Jane", "Smith", "9876543210", "456 Oak Ave");
    }

    // Test Add Contact Requirements
    @Test
    public void testAddContactSuccessfully() {
        service.addContact(contact1);
        assertEquals(contact1, service.getContact("C001"));
    }

    @Test
    public void testAddMultipleContactsWithUniqueIDs() {
        service.addContact(contact1);
        service.addContact(contact2);
        assertEquals(contact1, service.getContact("C001"));
        assertEquals(contact2, service.getContact("C002"));
    }

    @Test
    public void testAddContactWithDuplicateIDThrowsException() {
        service.addContact(contact1);
        assertThrows(IllegalArgumentException.class, () -> {
            service.addContact(contact1);
        });
    }

    @Test
    public void testAddNullContactThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.addContact(null);
        });
    }

    @Test
    public void testAddContactWithDifferentIDSameName() {
        Contact contact3 = new Contact("C003", "John", "Doe", "1111111111", "789 Pine Rd");
        service.addContact(contact1);
        service.addContact(contact3);
        assertEquals(contact1, service.getContact("C001"));
        assertEquals(contact3, service.getContact("C003"));
    }

    // Test Delete Contact Requirements
    @Test
    public void testDeleteContactSuccessfully() {
        service.addContact(contact1);
        service.deleteContact("C001");
        assertThrows(IllegalArgumentException.class, () -> {
            service.getContact("C001");
        });
    }

    @Test
    public void testDeleteContactWithInvalidIDThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.deleteContact("C999");
        });
    }

    @Test
    public void testDeleteNullContactIDThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.deleteContact(null);
        });
    }

    @Test
    public void testDeleteOneContactDoesNotAffectOthers() {
        service.addContact(contact1);
        service.addContact(contact2);
        service.deleteContact("C001");
        assertThrows(IllegalArgumentException.class, () -> {
            service.getContact("C001");
        });
        assertEquals(contact2, service.getContact("C002"));
    }

    @Test
    public void testDeleteContactThenAddAgainWithSameID() {
        service.addContact(contact1);
        service.deleteContact("C001");
        Contact contact3 = new Contact("C001", "Jane", "Doe", "5555555555", "789 Pine Rd");
        service.addContact(contact3);
        assertEquals(contact3, service.getContact("C001"));
    }

    // Test Update Contact First Name
    @Test
    public void testUpdateContactFirstNameSuccessfully() {
        service.addContact(contact1);
        service.updateContactFirstName("C001", "Jane");
        assertEquals("Jane", service.getContact("C001").getFirstName());
    }

    @Test
    public void testUpdateContactFirstNameWithInvalidIDThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.updateContactFirstName("C999", "Jane");
        });
    }

    @Test
    public void testUpdateContactFirstNameWithNullIDThrowsException() {
        service.addContact(contact1);
        assertThrows(IllegalArgumentException.class, () -> {
            service.updateContactFirstName(null, "Jane");
        });
    }

    // Test Update Contact Last Name
    @Test
    public void testUpdateContactLastNameSuccessfully() {
        service.addContact(contact1);
        service.updateContactLastName("C001", "Smith");
        assertEquals("Smith", service.getContact("C001").getLastName());
    }

    @Test
    public void testUpdateContactLastNameWithInvalidIDThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.updateContactLastName("C999", "Smith");
        });
    }

    @Test
    public void testUpdateContactLastNameWithNullIDThrowsException() {
        service.addContact(contact1);
        assertThrows(IllegalArgumentException.class, () -> {
            service.updateContactLastName(null, "Smith");
        });
    }

    // Test Update Contact Phone
    @Test
    public void testUpdateContactPhoneSuccessfully() {
        service.addContact(contact1);
        service.updateContactPhone("C001", "5555555555");
        assertEquals("5555555555", service.getContact("C001").getPhone());
    }

    @Test
    public void testUpdateContactPhoneWithInvalidIDThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.updateContactPhone("C999", "5555555555");
        });
    }

    @Test
    public void testUpdateContactPhoneWithNullIDThrowsException() {
        service.addContact(contact1);
        assertThrows(IllegalArgumentException.class, () -> {
            service.updateContactPhone(null, "5555555555");
        });
    }

    @Test
    public void testUpdateContactPhoneWithInvalidPhoneThrowsException() {
        service.addContact(contact1);
        assertThrows(IllegalArgumentException.class, () -> {
            service.updateContactPhone("C001", "555555555");
        });
    }

    // Test Update Contact Address
    @Test
    public void testUpdateContactAddressSuccessfully() {
        service.addContact(contact1);
        service.updateContactAddress("C001", "789 Pine Rd");
        assertEquals("789 Pine Rd", service.getContact("C001").getAddress());
    }

    @Test
    public void testUpdateContactAddressWithInvalidIDThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.updateContactAddress("C999", "789 Pine Rd");
        });
    }

    @Test
    public void testUpdateContactAddressWithNullIDThrowsException() {
        service.addContact(contact1);
        assertThrows(IllegalArgumentException.class, () -> {
            service.updateContactAddress(null, "789 Pine Rd");
        });
    }

    @Test
    public void testUpdateContactAddressWithInvalidAddressThrowsException() {
        service.addContact(contact1);
        assertThrows(IllegalArgumentException.class, () -> {
            service.updateContactAddress("C001", "This is an address that is definitely too long to fit");
        });
    }

    // Integration tests
    @Test
    public void testCompleteContactManagementWorkflow() {
        service.addContact(contact1);
        service.addContact(contact2);
        
        assertEquals(contact1, service.getContact("C001"));
        assertEquals(contact2, service.getContact("C002"));
        
        service.updateContactFirstName("C001", "Jonathan");
        service.updateContactLastName("C001", "Smith");
        service.updateContactPhone("C001", "2222222222");
        service.updateContactAddress("C001", "999 Elm St");
        
        Contact updated = service.getContact("C001");
        assertEquals("Jonathan", updated.getFirstName());
        assertEquals("Smith", updated.getLastName());
        assertEquals("2222222222", updated.getPhone());
        assertEquals("999 Elm St", updated.getAddress());
        
        service.deleteContact("C001");
        
        assertThrows(IllegalArgumentException.class, () -> {
            service.getContact("C001");
        });
        assertEquals(contact2, service.getContact("C002"));
    }

    @Test
    public void testMultipleContactsIndependentOperations() {
        service.addContact(contact1);
        service.addContact(contact2);
        
        service.updateContactFirstName("C001", "Johnny");
        assertEquals("Johnny", service.getContact("C001").getFirstName());
        assertEquals("Jane", service.getContact("C002").getFirstName());
        
        service.updateContactLastName("C002", "Johnson");
        assertEquals("Johnny", service.getContact("C001").getFirstName());
        assertEquals("Johnson", service.getContact("C002").getLastName());
    }

    @Test
    public void testDeleteAndReaddDifferentContact() {
        Contact contact3 = new Contact("C003", "Bob", "Johnson", "3333333333", "321 Birch Ln");
        service.addContact(contact1);
        service.addContact(contact3);
        
        service.deleteContact("C001");
        
        service.addContact(contact2);
        
        assertThrows(IllegalArgumentException.class, () -> {
            service.getContact("C001");
        });
        assertEquals(contact2, service.getContact("C002"));
        assertEquals(contact3, service.getContact("C003"));
    }
}
