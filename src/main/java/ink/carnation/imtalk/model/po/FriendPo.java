package ink.carnation.imtalk.model.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Table;
import java.io.Serializable;

/**
 * @Author 桂乙侨
 * @Date 2020/9/20 15:56
 * @Version 1.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "friend_tb")
public class FriendPo  implements Serializable {

    private Integer userId;

    private Integer friendId;

    private Boolean valid;
}
