# Springboot project

## 环境配置：
+ Intellij IDEA 2019.3.3 x64
+ git version 2.22.0.windows.1

## 功能：
用户1：导师
* id+密码登录
* 录入学生信息、课程信息
* CURD可选学生数
* CURD课程权重

用户2：学生
* 查看导师是否处于可选状态
* 提交申请

## 实体类
    1.学生类 
         + id为学号
         + name姓名 （在填写报名时可提供校验）
         + isSelectRoot 表示根据课程成绩等内容计算后是否能被选择
         + tutor 导师类 根据是否被选择 有一个 MangToOne的映射
         + elective 与课程类有一个中间表elective 根据中间表维护与课程ManyToMany的关系
    2. 导师类
          + id
          + password 密码
          + selNum 可选学生数
          + optNum 希望选择的学生范围
          + student 与学生的ManyToOne 映射
    3. 课程类
          + id
          + name 名称
          + minGrade 最低分数线
          + weight 权重
          + elective 与选课表的映射关系
    4. elective(选课表)
          + id
          + grade 成绩
          + detail 描述
          + student
          + course

## 开发过程
### 2020.3.16
* 类的设计基本完成

### 2020.3.23
* 完善已有类，新增Direction类和DirectionElective类
* 完成实体类的jpaRepository(为解决jpaRepository没有refresh()方法，自定义一个继承自jpaRepository的接口)

### 2020.3.24
* 编写EntityTest，测试成功
    * `@EnableJpaRepositories(repositoryBaseClass = BaseRepositoryImpl.class)`告诉springboot使用自己实现的jpa容器实现类
    * |  错误   |  错误处  | 第一次解决办法  |  产生问题  |  最终解决办法  |
      |  ----  | ----  |  ----  |  ----  |  ----  |
      |  java.lang.NullPointerException |  ` Student student = studentRepository.findByID(2017224446).orElse(null);`  | 设置断言`Assertions.assertNotNull(student);` |  org.opentest4j.AssertionFailedError: expected: not <null>  |  自定义查询`Student findByStudentID(int studentID);`  |


