package ink.carnation.imtalk.model.po;

import javax.persistence.Table;

/**
 * @Author 桂乙侨
 * @Date 2020/9/20 15:56
 * @Version 1.0
 */
@Table(name = "friend_tb")
public class FriendPo {


    private Integer userId;

    private Integer friendId;

    private Boolean valid;
}
