package pl.aeh.bpmn.credit.model;

public class Token {

    private boolean authenticate;
    private String userId;

    public Token() {
    }

    public Token(boolean authenticate, String userId) {
        this.authenticate = authenticate;
        this.userId = userId;
    }

    public boolean isAuthenticate() {
        return authenticate;
    }

    public void setAuthenticate(boolean authenticate) {
        this.authenticate = authenticate;
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
                "authenticate=" + authenticate +
                ", userId='" + userId + '\'' +
                '}';
    }
}
