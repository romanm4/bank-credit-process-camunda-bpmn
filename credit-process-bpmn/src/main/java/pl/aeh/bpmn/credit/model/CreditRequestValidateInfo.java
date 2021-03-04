package pl.aeh.bpmn.credit.model;

public class CreditRequestValidateInfo {

    private boolean valid;
    private boolean updatable;

    public CreditRequestValidateInfo() {
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public boolean isUpdatable() {
        return updatable;
    }

    public void setUpdatable(boolean updatable) {
        this.updatable = updatable;
    }

    @Override
    public String toString() {
        return "CreditRequestValidateInfo{" +
                "valid=" + valid +
                ", updatable=" + updatable +
                '}';
    }
}
