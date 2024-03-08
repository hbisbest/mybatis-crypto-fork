package io.github.whitedg.demo.entity;

import io.github.whitedg.demo.encryptor.MyAesEncryptor;
// import io.github.whitedg.mybatis.crypto.Base64Encryptor;
import io.github.whitedg.mybatis.crypto.EncryptedField;
// import io.github.whitedg.mybatis.crypto.StrongTextEncryptor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDate;

/**
 * @author White
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class User extends SimpleUser {

    @EncryptedField(encryptor = MyAesEncryptor.class)
    private String email;

    @EncryptedField(encryptor = MyAesEncryptor.class, key = "qwer1234qwer1234")
    private String password;

    @EncryptedField
    private String idCardNo;

    // 测试发现不支持String以外的字段类型
    @EncryptedField(encryptor = MyAesEncryptor.class, key = "qwer1234qwer1234")
    private LocalDate birthday;
}
