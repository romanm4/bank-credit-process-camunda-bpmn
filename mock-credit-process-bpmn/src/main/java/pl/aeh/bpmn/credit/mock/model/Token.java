package pl.aeh.bpmn.credit.mock.model;

public class Token {

    private boolean isAuthenticate;
    private String userId;

    public Token() {
    }

    public Token(boolean isAuthenticate, String userId) {
        this.isAuthenticate = isAuthenticate;
        this.userId = userId;
    }

    public boolean isAuthenticate() {
        return isAuthenticate;
    }

    public void setAuthenticate(boolean authenticate) {
        isAuthenticate = authenticate;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Token{" +
                "token='" + isAuthenticate + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}
