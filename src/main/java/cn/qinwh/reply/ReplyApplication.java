package cn.qinwh.reply;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("cn.qinwh.reply.mapper")
public class ReplyApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReplyApplication.class, args);
    }

}
