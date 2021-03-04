package pl.aeh.bpmn.credit.dto;

public class CreditResponseDTO {

    private String status;

    public CreditResponseDTO() {
    }

    public CreditResponseDTO(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "CreditResponseDTO{" +
                "status='" + status + '\'' +
                '}';
    }
}
