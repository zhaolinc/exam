package exam.mapper;

import exam.domain.Uclink;
import org.apache.ibatis.annotations.Mapper;

/**
* @author Administrator
* @description 针对表【sclink】的数据库操作Mapper
* @createDate 2022-05-04 08:38:42
* @Entity exam.domain.Sclink
*/
@Mapper
public interface UclinkMapper {
    String queryno(String userno);

    Integer insert(Uclink uclink);

    Uclink query(Uclink uclink);

    Integer update(Uclink uclink);

    Integer delete(String courseno);
}
