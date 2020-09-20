package ink.carnation.imtalk.model.po;

import javax.persistence.Table;

/**
 * @Author 桂乙侨
 * @Date 2020/9/20 15:56
 * @Version 1.0
 */

@Table(name = "user_tb")
public class UserPo {

    private Integer id;

    private String nickname;

    private String password;

    private String email;

    private Boolean valid;
}
