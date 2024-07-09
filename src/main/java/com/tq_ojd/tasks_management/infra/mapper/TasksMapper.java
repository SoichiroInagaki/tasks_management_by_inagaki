package com.tq_ojd.tasks_management.infra.mapper;

import com.tq_ojd.tasks_management.infra.entity.Tasks;
import com.tq_ojd.tasks_management.infra.entity.TasksExample;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TasksMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TASKS
     *
     * @mbg.generated Tue Jul 09 14:29:35 JST 2024
     */
    long countByExample(TasksExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TASKS
     *
     * @mbg.generated Tue Jul 09 14:29:35 JST 2024
     */
    int deleteByExample(TasksExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TASKS
     *
     * @mbg.generated Tue Jul 09 14:29:35 JST 2024
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TASKS
     *
     * @mbg.generated Tue Jul 09 14:29:35 JST 2024
     */
    int insert(Tasks row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TASKS
     *
     * @mbg.generated Tue Jul 09 14:29:35 JST 2024
     */
    int insertSelective(Tasks row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TASKS
     *
     * @mbg.generated Tue Jul 09 14:29:35 JST 2024
     */
    List<Tasks> selectByExample(TasksExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TASKS
     *
     * @mbg.generated Tue Jul 09 14:29:35 JST 2024
     */
    Tasks selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TASKS
     *
     * @mbg.generated Tue Jul 09 14:29:35 JST 2024
     */
    int updateByExampleSelective(@Param("row") Tasks row, @Param("example") TasksExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TASKS
     *
     * @mbg.generated Tue Jul 09 14:29:35 JST 2024
     */
    int updateByExample(@Param("row") Tasks row, @Param("example") TasksExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TASKS
     *
     * @mbg.generated Tue Jul 09 14:29:35 JST 2024
     */
    int updateByPrimaryKeySelective(Tasks row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TASKS
     *
     * @mbg.generated Tue Jul 09 14:29:35 JST 2024
     */
    int updateByPrimaryKey(Tasks row);
}