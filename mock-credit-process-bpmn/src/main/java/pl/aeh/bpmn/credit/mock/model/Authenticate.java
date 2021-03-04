package pl.aeh.bpmn.credit.mock.model;

public class Authenticate {

    private String passport;
    private String firstName;
    private String lastName;
    private String phone;
    private String account;

    public Authenticate() {
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

    public void setAccount(String accountNumber) {
        this.account = accountNumber;
    }

    @Override
    public String toString() {
        return "AuthenticateDTO{" +
                "passport='" + passport + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", account='" + account + '\'' +
                '}';
    }
}
