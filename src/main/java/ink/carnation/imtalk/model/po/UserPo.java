package ink.carnation.imtalk.model.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
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
@Table(name = "user_tb")
public class UserPo implements Serializable {

    @Id
    private Integer id;

    private String nickname;

    private String password;

    private String email;

    private Boolean valid;
}
