package br.edu.ifgoiano.gestaopessoas2026.exceptions;

import java.io.Serializable;
import java.util.Date;

public class ExceptionResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    private Date timestamp;
    private String message;
    private String detail;

    public ExceptionResponse() {
    }

    public ExceptionResponse(Date timestamp, String message, String detail) {
        this.timestamp = timestamp;
        this.message = message;
        this.detail = detail;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String mensagem) {
        this.message = mensagem;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detalhe) {
        this.detail = detalhe;
    }
}