package df.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface SeqMapper {

    @Select("select Fn_Get_NextVal('Test_id')")
    int getSeq();

}
