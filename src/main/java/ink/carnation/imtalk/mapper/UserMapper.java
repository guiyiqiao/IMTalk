package ink.carnation.imtalk.mapper;

import ink.carnation.imtalk.model.po.UserPo;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author 桂乙侨
 * @Date 2020/9/20 16:02
 * @Version 1.0
 */

@Mapper
public interface UserMapper extends tk.mybatis.mapper.common.Mapper<UserPo> {
}
