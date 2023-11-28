package io.github.zemise.utils;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static io.github.zemise.labweb.utils.VerifyCodeUtils.generateVerifyCode;
import static io.github.zemise.labweb.utils.VerifyCodeUtils.outputImage;

/**
 * <p>
 *
 * </p>
 *
 * @author <a href= "https://github.com/zemise">Zemise</a>
 * @Date 2023/11/28
 * @since 1.0
 */
public class VerifyCodeTest {
    @Test
    public static void main(String[] args) throws IOException {
        //获取验证码
        String s = generateVerifyCode(5);
        //将验证码放入图片中
        outputImage(260,60,new File("/Users/zhaowang/Downloads/aa.jpg"),s);
        System.out.println(s);
    }
}
