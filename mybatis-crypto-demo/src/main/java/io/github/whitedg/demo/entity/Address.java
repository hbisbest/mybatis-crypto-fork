package io.github.whitedg.demo.entity;

import io.github.whitedg.demo.encryptor.MyAesEncryptor;
// import io.github.whitedg.mybatis.crypto.AES256Encryptor;
import io.github.whitedg.mybatis.crypto.EncryptedField;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author White
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class Address extends BaseEntity {

    private Integer userId;

    @EncryptedField(encryptor = MyAesEncryptor.class)
    private String address;
}
