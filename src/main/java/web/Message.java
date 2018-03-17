package web;

import java.io.Serializable;

public class Message implements Serializable {
    public enum Type {
        ERROR, WARN, INFO
    }

    private Type type;
    private String key;
    private String msg;

    public Message() {}

    public Message(Type type, String key) {
        this.type = type;
        this.key = key;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
