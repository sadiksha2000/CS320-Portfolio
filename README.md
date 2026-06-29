# CS 320 Software Testing, Automation, and Quality Assurance Portfolio

## Overview
This portfolio showcases my work in CS 320: Software Testing, Automation, and Quality Assurance. The projects demonstrate my ability to create unit tests using code to uncover errors, analyze various approaches to software testing based on requirements, and apply appropriate testing strategies to meet requirements.

## Project Submissions

### Project One: Contact, Task, and Appointment Services
**Files:** Contact.java, ContactService.java, ContactTest.java, ContactServiceTest.java

In Project One, I developed three mobile application services with comprehensive unit testing. The Contact Service includes 30+ unit tests validating five class requirements and three service requirements. The implementation demonstrates proper input validation, error handling, and test-driven development practices. All tests follow JUnit 5 conventions with clear naming, proper setup/teardown, and comprehensive positive, negative, and boundary testing approaches.

### Project Two: Summary and Reflections Report
**File:** CS320_Project_Two_Report.docx

Project Two required a comprehensive analysis of my testing approach and reflections on software quality assurance practices. The report covers unit testing strategies, alignment to requirements, test effectiveness with 85-90% code coverage, technical soundness through defensive programming, code efficiency through data structure selection, and critical reflection on testing techniques, mindset, bias, and professional discipline.

---

## Reflections

### How can I ensure that my code, program, or software is functional and secure?

To ensure code is functional and secure, I've learned that comprehensive unit testing is foundational. In Project One, I created over 80 automated tests that validated every requirement through positive testing, negative testing, and boundary testing. Beyond testing, secure code requires input validation at every entry point. In my Contact and Appointment classes, constructors validate inputs like phone number format and appointment dates before accepting data. I also use immutable fields (final keyword) for data that shouldn't change, preventing accidental modification. Additionally, proper deployment verification and version control are essential.

### How do I interpret user needs and incorporate them into a program?

Interpreting user needs begins with carefully reading and understanding requirements, then creating tests that directly verify those requirements. In Project One, the customer requirements specified that contact IDs must be unique, not updatable, and not longer than 10 characters. Rather than making assumptions, I created specific tests that directly correspond to stated requirements. This requirement-driven testing approach ensures that every feature developed meets customer expectations. By mapping requirements to tests, I ensure that user needs are not just understood but verified to be implemented correctly.

### How do I approach designing software?

My approach to designing software has evolved through this course to be test-driven and requirement-focused. Rather than designing based on assumptions, I start by understanding the complete set of requirements and constraints. For the Contact class, I knew the requirements before designing the class structure. This informed my design decisions: using final for the ID field to enforce non-updatability, implementing comprehensive validation in constructors, and using appropriate data structures (HashMap in services) for O(1) lookup performance. I design for testability, ensuring that code can be tested in isolation. I also design for failure gracefully, implementing proper exception handling and clear error messages rather than allowing silent failures.

---

## Key Learning Outcomes

- Unit Testing Mastery: Created 80+ comprehensive unit tests using JUnit 5 with 85-90% code coverage
- Requirement Analysis: Developed tests directly aligned to customer requirements with 100% requirement verification
- Software Quality: Implemented defensive programming, input validation, and error handling best practices
- Testing Techniques: Applied unit testing, negative testing, boundary testing, positive testing, and integration testing
- Professional Development: Reflected on caution, bias, and discipline required for quality software engineering

---

## Contact
For more information about this portfolio, please visit my GitHub profile.
