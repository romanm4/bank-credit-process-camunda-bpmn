package pl.aeh.bpmn.credit.dto;

public class ErrorCreditResponseDTO {

    private ErrorType errorType;
    private String errorMessage;

    public ErrorCreditResponseDTO() {
    }

    public ErrorCreditResponseDTO(ErrorType errorType, String errorMessage) {
        this.errorType = errorType;
        this.errorMessage = errorMessage;
    }

    public ErrorType getErrorType() {
        return errorType;
    }

    public void setErrorType(ErrorType errorType) {
        this.errorType = errorType;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public enum ErrorType {REJECT, UNAUTHORIZED}

    @Override
    public String toString() {
        return "ErrorCreditResponseDTO{" +
                "errorType=" + errorType +
                ", errorMessage='" + errorMessage + '\'' +
                '}';
    }
}
