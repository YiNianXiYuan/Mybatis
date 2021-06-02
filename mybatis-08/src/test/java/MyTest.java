import com.ibatis.dao.BlogMapper;
import com.ibatis.pojo.Blog;
import com.ibatis.utils.IDUtils;
import com.ibatis.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class MyTest {
    @Test
    public void test() {
        SqlSession sqlSession = MybatisUtils.getSqlsession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Blog blog = new Blog();
        blog.setId(IDUtils.getId());
        blog.setTitle("azeng");
        blog.setAuthor("sakura");
        blog.setCreateTime(new Date());
        blog.setViews(9999);

        int res = mapper.addBlog(blog);
        if (res > 0) {
            System.out.println("插入成功！");
            sqlSession.commit();
        }

        blog.setId(IDUtils.getId());
        blog.setTitle("abang");
        int res1 = mapper.addBlog(blog);
        if (res1 > 0) {
            System.out.println("插入成功！");
            sqlSession.commit();
        }
        sqlSession.close();
    }

    @Test
    public void blogTest() {
        SqlSession sqlSession = MybatisUtils.getSqlsession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap map = new HashMap<>();
        map.put("title", "争做新青年");
        map.put("author", "arise");
        List<Blog> blogs = mapper.queryBlogIF(map);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }
        sqlSession.close();
    }

    @Test
    public void blogTestChoose() {
        SqlSession sqlSession = MybatisUtils.getSqlsession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap map = new HashMap<>();
        map.put("title", "争做新青年");
        map.put("author", "arise");
        map.put("views", 9999);
        List<Blog> blogs = mapper.queryBlogChoose(map);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }
        sqlSession.close();
    }
    @Test
    public void updateBlog() {
        SqlSession sqlSession = MybatisUtils.getSqlsession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap map = new HashMap<>();

        map.put("title", "曾阿牛");
        map.put("author", "阿曾");
        map.put("id", "6874bc07-c55e-4681-9b28-d17e2e1fe470");
        int res = mapper.updateBlog(map);
        if (res > 0) {
            System.out.println("更新成功！");
        }
        sqlSession.close();
    }
    @Test
    public void queryBlogForeach() {
        SqlSession sqlSession = MybatisUtils.getSqlsession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap map = new HashMap<>();
        List<String> ids = new ArrayList<String >();
        ids.add("5d92d02d-3076-4980-a951-9302802e0fb9");
        ids.add("6874bc07-c55e-4681-9b28-d17e2e1fe470");
        map.put("ids", ids);
        List<Blog> blogs = mapper.queryBlogForeach(map);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }
        sqlSession.close();
    }
}
