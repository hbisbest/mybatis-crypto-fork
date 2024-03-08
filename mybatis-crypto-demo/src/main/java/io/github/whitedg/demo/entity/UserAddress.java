package io.github.whitedg.demo.entity;

import io.github.whitedg.demo.encryptor.MyAesEncryptor;
import io.github.whitedg.demo.encryptor.MyEncryptor;
import io.github.whitedg.mybatis.crypto.EncryptedField;
import lombok.Data;

/**
 * @author hubin
 * @description
 * @createTime 2024/3/6 15:30
 */
@Data
public class UserAddress {

    private Integer userId;

    @EncryptedField(encryptor = MyEncryptor.class)
    private String name;

    @EncryptedField(encryptor = MyAesEncryptor.class)
    private String email;

    @EncryptedField(encryptor = MyAesEncryptor.class)
    private String password;

    @EncryptedField(encryptor = MyAesEncryptor.class)
    private String idCardNo;

    // 使用别名也是能解密
    @EncryptedField(encryptor = MyAesEncryptor.class)
    private String userAddress;
}
