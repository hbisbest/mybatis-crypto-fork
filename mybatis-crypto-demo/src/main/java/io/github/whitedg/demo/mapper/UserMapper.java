package io.github.whitedg.demo.mapper;

import io.github.whitedg.demo.encryptor.MyAesEncryptor;
import io.github.whitedg.demo.encryptor.MyEncryptor;
import io.github.whitedg.demo.entity.IdCard;
import io.github.whitedg.demo.entity.User;
import io.github.whitedg.demo.entity.UserAddress;
import io.github.whitedg.demo.entity.UserWithAssociation;
// import io.github.whitedg.mybatis.crypto.AES256Encryptor;
import io.github.whitedg.mybatis.crypto.EncryptedField;
// import io.github.whitedg.mybatis.crypto.StrongTextEncryptor;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author White
 */
public interface UserMapper {

    int insert(User user);

    // 不受mapped-key-prefixes属性影响，新增和更新时不指定@Param也行，会进行加密；相反在查询时必须要指定@Param而且值需要在mapped-key-prefixes中
    int batchInsert(@Param("users") List<User> users);

    int updateById(@Param("user") User user);

    int updateBatch(@EncryptedField(encryptor = MyAesEncryptor.class, key = "qwer1234qwer1234") @Param("et") String password);

    User selectById(@Param("id") Long id);

    List<User> selectList(@Param("et") User user);

    List<User> selectAll();

    @MapKey("id")
    Map<Long, User> selectMap(@Param("id") Long id);

    List<User> selectByName(@EncryptedField(encryptor = MyEncryptor.class) @Param("name") String name);

    IdCard selectIdCardByUserId(@Param("id") Long id);

    UserWithAssociation selectByIdWithAssociation(@Param("id") Long id);

    List<UserAddress> selectByUser(@Param("et") User user);
}
