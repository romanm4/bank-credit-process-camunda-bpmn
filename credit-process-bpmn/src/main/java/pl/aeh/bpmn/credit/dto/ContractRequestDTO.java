package pl.aeh.bpmn.credit.dto;

import java.io.*;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ContractRequestDTO implements Externalizable {

    private BigDecimal loanAmount;
    private Date date;
    private String firstName;
    private String lastName;
    private String address;
    private double percent;
    private String proposedCreditMethodPayment;
    private String additionalInformation;

    public ContractRequestDTO() {
    }

    public BigDecimal getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(BigDecimal loanAmount) {
        this.loanAmount = loanAmount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }

    public String getProposedCreditMethodPayment() {
        return proposedCreditMethodPayment;
    }

    public void setProposedCreditMethodPayment(String proposedCreditMethodPayment) {
        this.proposedCreditMethodPayment = proposedCreditMethodPayment;
    }

    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeUTF(String.valueOf(loanAmount));
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        out.writeUTF(dateFormat.format(date));
        out.writeUTF(firstName);
        out.writeUTF(lastName);
        out.writeUTF(address);
        out.writeUTF(String.valueOf(percent));
        out.writeUTF(proposedCreditMethodPayment);
        out.writeUTF(additionalInformation);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        loanAmount = new BigDecimal(in.readUTF());
        try {
            date = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss").parse(in.readUTF());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        firstName = in.readUTF();
        lastName = in.readUTF();
        address = in.readUTF();
        percent = Double.parseDouble(in.readUTF());
        proposedCreditMethodPayment = in.readUTF();
        additionalInformation = in.readUTF();
    }

    @Override
    public String toString() {
        return "ContractRequestDTO{" +
                "loanAmount=" + loanAmount +
                ", date=" + date +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", percent=" + percent +
                ", proposedCreditMethodPayment='" + proposedCreditMethodPayment + '\'' +
                ", additionalInformation='" + additionalInformation + '\'' +
                '}';
    }
}
