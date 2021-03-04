package pl.aeh.bpmn.credit.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "authenticate_customer_request")
public class AuthenticateCustomerRequestEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "authenticate_customer_request_id")
    private Long authenticateCustomerRequestId;

    @Column(name = "passport")
    private String passport;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "phone")
    private String phone;

    @Column(name = "account")
    private String account;

    @OneToMany(mappedBy = "authenticateCustomerRequest", cascade = CascadeType.ALL)
    private Set<AuthenticateCustomerRequestResponseEntity> authenticateCustomerRequestResponse = new HashSet<AuthenticateCustomerRequestResponseEntity>();

    public AuthenticateCustomerRequestEntity() {
    }

    public Long getAuthenticateCustomerRequestId() {
        return authenticateCustomerRequestId;
    }

    public void setAuthenticateCustomerRequestId(Long authenticateCustomerRequestId) {
        this.authenticateCustomerRequestId = authenticateCustomerRequestId;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Set<AuthenticateCustomerRequestResponseEntity> getAuthenticateCustomerRequestResponse() {
        return authenticateCustomerRequestResponse;
    }

    public void setAuthenticateCustomerRequestResponse(Set<AuthenticateCustomerRequestResponseEntity> authenticateCustomerRequestResponse) {
        this.authenticateCustomerRequestResponse = authenticateCustomerRequestResponse;
    }

    @Override
    public String toString() {
        return "AuthenticateCustomerRequestEntity{" +
                "authenticateCustomerRequestId='" + authenticateCustomerRequestId + '\'' +
                ", passport='" + passport + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", account='" + account + '\'' +
                '}';
    }
}
