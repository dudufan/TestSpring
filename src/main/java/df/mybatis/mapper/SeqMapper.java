package df.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SeqMapper {

    @Select("select Fn_Get_NextVal('Test_id')")
    int getSeq();

}
