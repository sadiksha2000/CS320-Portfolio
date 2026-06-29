public class Contact {
    private final String contactID;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;

    // Constructor
    public Contact(String contactID, String firstName, String lastName, String phone, String address) {
        // Validate contactID
        if (contactID == null) {
            throw new IllegalArgumentException("Contact ID cannot be null");
        }
        if (contactID.length() > 10) {
            throw new IllegalArgumentException("Contact ID cannot be longer than 10 characters");
        }
        if (contactID.isEmpty()) {
            throw new IllegalArgumentException("Contact ID cannot be empty");
        }

        // Validate firstName
        if (firstName == null) {
            throw new IllegalArgumentException("First name cannot be null");
        }
        if (firstName.length() > 10) {
            throw new IllegalArgumentException("First name cannot be longer than 10 characters");
        }
        if (firstName.isEmpty()) {
            throw new IllegalArgumentException("First name cannot be empty");
        }

        // Validate lastName
        if (lastName == null) {
            throw new IllegalArgumentException("Last name cannot be null");
        }
        if (lastName.length() > 10) {
            throw new IllegalArgumentException("Last name cannot be longer than 10 characters");
        }
        if (lastName.isEmpty()) {
            throw new IllegalArgumentException("Last name cannot be empty");
        }

        // Validate phone
        if (phone == null) {
            throw new IllegalArgumentException("Phone cannot be null");
        }
        if (phone.length() != 10) {
            throw new IllegalArgumentException("Phone must be exactly 10 digits");
        }
        if (!phone.matches("\\d{10}")) {
            throw new IllegalArgumentException("Phone must contain only digits");
        }

        // Validate address
        if (address == null) {
            throw new IllegalArgumentException("Address cannot be null");
        }
        if (address.length() > 30) {
            throw new IllegalArgumentException("Address cannot be longer than 30 characters");
        }
        if (address.isEmpty()) {
            throw new IllegalArgumentException("Address cannot be empty");
        }

        // Assign values
        this.contactID = contactID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
    }

    // Getters
    public String getContactID() {
        return contactID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    // Setters (firstName, lastName, phone, address are updatable)
    public void setFirstName(String firstName) {
        if (firstName == null) {
            throw new IllegalArgumentException("First name cannot be null");
        }
        if (firstName.length() > 10) {
            throw new IllegalArgumentException("First name cannot be longer than 10 characters");
        }
        if (firstName.isEmpty()) {
            throw new IllegalArgumentException("First name cannot be empty");
        }
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if (lastName == null) {
            throw new IllegalArgumentException("Last name cannot be null");
        }
        if (lastName.length() > 10) {
            throw new IllegalArgumentException("Last name cannot be longer than 10 characters");
        }
        if (lastName.isEmpty()) {
            throw new IllegalArgumentException("Last name cannot be empty");
        }
        this.lastName = lastName;
    }

    public void setPhone(String phone) {
        if (phone == null) {
            throw new IllegalArgumentException("Phone cannot be null");
        }
        if (phone.length() != 10) {
            throw new IllegalArgumentException("Phone must be exactly 10 digits");
        }
        if (!phone.matches("\\d{10}")) {
            throw new IllegalArgumentException("Phone must contain only digits");
        }
        this.phone = phone;
    }

    public void setAddress(String address) {
        if (address == null) {
            throw new IllegalArgumentException("Address cannot be null");
        }
        if (address.length() > 30) {
            throw new IllegalArgumentException("Address cannot be longer than 30 characters");
        }
        if (address.isEmpty()) {
            throw new IllegalArgumentException("Address cannot be empty");
        }
        this.address = address;
    }
}
