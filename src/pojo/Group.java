package pojo;

import java.util.ArrayList;
import java.util.List;

/**
 * 类<code>Doc</code>用于：TODO
 *
 * @author LuoSue
 * @version 1.0
 * @date 2021-08-06-21
 */
public class Group {
    private int _id;
    private String teacherName;
    private List<Integer> studentsId = new ArrayList<Integer>();
    private List<String> studentsName = new ArrayList<String>();

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public List<Integer> getStudentsId() {
        return studentsId;
    }

    public void setStudentsId(List<Integer> studentsId) {
        this.studentsId = studentsId;
    }

    public List<String> getStudentsName() {
        return studentsName;
    }

    public void setStudentsName(List<String> studentsName) {
        this.studentsName = studentsName;
    }

    public Group() {
    }

    public Group(int _id, String teacherName, List<Integer> studentsId, List<String> studentsName) {
        this._id = _id;
        this.teacherName = teacherName;
        this.studentsId = studentsId;
        this.studentsName = studentsName;
    }

    @Override
    public String toString() {
        return "Group{" +
                "_id=" + _id +
                ", teacherName='" + teacherName + '\'' +
                ", studentsId=" + studentsId +
                ", studentsName=" + studentsName +
                '}';
    }
}
