package exam.service;

import exam.domain.Uclink;

/**
* @author Administrator
* @description 针对表【sclink】的数据库操作Service
* @createDate 2022-05-04 08:38:42
*/
public interface UclinkService {
    String queryno(String userno);
    Uclink query(Uclink uclink);
    Integer insert(Uclink uclink);
    Integer update(Uclink uclink);
    Integer delete(String courseno);
}
