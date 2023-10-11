package dto;

public class ErrorResponse {
    private int code;
    private String type;
    private String message;

    public int getCode() {
        return code;
    }

    public ErrorResponse setCode(int code) {
        this.code = code;
        return this;
    }

    public String getType() {
        return type;
    }

    public ErrorResponse setType(String type) {
        this.type = type;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public ErrorResponse setMessage(String message) {
        this.message = message;
        return this;
    }
}
