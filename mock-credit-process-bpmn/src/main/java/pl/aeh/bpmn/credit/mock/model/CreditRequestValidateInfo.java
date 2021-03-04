package pl.aeh.bpmn.credit.mock.model;

public class CreditRequestValidateInfo {

    private boolean isValid;
    private boolean isUpdatable;

    public CreditRequestValidateInfo() {
    }

    public CreditRequestValidateInfo(boolean isValid, boolean isUpdatable) {
        this.isValid = isValid;
        this.isUpdatable = isUpdatable;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }

    public boolean isUpdatable() {
        return isUpdatable;
    }

    public void setUpdatable(boolean updatable) {
        isUpdatable = updatable;
    }

    @Override
    public String toString() {
        return "CreditRequestValidateInfo{" +
                "isValid=" + isValid +
                ", isUpdatable=" + isUpdatable +
                '}';
    }
}
