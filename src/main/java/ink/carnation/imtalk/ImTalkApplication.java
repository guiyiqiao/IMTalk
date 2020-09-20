package ink.carnation.imtalk;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("ink.carnation.imtalk.mapper")
public class ImTalkApplication {

    public static void main(String[] args) {
        SpringApplication.run(ImTalkApplication.class, args);
    }

}
