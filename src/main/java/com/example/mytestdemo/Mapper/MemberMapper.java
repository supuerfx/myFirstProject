package com.example.mytestdemo.Mapper;

import com.example.mytestdemo.pojo.Member;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MemberMapper {

    @Select("select * from member")
    List<Member> findAll();

    @Insert("insert into member (name) values (#{name})")
    void saveMember(Member member);

    @Delete("delete from member where id=#{id}")
    void deleteMemberById(int id);

    @Select("select * from member where id=#{id}")
    Member getMemberById(int id);

    @Update("Update member set name=#{name} where id=#{id}")
    void update(Member member);
}
