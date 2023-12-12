package finlandia.finlandia.Interfaces;

import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
@AllArgsConstructor
public class ResponseInterface {
    private String message;
    private Boolean success;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    private Object data;


    public ResponseInterface(String message, Boolean success) {
        this.message = message;
        this.success = success;
    }

    public ResponseInterface() {
        this.message = "";
        this.success = false;
    }

    public String getMessage() {
        return message;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }
}
