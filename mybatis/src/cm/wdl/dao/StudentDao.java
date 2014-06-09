package cm.wdl.dao;

import com.wdl.model.Student;
import com.wdl.model.TandS;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StudentDao {
    public void insertStudent(Student student);

    public void updateStudent(Student student);

    public List<Student> queryAllStudent();

    public List<Student> queryStudentLikeName(String name);

    public List<TandS> selectTSBySid(int sid);
}
