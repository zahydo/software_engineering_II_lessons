package com.unicauca.app.access;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Scalar.String;
import com.unicauca.app.domain.model.User;

public interface IUserRepository {
    public void save(User user);
    public void delete(User user);
    public User findByUsername(String username);
}
