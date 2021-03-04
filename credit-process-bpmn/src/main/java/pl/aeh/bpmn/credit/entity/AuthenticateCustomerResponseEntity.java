package pl.aeh.bpmn.credit.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "authenticate_customer_response")
public class AuthenticateCustomerResponseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "authenticate_customer_response_id")
    private Long authenticateCustomerResponseId;

    @Column(name = "is_authenticate")
    private boolean authenticate;

    @Column(name = "user_id")
    private String userId;

    @OneToMany(mappedBy = "authenticateCustomerResponse", cascade = CascadeType.ALL)
    private Set<AuthenticateCustomerRequestResponseEntity> authenticateCustomerRequestResponse = new HashSet<AuthenticateCustomerRequestResponseEntity>();

    public AuthenticateCustomerResponseEntity() {
    }

    public Long getAuthenticateCustomerResponseId() {
        return authenticateCustomerResponseId;
    }

    public void setAuthenticateCustomerResponseId(Long authenticateCustomerResponseId) {
        this.authenticateCustomerResponseId = authenticateCustomerResponseId;
    }

    public boolean isAuthenticate() {
        return authenticate;
    }

    public void setAuthenticate(boolean authenticate) {
        authenticate = authenticate;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Set<AuthenticateCustomerRequestResponseEntity> getAuthenticateCustomerRequestResponse() {
        return authenticateCustomerRequestResponse;
    }

    public void setAuthenticateCustomerRequestResponse(Set<AuthenticateCustomerRequestResponseEntity> authenticateCustomerRequestResponse) {
        this.authenticateCustomerRequestResponse = authenticateCustomerRequestResponse;
    }

    @Override
    public String toString() {
        return "AuthenticateCustomerResponseEntity{" +
                "authenticateCustomerResponseId='" + authenticateCustomerResponseId + '\'' +
                ", authenticate=" + authenticate +
                ", userId='" + userId + '\'' +
                '}';
    }
}
