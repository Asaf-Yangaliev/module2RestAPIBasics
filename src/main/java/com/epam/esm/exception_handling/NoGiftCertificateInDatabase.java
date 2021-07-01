package com.epam.esm.exception_handling;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

@Data
public class NoGiftCertificateInDatabase {
    @JsonProperty("http Status")
    private int http_status;

    @JsonProperty("Response body")
    ResponseBody responseBody;

    public NoGiftCertificateInDatabase() {}

    public NoGiftCertificateInDatabase(int http_status, String errorMessage, int errorCode) {
        this.http_status = http_status;
        responseBody = new ResponseBody(errorMessage, errorCode);
    }

    @Data
    private class ResponseBody {
        private String errorMessage;
        private int errorCode;

        public ResponseBody() {}

        public ResponseBody(String errorMessage, int errorCode) {
            this.errorMessage = errorMessage;
            this.errorCode = errorCode;
        }
    }
}
