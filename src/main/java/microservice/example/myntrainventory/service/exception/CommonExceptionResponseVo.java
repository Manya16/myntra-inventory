package microservice.example.myntrainventory.service.exception;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CommonExceptionResponseVo {

    @JsonProperty("timestamp")
    private Long timestamp;
    @JsonProperty("error_code")
    private String errorCode;
    @JsonProperty("message")
    private String message;

    public CommonExceptionResponseVo() {
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
