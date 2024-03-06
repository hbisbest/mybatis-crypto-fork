package io.github.whitedg.demo.encryptor;

import cn.hutool.core.util.CharsetUtil;
import cn.hutool.crypto.symmetric.SymmetricAlgorithm;
import cn.hutool.crypto.symmetric.SymmetricCrypto;
import io.github.whitedg.mybatis.crypto.IEncryptor;

/**
 * @author hubin
 * @description
 * @createTime 2024/3/5 13:57
 */
public class MyAesEncryptor implements IEncryptor {
    @Override
    public String encrypt(Object plain, String key) throws Exception {
        byte[] bytes = key.getBytes();
        SymmetricCrypto aes = new SymmetricCrypto(SymmetricAlgorithm.AES, bytes);
        return aes.encryptBase64(plain.toString());
    }

    @Override
    public String decrypt(Object cipher, String key) throws Exception {
        byte[] bytes = key.getBytes();
        SymmetricCrypto aes = new SymmetricCrypto(SymmetricAlgorithm.AES, bytes);
        return aes.decryptStr(cipher.toString(), CharsetUtil.CHARSET_UTF_8);
    }
}
