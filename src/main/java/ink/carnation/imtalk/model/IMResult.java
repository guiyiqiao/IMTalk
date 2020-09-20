package ink.carnation.imtalk.model;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author 桂乙侨
 * @Date 2020/9/20 20:51
 * @Version 1.0
 */
@Data
@Builder
public class IMResult implements Serializable {

    private int code;

    private String message;

    private Object data;


    public IMResult(int code, String message) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
    public IMResult(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static IMResult success(){
        IMResult result = new IMResultBuilder()
                .code(200)
                .message("请求成功")
                .build();
        return result;
    }

    public static IMResult success(Object data){
        IMResult result = new IMResultBuilder()
                .code(200)
                .message("请求成功")
                .data(data)
                .build();
        return result;
    }

    public static IMResult failure(){
        IMResult result = new IMResultBuilder()
                .code(600)
                .message("请求失败")
                .build();
        return result;
    }
}
