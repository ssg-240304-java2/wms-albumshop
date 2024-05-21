package bangshop.music;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static bangshop.music.common.MyBatisTemplate.getSqlSession;
import static org.assertj.core.api.Assertions.assertThat;

public class MabatisTemplateTest {

    @DisplayName("SqlSesstion객체가 정상적으로 가져올 수 있다.")
    @Test
    void test(){
        SqlSession sqlSession = getSqlSession();
        assertThat(sqlSession).isNotNull();
    }
}
